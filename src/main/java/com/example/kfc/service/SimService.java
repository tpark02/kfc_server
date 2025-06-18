package com.example.kfc.service;

import com.example.kfc.Response.SimResultResponse;
import com.example.kfc.dto.MatchDto;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.dto.TeamStatDto;
import com.example.kfc.entity.Team;
import com.example.kfc.manager.LockManager;
import com.example.kfc.repository.PlayerRepository;
import com.example.kfc.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

@Slf4j
@Service
public class SimService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    MyClubService myClubService;

    private final LockManager<Long> userLockManager = new LockManager<>();

    public SimResultResponse simulateLeague(List<String> teams) {
        Map<String, TeamStatDto> table = new HashMap<>();
        List<String> logs = new ArrayList<>();

        for (String team : teams) {
            table.put(team, new TeamStatDto(1, 2, 3, 4, 5, 6));
        }

        for (int i = 0; i < teams.size(); i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                String teamA = teams.get(i);
                String teamB = teams.get(j);

                int goalsA = (int) (Math.random() * 5);
                int goalsB = (int) (Math.random() * 5);

                logs.add(teamA + " " + goalsA + " - " + goalsB + " " + teamB);

                TeamStatDto statA = table.get(teamA);
                TeamStatDto statB = table.get(teamB);

                statA.gf += goalsA;
                statA.ga += goalsB;
                statB.gf += goalsB;
                statB.ga += goalsA;

                if (goalsA > goalsB) {
                    statA.wins++;
                    statA.pts += 3;

                    statB.losses++;
                } else if (goalsA < goalsB) {
                    statB.wins++;
                    statB.pts += 3;
                    statA.losses++;
                } else {
                    statA.draws++;
                    statB.draws++;
                    statA.pts++;
                    statB.pts++;
                }
            }
        }
        return new SimResultResponse(table, logs);
    }

    public List<MatchDto> generateRandomSchedule(Long userId, Long clubId) {
        userLockManager.lock(userId);

        try {
            List<Long> excludedIds = List.of(12L, 37L, 107L, 174L, 297L, 400L, 557L, 683L);
            List<Team> teams = teamRepository.findRandom20TeamsExcluding(excludedIds);

            if (teams.size() < 2) {
                throw new IllegalStateException("2개 이상의 팀이 필요합니다.");
            }

            // 홀수일 경우 BYE 팀 추가
            if (teams.size() % 2 != 0) {
                teams.add(new Team("BYE"));
            }

            // 사용자 클럽 정보 가져오기
            var club = myClubService.getClubByUserId(userId);
            List<MatchDto> schedule = new ArrayList<>();

            for (int i = 0; i < teams.size(); i++) {
                String teamImg = teams.get(i).getUrl();
                String opponentTeam = teams.get(i).getTeam();
                Long teamId = teams.get(i).getId();

                // 평균 OVR 조회
                Long avgOvr = playerRepository.avgOvrTeam(teamId);

                System.out.println("team id : " + teamId);
                // 선수 목록 조회
                List<PlayerDto> members = playerRepository.searchClub(teamId)
                        .stream()
                        .map(PlayerDto::from)
                        .toList();

                // 승패 계산
                String result = club.getOvr() > avgOvr ? "W" : "L";

                // 매치 생성 및 추가
                schedule.add(new MatchDto(
                        club.getName(),
                        opponentTeam,
                        i + 1,
                        avgOvr,
                        result,
                        members,
                        0L,
                        teamImg
                ));
            }

            // add stats to the won matches
            schedule.forEach(m -> {
                if (m.getRes().equals("W")) {
                    m.setAddStats(1L);
                }
            });
            return schedule;
        } catch (Exception e) {
            log.error("❌ Failed to generate schedule", e);
            return Collections.emptyList();
        } finally {
            userLockManager.unlock(userId);
        }
    }
}
