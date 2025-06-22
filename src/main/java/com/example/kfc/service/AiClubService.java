package com.example.kfc.service;

import com.example.kfc.data.FormationUtil;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.entity.Player;
import com.example.kfc.manager.LockManager;
import com.example.kfc.repository.AiClubRepository;
import com.example.kfc.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class AiClubService {
    private final AiClubRepository aiClubRepository;
    private final PlayerService playerService;
    private final AiFormationService aiFormationService;
    private final UserInfoRepository userInfoRepository;

    private final LockManager<Long> userLockManager = new LockManager<>();

    public void updateAiClubAndFormation(Long clubId, String formation, Long ovr) {
        List<String> positionRequirement = FormationUtil.formationPosition.get(formation);

        if (positionRequirement == null) {
            throw new IllegalArgumentException("AI - No such formation - " + formation);
        }

        List<Player> playersPool = playerService.searchPlayersByOvr(ovr);

        if (playersPool.isEmpty()) {
            throw new IllegalStateException("AI - There are no players with ovr - " + ovr);
        }

        Collections.shuffle(playersPool);

        Map<String, List<Player>> playersByPosition = playersPool.stream()
                .collect(Collectors.groupingBy(p -> p.getPos().toUpperCase()));

        List<Player> selectedPlayers = new ArrayList<>();

        for (var pos : positionRequirement) {
            List<Player> candidates = playersByPosition.get(pos);

            if (candidates == null || candidates.isEmpty()) {
                for (String key : playersByPosition.keySet()) {
                    if (pos.startsWith(key)) {
                        candidates = playersByPosition.get(key);
                        break;
                    }
                }
            }

            if (candidates == null) {
                candidates = Collections.emptyList();
            }

            Collections.shuffle(candidates);

            if (candidates == null || candidates.isEmpty()) {
                throw new IllegalStateException("[" + pos + "] No available candidate players.");
            }
            selectedPlayers.add(candidates.get(0));
        }

        if (selectedPlayers.size() != 11) {
            throw new IllegalStateException("Could not complete 11 players. Current count: " + selectedPlayers.size());
        }

        List<PlayerDto> lst = new ArrayList<>();
        Set<Integer> usedIds = new HashSet<>();

        selectedPlayers.stream().forEach(p -> {
            lst.add(PlayerDto.from(p));
        });

        double avg = IntStream.range(0, Math.min(17, lst.size()))
                .mapToLong(i -> lst.get(i).getOvr())
                .average()
                .orElse(0.0);

        Long myTeamOvr = (long) avg;

        Long squadValue = lst.stream()
                .mapToLong(p -> FormationUtil.estimateValue(p, PlayerDto::getOvr, PlayerDto::getPos, PlayerDto::getName))
                .sum();

        Long pace = FormationUtil.getAverageStat(lst, PlayerDto::getPac);
        Long age = FormationUtil.getAverageStat(lst, PlayerDto::getAge);
        Long stamina = FormationUtil.getAverageStat(lst, PlayerDto::getStamina);

        Map<String, Long> split = FormationUtil.getAttackDefenseSplit(lst, PlayerDto::getSho, PlayerDto::getDef);
        Long attack = split.get("attack");
        Long defense = split.get("defense");

        Long cohesion = FormationUtil.getClubCohesion(lst, PlayerDto::getTeam);

        updateAiClub(clubId, ovr, squadValue, age, pace, defense, attack, cohesion, stamina);

        List<PlayerDto> benchplayers = playersPool.stream()
                .limit(RandomTeamService.aiPlayersCount)
                .map(PlayerDto::from)
                .toList();

        lst.addAll(benchplayers);

        List<Player> playerList = lst.stream()
                .map(PlayerDto::toEntity)
                .toList();

        List<Integer> playerIds = playerList.stream()
                .limit(RandomTeamService.aiPlayersCount)
                .map(p -> p.getId().intValue())
                .toList();

        if (playerIds.size() < RandomTeamService.aiPlayersCount) {
            throw new IllegalStateException(String.format("You need %d players", playerIds.size()));
        }

        aiFormationService.updateFormationPlayers(clubId,
                                                  formation,
                                                  playerIds.get(0),
                                                  playerIds.get(1),
                                                  playerIds.get(2),
                                                  playerIds.get(3),
                                                  playerIds.get(4),
                                                  playerIds.get(5),
                                                  playerIds.get(6),
                                                  playerIds.get(7),
                                                  playerIds.get(8),
                                                  playerIds.get(9),
                                                  playerIds.get(10),
                                                  playerIds.get(11),
                                                  playerIds.get(12),
                                                  playerIds.get(13),
                                                  playerIds.get(14),
                                                  playerIds.get(15),
                                                  playerIds.get(16));
    }

    public void updateAiClub(Long userId, Long ovr, Long price, Long age, Long pace, Long def, Long atk, Long cch, Long stm) {
        try {
            aiClubRepository.updateClubInfoById(userId, ovr, price, age, pace, def, atk, cch, stm);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "ai - updateAiClub - not updated : " + userId + ", " + ovr + ", " + price + ", " + age + ", " + pace + ", " + def + ", " + atk + ", " + cch + ", " + stm);
        }
    }
}
