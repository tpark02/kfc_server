package com.example.kfc.service;

import com.example.kfc.Response.RandomSquadResponse;
import com.example.kfc.data.FormationPositionCounts;
import com.example.kfc.dto.CountryDto;
import com.example.kfc.dto.LeagueDto;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.dto.TeamDto;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RandomTeamService {
    private final PlayerService playerService;
    private final PlayerRepository playerRepository;
    private final Random random = new Random();

    public RandomSquadResponse generateRandomTeamByPosition(String formation, List<CountryDto> countries, List<LeagueDto> leagues, List<TeamDto> clubs) {
        LinkedHashMap<String, Integer> positionRequirement =
                FormationPositionCounts.FORMATION_POSITION_COUNTS.get(
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

        for (Map.Entry<String, Integer> entry : positionRequirement.entrySet()) {
            String pos = entry.getKey();
            int requiredCount = entry.getValue();

            List<Player> candidates = playersByPosition.getOrDefault(pos, Collections.emptyList());

            if (candidates.size() < requiredCount) {
                if (pos.equals("RM") == true || pos.equals("CDM") == true) {
                    List<Player> cdm = playersByPosition.getOrDefault("CDM", Collections.emptyList());
                    List<Player> cam = playersByPosition.getOrDefault("CAM", Collections.emptyList());
                    List<Player> cm = playersByPosition.getOrDefault("CM", Collections.emptyList());

                    // 후보 리스트에 추가
                    List<Player> mergedCandidates = new ArrayList<>(candidates);
                    mergedCandidates.addAll(cdm);
                    mergedCandidates.addAll(cam);
                    mergedCandidates.addAll(cm);

                    candidates = mergedCandidates; // 새로 합친 리스트로 덮어쓰기
                }
                else {
                    throw new IllegalStateException(
                            "포지션 [" + pos + "]에 필요한 선수 수(" + requiredCount + "명)보다 후보가 부족합니다. (현재 후보: " + candidates.size() + "명)");
                }
            }

            // 후보를 다시 섞어도 되고, 그냥 앞에서부터 뽑아도 됨
            Collections.shuffle(candidates);

            if (!candidates.isEmpty()) {
                int actualCount = Math.min(requiredCount, candidates.size());
                selectedPlayers.addAll(candidates.subList(0, actualCount));
            }
        }

        // 최종적으로 정확히 11명만 선택됐는지 체크
        if (selectedPlayers.size() != 11) {
            throw new IllegalStateException("선수 11명을 완성할 수 없습니다. 현재 인원: " + selectedPlayers.size());
        }

        int chemistry = calculateChemistry(selectedPlayers);

        List<PlayerDto> lst = new ArrayList<>();
        Set<Integer> usedIds = new HashSet<>();

        positionRequirement.forEach((pos, count) -> {
            selectedPlayers.stream()
                    .filter(p -> pos.equals(p.getPos()) && !usedIds.contains(p.getId()))
                    .limit(count)
                    .forEach(p -> {
                        usedIds.add(Math.toIntExact(p.getId()));
                        lst.add(PlayerDto.from(p));
                    });
        });

        return  RandomSquadResponse.builder()
                .content(lst)
                .chemistry(chemistry)
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
