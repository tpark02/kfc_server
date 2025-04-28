package com.example.kfc.service;

import com.example.kfc.Response.RandomSquadResponse;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RandomTeamService {

    private final PlayerRepository playerRepository;
    private final Random random = new Random();

    public RandomSquadResponse generateRandomTeam() {
        List<Player> allPlayers = playerRepository.findAll();

        if (allPlayers.size() < 11) {
            throw new IllegalStateException("선수가 11명 미만입니다.");
        }

        // 선수 섞기
        Collections.shuffle(allPlayers);

        // 11명 뽑기
        List<Player> selectedPlayers = allPlayers.subList(0, 11);

        // Chemistry 간단 계산 (예: 같은 국가/리그 수 만큼 점수)
        int chemistry = calculateChemistry(selectedPlayers);

        return RandomSquadResponse.builder()
                .content(selectedPlayers.stream().map(PlayerDto::from).collect(Collectors.toList()))
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
