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
    public static int numberOfTotalPlayers = 17;
    public static int numberOfBenchPlayers = 6;
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

        UserInfo user =
                userInfoService.getUserById(1L);    // TODO : when account system added, this should come from userId from the front-end
        // bench players
        List<PlayerDto> benchplayers = playersPool.stream()
                .limit(numberOfBenchPlayers)
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
                .build();
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
