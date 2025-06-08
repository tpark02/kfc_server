package com.example.kfc.service;

import com.example.kfc.data.FormationUtil;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.AiClubRepository;
import com.example.kfc.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AiClubService {
    private final AiClubRepository aiClubRepository;
    private final PlayerService playerService;
    private final AiFormationService aiFormationService;
    private final UserInfoRepository userInfoRepository;

    public void updateAiClubAndFormation(Long clubId, String formation, Long ovr) {
        List<String> positionRequirement =
                FormationUtil.formationPosition.get(
                        formation);

        if (positionRequirement == null) {
            throw new IllegalArgumentException("AI - No such formation - " + formation);
        }

        List<Player> playersPool = playerService.searchPlayersByOvr(ovr);

        if (playersPool.isEmpty()) {
            throw new IllegalStateException("AI - There are no players with ovr - " + ovr);
        }

        // 전체 선수 풀을 섞기
        Collections.shuffle(playersPool);

        // 포지션별 그룹 만들기
        Map<String, List<Player>> playersByPosition = playersPool.stream()
                .collect(Collectors.groupingBy(p -> p.getPos().toUpperCase())); // 대소문자 무시 대비

        List<Player> selectedPlayers = new ArrayList<>();

        for (var pos : positionRequirement) {
            List<Player> candidates = playersByPosition.get(pos);

            if (candidates == null || candidates.isEmpty()) {
                // Try to match prefix, e.g. "CDM1" → "CDM"
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

            // 후보를 다시 섞어도 되고, 그냥 앞에서부터 뽑아도 됨
            Collections.shuffle(candidates);

            if (candidates == null || candidates.isEmpty()) {
                throw new IllegalStateException("[" + pos + "] 포지션에 사용할 수 있는 후보 선수가 없습니다.");
            }
            selectedPlayers.add(candidates.get(0));
        }

        // 최종적으로 정확히 11명만 선택됐는지 체크
        if (selectedPlayers.size() != 11) {
            throw new IllegalStateException("선수 11명을 완성할 수 없습니다. 현재 인원: " + selectedPlayers.size());
        }

        //int chemistry = randomTeamService.calculateChemistry(selectedPlayers);

        List<PlayerDto> lst = new ArrayList<>();
        Set<Integer> usedIds = new HashSet<>();

        selectedPlayers.stream().forEach(p -> {
            lst.add(PlayerDto.from(p));
        });

        //my team ovr 계산
        double avg = lst.stream().mapToLong(PlayerDto::getOvr).average().orElse(0.0);
        System.out.println("random formation - avg: " + avg);

        Long myTeamOvr = (long) avg;

        System.out.println("random formation - long avg: " + myTeamOvr);

        // total squad value
        Long squadValue = lst.stream()
                .mapToLong(p -> FormationUtil.estimateValue(p, PlayerDto::getOvr, PlayerDto::getPos, PlayerDto::getName))
                .sum();

        Long pace =
                FormationUtil.getAverageStat(lst
                        , PlayerDto::getPac);
        Long age = FormationUtil.getAverageStat(lst, PlayerDto::getAge);
        Long stamina = FormationUtil.getAverageStat(lst, PlayerDto::getStamina);

        Map<String, Long> split = FormationUtil.getAttackDefenseSplit(lst, PlayerDto::getSho, PlayerDto::getDef);
        Long attack = split.get("attack");
        Long defense = split.get("defense");

        Long cohesion = FormationUtil.getClubCohesion(lst, PlayerDto::getTeam);


        // update ai club
        //CLUB_ID  	NAME  	USER_ID  	OVR  	PRICE  	AGE  	PACE  	DEF  	ATK  	CCH  	STM
        updateAiClub(clubId, ovr, squadValue, age,
                     pace, defense, attack,
                     cohesion,
                     stamina);

        // bench players
        List<PlayerDto> benchplayers = playersPool.stream()
                .limit(RandomTeamService.numberOfAiPlayers)
                .map(PlayerDto::from)
                .toList();

        lst.addAll(benchplayers);

        List<Player> playerList = lst.stream()
                .map(PlayerDto::toEntity)
                .toList();

        List<Integer> playerIds = playerList.stream()
                .limit(RandomTeamService.numberOfAiPlayers)
                .map(p -> p.getId().intValue())
                .toList();

        if (playerIds.size() < RandomTeamService.numberOfAiPlayers) {
            throw new IllegalStateException(String.format("You need %d players", playerIds.size()));
        }

        // update ai formation
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

    //CLUB_ID  	NAME  	USER_ID  	OVR  	PRICE  	AGE  	PACE  	DEF  	ATK  	CCH  	STM
    public void updateAiClub(Long userId, Long ovr, Long price, Long age, Long pace, Long def, Long atk, Long cch, Long stm) {
        try {
            aiClubRepository.updateClubInfoById(userId, ovr, price, age, pace, def, atk, cch, stm);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "ai - updateAiClub - not updated : " + userId + ", " + ovr + ", " + price + ", " + age + ", " + pace + ", " + def + ", " + atk + ", " + cch + ", " + stm);
        }
    }
}
