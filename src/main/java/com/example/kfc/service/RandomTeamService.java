package com.example.kfc.service;

import com.example.kfc.Response.RandomSquadResponse;
import com.example.kfc.data.FormationUtil;
import com.example.kfc.dto.*;
import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.Player;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.manager.LockManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@RequiredArgsConstructor
public class RandomTeamService {
    public static int numberOfTotalPlayers = 27;
    public static int numberOfAiPlayers = 17;
    public static int numberOfBenchPlayers = 6;
    public static int numberOfBuyPlayers = 10;

    private final PlayerService playerService;
    private final UserInfoService userInfoService;
    private final Random random = new Random();
    private final LockManager<Long> userLockManager = new LockManager<>();

    public RandomSquadResponse generateRandomTeamByPosition(String formation, List<CountryDto> countries,
                                                            List<LeagueDto> leagues, List<TeamDto> clubs, Long userId) {

        userLockManager.lock(userId);
        try {
            List<String> positionRequirement =
                    FormationUtil.formationPosition.get(
                            formation);

            if (positionRequirement == null) {
                throw new IllegalArgumentException("존재하지 않는 포메이션입니다: " + formation);
            }

            List<Player> playersPool = playerService.searchPlayersByFilters(countries, leagues, clubs);

            if (playersPool.isEmpty()) {
                throw new IllegalStateException("필터 조건에 맞는 선수가 없습니다.");
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

            int chemistry = calculateChemistry(selectedPlayers);

            List<MyPlayerDto> lst = new ArrayList<>();
            Set<Integer> usedIds = new HashSet<>();
            IntStream.range(0, selectedPlayers.size()).forEach(i -> {
                Player p = selectedPlayers.get(i);
                MyPlayerDto myPlayerDto = MyPlayerDto.from(p, userId, 1L, 0L, 0L, (long) i);
                lst.add(myPlayerDto);
            });

            //my team ovr 계산
            double avg = lst.stream().mapToLong(MyPlayerDto::getOvr).average().orElse(0.0);
            System.out.println("random formation - avg: " + avg);

            Long myTeamOvr = (long) avg;

            System.out.println("random formation - long avg: " + myTeamOvr);

            // total squad value
            Long squadValue = lst.stream()
                    .mapToLong(p -> FormationUtil.estimateValue(p, MyPlayerDto::getOvr, MyPlayerDto::getPos,
                                                                MyPlayerDto::getName))
                    .sum();

            // atk, def
            Map<String, Long> atkdef = FormationUtil.getDefenseAttackSplit(lst, MyPlayerDto::getDef,
                                                                           MyPlayerDto::getSho);
            Long atk = atkdef.get("attack");
            Long def = atkdef.get("defense");

            Long pace = FormationUtil.getAverageStat(lst, MyPlayerDto::getPac);
            Long age = FormationUtil.getAverageStat(lst, MyPlayerDto::getAge);
            Long stamina = FormationUtil.getAverageStat(lst, MyPlayerDto::getStamina);
            Long cohesion = FormationUtil.getClubCohesion(lst, MyPlayerDto::getTeam);

            UserInfo user =
                    userInfoService.getUserById(
                            1L);    // TODO : when account system added, this should come from userId from the front-end
            // bench players
            List<MyPlayerDto> benchPlayers = IntStream.range(0, numberOfBenchPlayers)
                    .mapToObj(i -> {
                        MyPlayerDto dto = MyPlayerDto.from(
                                playersPool.get(i),
                                userId,
                                1L,     // clubId
                                0L,     // yellowCard
                                0L,     // redCard
                                (long) (i + 11) // idx: 11부터 시작
                                                          );
                        return dto;
                    })
                    .toList();


            lst.addAll(benchPlayers);

            // buy players
            Player dummy = playerService.findMaxId();
            List<MyPlayerDto> buyPlayers = IntStream.range(0, numberOfBuyPlayers)
                    .mapToObj(i -> {
                        MyPlayerDto dto = MyPlayerDto.from(
                                dummy,
                                userId,
                                1L,     // clubId
                                0L,     // yellowCard
                                0L,     // redCard
                                (long) (i + 17) // idx: 11부터 시작
                                                          );
                        return dto;
                    })
                    .toList();

            lst.addAll(buyPlayers);

//        // setting idx to playerDto
//        IntStream.range(0, lst.size())
//                .forEach(i -> lst.get(i).setIdx((long) i));

            return RandomSquadResponse.builder()
                    .myPlayerList(lst)
                    .chemistry((long) chemistry)
                    .myTeamOvr(myTeamOvr)
                    .myTeamSquadValue(squadValue)
                    .myTeamAge(age)
                    .myTeamClubCohesion(cohesion)
                    .myTeamAtk(atk)
                    .myTeamDef(def)
                    .myTeamPace(pace)
                    .myTeamStamina(stamina)
                    .build();
        } finally {
            userLockManager.unlock(userId);
        }
    }

    public int calculateChemistry(List<Player> players) {
        int chemistry = 0;

        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                Player p1 = players.get(i);
                Player p2 = players.get(j);

                if (p1.getNation().equals(p2.getNation())) {
                    chemistry += 5; // 같은 국가
                }
                if (p1.getLeague().equals(p2.getLeague())) {
                    chemistry += 3; // 같은 리그
                }
                if (p1.getTeam().equals(p2.getTeam())) {
                    chemistry += 7; // 같은 팀
                }
            }
        }

        return chemistry;
    }
}
