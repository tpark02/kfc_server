package com.example.kfc.service;

import com.example.kfc.Response.RandomSquadResponse;
import com.example.kfc.data.FormationUtil;
import com.example.kfc.dto.*;
import com.example.kfc.entity.Player;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.manager.LockManager;
import com.example.kfc.repository.LeagueRepository;
import com.example.kfc.repository.TeamLogoRepository;
import com.example.kfc.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class RandomTeamService {
    public static int totalPlayersCount = 27;
    public static int startingPlayerCount = 17;
    public static int aiPlayersCount = 17;
    public static int benchPlayerCount = 6;
    public static int reservePlayerCount = 10;

    private final PlayerService playerService;
    private final UserInfoService userInfoService;
    private final Random random = new Random();
    private final LockManager<Long> userLockManager = new LockManager<>();
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;

    public RandomSquadResponse generateRandomTeamByPosition(String formation, List<CountryDto> countries,
                                                            List<LeagueDto> leagues, List<TeamDto> clubs, Long userId) {

        userLockManager.lock(userId);
        try {
            List<String> positionRequirement = FormationUtil.formationPosition.get(formation);

            if (positionRequirement == null) {
                throw new IllegalArgumentException("❌ Formation does not exist: " + formation);
            }

            List<Player> playersPool = playerService.searchPlayersByFilters(countries, leagues, clubs).stream()
                    .filter(p -> !p.getPos().isEmpty() && !p.getName().equals("dummy"))
                    .collect(Collectors.toList());

            if (playersPool.isEmpty()) {
                throw new IllegalStateException("❌ No players found matching the filter criteria.");
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
                    throw new IllegalStateException("❌ No available players for position: [" + pos + "]");
                }

                selectedPlayers.add(candidates.get(0));
            }

            if (selectedPlayers.size() != 11) {
                throw new IllegalStateException("❌ Failed to select exactly 11 players. Current count: " + selectedPlayers.size());
            }

            List<MyPlayerDto> lst = new ArrayList<>();

            IntStream.range(0, selectedPlayers.size()).forEach(i -> {
                Player p = selectedPlayers.get(i);
                MyPlayerDto myPlayerDto = MyPlayerDto.from(p, userId, 1L, 0L, 0L, (long) i);
                lst.add(myPlayerDto);
            });

            List<MyPlayerDto> benchPlayers = IntStream.range(0, benchPlayerCount)
                    .mapToObj(i -> {
                        return MyPlayerDto.from(
                                playersPool.get(i),
                                userId,
                                1L,
                                0L,
                                0L,
                                (long) (i + 11)
                                               );
                    })
                    .toList();

            lst.addAll(benchPlayers);

            Player dummy = playerService.findMaxId();
            List<MyPlayerDto> buyPlayers = IntStream.range(0, reservePlayerCount)
                    .mapToObj(i -> {
                        return MyPlayerDto.from(
                                dummy,
                                userId,
                                1L,
                                0L,
                                0L,
                                (long) (i + 17)
                                               );
                    })
                    .toList();

            lst.addAll(buyPlayers);

            double avg = IntStream.range(0, Math.min(17, lst.size()))
                    .mapToLong(i -> lst.get(i).getOvr())
                    .average()
                    .orElse(0.0);

            Long myTeamOvr = (long) avg;

            Long squadValue = lst.stream()
                    .mapToLong(p -> FormationUtil.estimateValue(p, MyPlayerDto::getOvr, MyPlayerDto::getPos, MyPlayerDto::getName))
                    .sum();

            Map<String, Long> atkdef = FormationUtil.getDefenseAttackSplit(lst, MyPlayerDto::getDef, MyPlayerDto::getSho);
            Long atk = atkdef.get("attack");
            Long def = atkdef.get("defense");

            Long pace = FormationUtil.getAverageStat(lst, MyPlayerDto::getPac);
            Long age = FormationUtil.getAverageStat(lst, MyPlayerDto::getAge);
            Long stamina = FormationUtil.getAverageStat(lst, MyPlayerDto::getStamina);
            Long cohesion = FormationUtil.getClubCohesion(lst, MyPlayerDto::getTeam);
            int chemistry = calculateChemistry(selectedPlayers);

            UserInfo user = userInfoService.getUserById(userId);

            lst.stream().filter(p -> p.getLeagueId() != null).forEach(p -> {
                var league = leagueRepository.findById(p.getLeagueId())
                        .orElseThrow(() -> new IllegalArgumentException("❌ League URL not found - league id: " + p.getLeagueId()));
                p.setLeagueUrl(league.getUrl());
            });

            lst.stream().filter(p -> p.getTeamId() != null).forEach(t -> {
                var team = teamRepository.findById(t.getTeamId())
                        .orElseThrow(() -> new IllegalArgumentException("❌ Team URL not found - team id: " + t.getTeamId()));
                t.setTeamUrl(team.getUrl());
            });

            return RandomSquadResponse.builder()
                    .myPlayerList(lst)
                    .myTeamOvr(myTeamOvr)
                    .myTeamClubCohesion((long) chemistry)
                    .myTeamStamina(stamina)
                    .myTeamAge(age)
                    .myTeamAtk(atk)
                    .myTeamDef(def)
                    .myTeamPace(pace)
                    .myTeamSquadValue(squadValue)
                    .build();
        } catch (Exception e) {
            userLockManager.unlock(userId);
            log.info("⚠️ Error generating random team - {}", e.getMessage());
            throw new RuntimeException(e);
        } finally {
            userLockManager.unlock(userId);
        }
    }

    public int calculateChemistry(List<Player> players) {
        int chemistry = 0;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals("dummy"))
                continue;

            for (int j = i + 1; j < players.size(); j++) {
                Player p1 = players.get(i);
                Player p2 = players.get(j);

                if (p1.getNation().equals(p2.getNation())) {
                    chemistry += 5;
                }
                if (p1.getLeague().equals(p2.getLeague())) {
                    chemistry += 3;
                }
                if (p1.getTeam().equals(p2.getTeam())) {
                    chemistry += 7;
                }
            }
        }

        return chemistry;
    }
}
