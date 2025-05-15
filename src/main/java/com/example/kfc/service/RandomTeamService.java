package com.example.kfc.service;

import com.example.kfc.Response.RandomSquadResponse;
import com.example.kfc.data.FormationUtil;
import com.example.kfc.dto.CountryDto;
import com.example.kfc.dto.LeagueDto;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.dto.TeamDto;
import com.example.kfc.entity.Player;
import com.example.kfc.entity.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RandomTeamService {
    private final PlayerService playerService;
    private final UserInfoService userInfoService;
    private final Random random = new Random();

    public RandomSquadResponse generateRandomTeamByPosition(String formation, List<CountryDto> countries, List<LeagueDto> leagues, List<TeamDto> clubs) {
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
//            int requiredCount = entry.getValue();
//            List<Player> candidates = playersByPosition.getOrDefault(pos, Collections.emptyList());
//            if (candidates.size() < requiredCount) {
//                if (pos.equals("RM") == true || pos.equals("CDM") == true) {
//                    List<Player> cdm = playersByPosition.getOrDefault("CDM", Collections.emptyList());
//                    List<Player> cam = playersByPosition.getOrDefault("CAM", Collections.emptyList());
//                    List<Player> cm = playersByPosition.getOrDefault("CM", Collections.emptyList());
//
//                    // 후보 리스트에 추가
//                    List<Player> mergedCandidates = new ArrayList<>(candidates);
//                    mergedCandidates.addAll(cdm);
//                    mergedCandidates.addAll(cam);
//                    mergedCandidates.addAll(cm);
//
//                    candidates = mergedCandidates; // 새로 합친 리스트로 덮어쓰기
//                }
//                else {
//                    throw new IllegalStateException(
//                            "포지션 [" + pos + "]에 필요한 선수 수(" + requiredCount + "명)보다 후보가 부족합니다. (현재 후보: " + candidates.size() + "명)");
//                }
//            }

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

        List<PlayerDto> lst = new ArrayList<>();
        Set<Integer> usedIds = new HashSet<>();

//        positionRequirement.forEach((pos, count) -> {
//            selectedPlayers.stream()
//                    .filter(p -> pos.equals(p.getPos()) && !usedIds.contains(p.getId()))
//                    .limit(count)
//                    .forEach(p -> {
//                        usedIds.add(Math.toIntExact(p.getId()));
//                        lst.add(PlayerDto.from(p));
//                    });
//        });

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
                .mapToLong(FormationUtil::estimateValue)
                .sum();
        // atk, def
        Map<String, Long> atkdef = FormationUtil.getDefenseAttackSplit(lst);
        Long atk = atkdef.get("attack");
        Long def = atkdef.get("defense");

        // get PaceIndex
        Long paceIndex = FormationUtil.getPaceIndex(lst);
        // get TeamAge
        Long teamAge = FormationUtil.getTeamAge(lst);
        // club cohesion
        Long clubCohesion = FormationUtil.getClubCohesion(lst);
        // stamina
        Long teamStamina = FormationUtil.getTeamStamina(lst);

        UserInfo user = userInfoService.getUserById(1L);
        // bench players
        List<PlayerDto> benchplayers = playersPool.stream()
                .limit(15)
                .map(PlayerDto::from)
                .toList();

        lst.addAll(benchplayers);

        return  RandomSquadResponse.builder()
                .content(lst)
                .chemistry((long) chemistry)
                .myTeamOvr(myTeamOvr)
                .myTeamSquadValue(squadValue)
                .myTeamAge(teamAge)
                .myTeamClubCohesion(clubCohesion)
                .myTeamAtk(atk)
                .myTeamDef(def)
                .myTeamPace(paceIndex)
                .myTeamStamina(teamStamina)
//                .myTeamName(user.getTeamName())
//                .benchPlayers(benchplayers)
                .build();
    }

    private int calculateChemistry(List<Player> players) {
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
