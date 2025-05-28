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
import com.example.kfc.config.AiStartupRunner;
import com.example.kfc.service.MyClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
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

            long assignedCount = participants.stream()
                    .filter(p -> p.getUser() != null)
                    .count();

            if (assignedCount == 8) {
                season.setStarted(true);
                seasonRepository.save(season);

                List<SeasonParticipant> filledParticipants = participants.stream()
                        .filter(p -> p.getUser() != null)
                        .collect(Collectors.toList());

                startTournament(season, filledParticipants);

                season.setFinishedAt(LocalDateTime.now());
                seasonRepository.save(season);

                log.info("✅ 시즌 종료: " + season.getFinishedAt());
            }
        } catch (Exception e) {
            log.error("❌ TournamentService - tryStartTournament 예외 발생: " + e.getMessage(), e);
        }
    }

    private void startTournament(Season season, List<SeasonParticipant> players) {
        Collections.shuffle(players);
        int round = 1;

        while (players.size() > 1) {
            List<SeasonParticipant> nextRound = new ArrayList<>();

            for (int i = 0; i < players.size(); i += 2) {
                SeasonParticipant a = players.get(i);
                SeasonParticipant b = players.get(i + 1);

                System.out.println("\n🌀 라운드 " + round + " - 경기 #" + (i / 2 + 1));

                Match match = new Match();
                match.setSeason(season);
                match.setPlayer1(a.getUser());
                match.setPlayer2(b.getUser());

                SeasonParticipant winnerParticipant, loserParticipant;
                boolean aIsAi = a.getUser().isAi();
                boolean bIsAi = b.getUser().isAi();

                if (!aIsAi && !bIsAi) {
                    UserInfo winnerUser = simulateByClub(a, b);

                    MyClub clubA = myClubService.getClubByUserIdAndClubId(a.getUser().getId(), a.getClubId());
                    MyClub clubB = myClubService.getClubByUserIdAndClubId(b.getUser().getId(), b.getClubId());

                    System.out.println("🧍 유저 vs 유저");
                    System.out.println("A: " + a.getUser()
                            .getUsername() + " | Club ID: " + clubA.getClubId() + " | OVR: " + clubA.getOvr());
                    System.out.println("B: " + b.getUser()
                            .getUsername() + " | Club ID: " + clubB.getClubId() + " | OVR: " + clubB.getOvr());

                    winnerParticipant = (winnerUser == null || winnerUser.equals(a.getUser())) ? a : b;
                    loserParticipant = (winnerUser == null || winnerUser.equals(a.getUser())) ? b : a;
                } else if (aIsAi && bIsAi) {
                    AiClub clubA = getAiClubById(a.getClubId());
                    AiClub clubB = getAiClubById(b.getClubId());

                    System.out.println("🤖 AI vs AI");
                    System.out.println("A (AI): " + a.getUser()
                            .getUsername() + " | Club ID: " + clubA.getClubId() + " | OVR: " + clubA.getOvr());
                    System.out.println("B (AI): " + b.getUser()
                            .getUsername() + " | Club ID: " + clubB.getClubId() + " | OVR: " + clubB.getOvr());

                    winnerParticipant = (clubA.getOvr() >= clubB.getOvr()) ? a : b;
                    loserParticipant =  (clubA.getOvr() >= clubB.getOvr()) ? b : a;
                } else {
                    SeasonParticipant human = aIsAi ? b : a;
                    SeasonParticipant ai = aIsAi ? a : b;

                    MyClub humanClub = myClubService.getClubByUserIdAndClubId(human.getUser().getId(),
                                                                              human.getClubId());
                    AiClub aiClub = getAiClubById(ai.getClubId());

                    System.out.println("🧍 vs 🤖 유저 vs AI");
                    System.out.println("Human: " + human.getUser()
                            .getUsername() + " | Club ID: " + humanClub.getClubId() + " | OVR: " + humanClub.getOvr());
                    System.out.println("AI: " + ai.getUser()
                            .getUsername() + " | Club ID: " + aiClub.getClubId() + " | OVR: " + aiClub.getOvr());

                    boolean humanWins = humanClub.getOvr() >= aiClub.getOvr();
                    winnerParticipant = humanWins ? human : ai;
                    loserParticipant =
                            humanWins ? ai :
                                    human;
                }

                Long loserUserId = loserParticipant.getUser().getId();
                participantRepository.eliminateParticipantByUserIdAndRound(loserUserId, round);
                System.out.println("❌ 패배자 정보 - User ID: " + loserUserId);

                match.setWinner(winnerParticipant.getUser());
                match.setRound(round);
                matchRepository.save(match);

                SeasonParticipant next = new SeasonParticipant();
                next.setSeason(season);
                next.setUser(winnerParticipant.getUser());
                next.setClubId(winnerParticipant.getClubId());
                next.setRound(round + 1);
                next.setEliminated(false);
                participantRepository.save(next);
                nextRound.add(next);
            }

            round++;
            players = nextRound;
        }


        if (!players.isEmpty()) {
            log.info("🏆 최종 우승자: " + players.get(0).getUser().getUsername());
        }
    }

    private AiClub getAiClubById(Long clubId) {
        return AiStartupRunner.aiClubList.stream()
                .filter(c -> c.getClubId().equals(clubId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("AI 클럽 ID 없음: " + clubId));
    }
//    private AiClub getRandomAiClub() {
//        List<AiClub> list = AiStartupRunner.aiClubList;
//        return list.get(new Random().nextInt(list.size()));
//    }

    private UserInfo simulateByClub(SeasonParticipant a, SeasonParticipant b) {
        Long aUserId = a.getUser().getId();
        Long bUserId = b.getUser().getId();

        Long aClubId = a.getClubId();
        Long bClubId = b.getClubId();

        if (aClubId == null || bClubId == null) {
            log.warn("❌ simulateByClub: clubId is null (aClubId={}, bClubId={})", aClubId, bClubId);
            return null;
        }

        MyClub clubA = myClubService.getClubByUserIdAndClubId(aUserId, aClubId);
        MyClub clubB = myClubService.getClubByUserIdAndClubId(bUserId, bClubId);

        Long ovrA = clubA.getOvr();
        Long ovrB = clubB.getOvr();

        log.info("👤 A: {} (OVR: {})", a.getUser().getUsername(), ovrA);
        log.info("👤 B: {} (OVR: {})", b.getUser().getUsername(), ovrB);

        if (Objects.equals(ovrA, ovrB)) {
            log.info("⚖️ 무승부 처리됨.");
            return null;
        }

        return ovrA > ovrB ? a.getUser() : b.getUser();
    }
}
