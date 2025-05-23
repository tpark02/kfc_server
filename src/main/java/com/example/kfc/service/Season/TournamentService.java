package com.example.kfc.service.Season;

import com.example.kfc.entity.Season.Match;
import com.example.kfc.entity.Season.Season;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.Season.MatchRepository;
import com.example.kfc.repository.Season.SeasonParticipantRepository;
import com.example.kfc.repository.Season.SeasonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TournamentService {
    private final SeasonRepository seasonRepository;
    private final SeasonParticipantRepository participantRepository;
    private final MatchRepository matchRepository;

    public void tryStartTournament(Season season) {
        try {
            if (season.isStarted()) return;

            List<SeasonParticipant> participants = participantRepository.findBySeason(season);

            // ✅ 실제로 유저가 배정된 참가자 수만 필터링
            long assignedCount = participants.stream()
                    .filter(p -> p.getUser() != null)
                    .count();

            if (assignedCount == 8) {
                // set season started
                season.setStarted(true);

                List<SeasonParticipant> filledParticipants = participants.stream()
                        .filter(p -> p.getUser() != null)
                        .collect(Collectors.toList()); // ✅ mutable list

                startRound(season, 1, filledParticipants);

                // set finish season
                season.setFinishedAt(LocalDateTime.now());
                log.info("finish season at " + season.getFinishedAt());
            }
        } catch (Exception e) {
            log.info("Tournament Service - tryStartTournament : " + e.getMessage());
        }
    }

    private void startRound(Season season, int round, List<SeasonParticipant> players) {
        Collections.shuffle(players);
        for (int i = 0; i < players.size(); i += 2) {
            Match match = new Match();
            match.setSeason(players.get(i).getSeason());
            match.setPlayer1(players.get(i).getUser());
            match.setPlayer2(players.get(i + 1).getUser());

            UserInfo winner = simulate(players.get(i).getUser(), players.get(i + 1).getUser());
            match.setWinner(winner);
            match.setRound(round);
            matchRepository.save(match);

            // 승자만 다음 라운드로
            SeasonParticipant next = new SeasonParticipant();
            next.setSeason(match.getSeason());
            next.setUser(winner);
            next.setRound(round + 1);
            next.setEliminated(false);
            participantRepository.save(next);
        }

        if (players.size() == 2) {
            System.out.println("🏆 리그 우승자: " + players.get(0).getUser().getUsername());
        } else {
            // 다음 라운드 시작
            List<SeasonParticipant> nextRound = participantRepository.findBySeasonAndRound(season, round + 1);
            startRound(season, round + 1, nextRound);
        }
    }

    private UserInfo simulate(UserInfo a, UserInfo b) {
        return new Random().nextBoolean() ? a : b;
    }
}
