package com.example.kfc.service;

import com.example.kfc.Response.SimResultResponse;
import com.example.kfc.dto.MatchDto;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.dto.TeamStatDto;
import com.example.kfc.entity.Team;
import com.example.kfc.repository.PlayerRepository;
import com.example.kfc.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

@Slf4j
@Service
public class SimService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    public SimResultResponse simulateLeague(List<String> teams) {
        Map<String, TeamStatDto> table = new HashMap<>();
        List<String> logs = new ArrayList<>();

        for (String team : teams) {
            table.put(team, new TeamStatDto(1,2,3,4,5,6));
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

    public List<MatchDto> generateRandomSchedule(String myTeamName, List<PlayerDto> myTeamMembers) {
        AtomicReference<String> opponent = null;
        try {
            List<Team> teams = teamRepository.findRandom20Teams();

            if (teams.size() < 2) {
                throw new IllegalStateException("2개 이상의 팀이 필요합니다.");
            }

            // 홀수면 BYE 팀 추가
            if (teams.size() % 2 != 0) {
                teams.add(new Team("BYE"));
            }

            myTeamMembers.forEach(p -> System.out.println("ovr: " + p.getOvr()));

            double avg = myTeamMembers.stream()
                    .mapToLong(PlayerDto::getOvr)
                    .average()
                    .orElse(0.0);

            System.out.println("avg: " + avg);

            Long myTeamOvr = (long) avg;
            System.out.println("long avg: " + myTeamOvr);

            List<MatchDto> schedule = new ArrayList<>();
            opponent = new AtomicReference<>("");

            AtomicReference<String> finalOpponent = opponent;
            IntStream.range(0, teams.size())
                    .forEach(i -> {
                        finalOpponent.set(teams.get(i).getTeam());
                        Long avgOvr = playerRepository.avgOvrTeam(finalOpponent.get().toLowerCase());
                        String res = myTeamOvr > avgOvr ? "W" : "L";
                        schedule.add(new MatchDto(myTeamName, finalOpponent.toString(), i + 1, avgOvr, res));
                    });

            return schedule;
        } catch (Exception e) {
            log.info(String.valueOf(opponent));
            log.info(e.toString());
            return null;
        }
    }
}
