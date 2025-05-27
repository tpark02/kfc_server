package com.example.kfc.service.Season;

import com.example.kfc.entity.AiClub;
import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.Season.Match;
import com.example.kfc.entity.Season.Season;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.Season.MatchRepository;
import com.example.kfc.repository.Season.SeasonParticipantRepository;
import com.example.kfc.repository.Season.SeasonRepository;
import com.example.kfc.service.AiStartupRunner;
import com.example.kfc.service.MyClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TournamentService {
    private final SeasonRepository seasonRepository;
    private final SeasonParticipantRepository participantRepository;
    private final MatchRepository matchRepository;
    private final MyClubService myClubService;

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
            UserInfo winner = null;

            Long aId = players.get(i).getUser().getId();
            Long bId = players.get(i + 1).getUser().getId();
            SeasonParticipant a = players.get(i);
            SeasonParticipant b = players.get(i + 1);
            boolean aIsAi = players.get(i).getUser().isAi();
            boolean bIsAi = players.get(i+1).getUser().isAi();

            if (!aIsAi && !bIsAi) {
                // 유저 vs 유저
                winner = simulateByClub(a, b);
                if (winner == null) {
                    // TODO : kick off infomration
                    winner = a.getUser();
                }
            } else if (aIsAi && bIsAi) {
                AiClub randomAiClub = AiStartupRunner.aiClubList.get(
                        new Random().nextInt(AiStartupRunner.aiClubList.size()));
                Long aOvr = randomAiClub.getOvr();

                randomAiClub = AiStartupRunner.aiClubList.get(
                        new Random().nextInt(AiStartupRunner.aiClubList.size()));

                Long bOvr = randomAiClub.getOvr();

                winner = aOvr >= bOvr ? a.getUser() : b.getUser();
            }
            else {
                // 유저 vs AI 상황
                log.info("a id - " + aId);
                log.info("b id - " + bId);
                log.info("aIsAi - " + aIsAi);
                log.info("bIsAi - " + bIsAi);

                SeasonParticipant human = aIsAi ? b : a;
                Long humanId = human.getId();
                Long humanClubId = human.getClubId();

                log.info("human clubid : " + humanClubId);

                MyClub humanClub = myClubService.getClubByUserIdAndClubId(humanId, humanClubId);
                Long humanOvr = humanClub.getOvr();
                int aiClubId = new Random().nextInt(AiStartupRunner.aiClubList.size());
                AiClub randomAiClub = AiStartupRunner.aiClubList.get(aiClubId);

                log.info("ai clubid : " + aiClubId);


                Long aiOvr = randomAiClub.getOvr();

                // 승자 결정
                log.info("ai ovr : " + aiOvr);
                log.info("humanOvr : " + humanOvr);
                winner = (humanOvr >= aiOvr ? human : (aIsAi ? a : b)).getUser();
            }
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

    private UserInfo simulateByClub(SeasonParticipant a, SeasonParticipant b) {
        Long aUserId = a.getUser().getId();
        Long bUserId = b.getUser().getId();

        Long aClubId = a.getClubId();
        Long bClubId = b.getClubId();

        System.out.println("alubid - " + aClubId);
        System.out.println("blubid - " + bClubId);

        MyClub clubA = myClubService.getClubByUserIdAndClubId(aUserId, aClubId);
        MyClub clubB = myClubService.getClubByUserIdAndClubId(bUserId, bClubId);

        Long ovrA = clubA.getOvr();
        Long ovrB = clubB.getOvr();

        System.out.println("👤 A: " + a.getUser().getUsername() + " (OVR: " + ovrA + ")");
        System.out.println("👤 B: " + b.getUser().getUsername() + " (OVR: " + ovrB + ")");

        if (Objects.equals(ovrA, ovrB)) {
            System.out.println("⚖️ 무승부입니다.");
            return null; // 무승부일 경우 반환할 게 없으면 null
        }

        UserInfo winner = ovrA > ovrB ? a.getUser() : b.getUser();
        System.out.println("🏆 승자: " + winner.getUsername());
        return winner;
    }

    private UserInfo simulate(UserInfo a, UserInfo b) {
        // calculate ovr for a winner
        return new Random().nextBoolean() ? a : b;
    }
}
