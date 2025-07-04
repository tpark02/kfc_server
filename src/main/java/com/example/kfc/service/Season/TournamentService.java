package com.example.kfc.service.Season;

import com.example.kfc.config.StartupRunner;
import com.example.kfc.entity.*;
import com.example.kfc.entity.Season.Match;
import com.example.kfc.entity.Season.Season;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.manager.LockManager;
import com.example.kfc.repository.Season.MatchRepository;
import com.example.kfc.repository.Season.SeasonParticipantRepository;
import com.example.kfc.repository.Season.SeasonRepository;
import com.example.kfc.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TournamentService {
    private final LockManager<Long> seasonLockManager = new LockManager<>();

    private final SeasonRepository seasonRepository;
    private final SeasonParticipantRepository participantRepository;
    private final MatchRepository matchRepository;
    private final MyClubService myClubService;
    private final MyPlayerService myPlayerService;
    private final MyFormationService myFormationService;
    private final UserInfoService userInfoService;

    public void tryStartTournament(Season season) {
        seasonLockManager.lock(season.getId());
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

                calcTournament(season, filledParticipants);

                season.setFinishedAt(LocalDateTime.now());
                seasonRepository.save(season);

                log.info("✅ Season finished: " + season.getFinishedAt());
            }
        } catch (Exception e) {
            log.error("❌ TournamentService - tryStartTournament exception occurred: " + e.getMessage(), e);
        } finally {
            seasonLockManager.unlock(season.getId());
        }
}

private void calcTournament(Season season, List<SeasonParticipant> players) {
    Collections.shuffle(players);
    List<SeasonParticipant> playerList = players.stream()
            .filter(p -> !p.getUser().isAi())
            .toList();

    Map<Long, Long> playerOvrMap = new HashMap<>();

    for (SeasonParticipant p : playerList) {
        Long userId = p.getUser().getId();
        Long clubId = p.getClubId();

        MyClub club = myClubService.getClubByUserId(userId);

        MyFormation myFormation = myFormationService.getFormationsByClub(club)
                .orElseThrow(() -> new IllegalArgumentException("Club not found for clubId: " + clubId));

        long totalOvr = 0L;

        List<MyPlayer> allMyPlayers = myPlayerService.getMyPlayers(userId);

        for (int j = 1; j <= RandomTeamService.totalPlayersCount; j++) {
            try {
                Method getter = MyFormation.class.getMethod("getP" + j); // P1 ~ P17
                Long playerId = (Long) getter.invoke(myFormation);

                if (playerId != null) {
                    int targetIdx = j - 1;

                    Optional<MyPlayer> matched = allMyPlayers.stream()
                            .filter(my -> my.getPlayerId().equals(playerId) && my.getIdx().equals((long) targetIdx))
                            .findFirst();

                    if (matched.isPresent()) {
                        MyPlayer myPlayer = matched.get();

                        long adjustedOvr = myPlayer.getOvr()
                                - myPlayer.getYellowCard() * 5L
                                - myPlayer.getRedCard() * 10L;

                        totalOvr += adjustedOvr;
                    } else {
                        System.err.println("❌ No matching player for idx=" + targetIdx + ", playerId=" + playerId);
                    }
                }
            } catch (Exception e) {
                System.err.println("⚠️ Failed to process player at P" + j + " for userId: " + userId);
                e.printStackTrace();
            }
        }

        long avgOvr = totalOvr / RandomTeamService.startingPlayerCount;
        playerOvrMap.put(userId, avgOvr);
    }

    playerOvrMap.forEach((userId, ovr) -> System.out.println("User ID: " + userId + ", Adjusted OVR: " + ovr));

    // reset all players' yellow, red cards
    players.forEach(p -> {
        if (p.getUser().isAi()) return;
        myPlayerService.resetYellowCards(p.getUser().getId());
        myPlayerService.resetRedCards(p.getUser().getId());
    });

    int round = 1;
    while (players.size() > 1) {
        List<SeasonParticipant> nextRound = new ArrayList<>();

        for (int i = 0; i < players.size(); i += 2) {
            SeasonParticipant a = players.get(i);
            SeasonParticipant b = players.get(i + 1);

            boolean aIsAi = a.getUser().isAi();
            boolean bIsAi = b.getUser().isAi();

            SeasonParticipant winnerParticipant = null, loserParticipant = null;

            System.out.println("\n🌀 Round " + round + " - Match #" + (i / 2 + 1));

            Match match = new Match();
            match.setSeason(season);
            match.setPlayer1(a.getUser());
            match.setPlayer2(b.getUser());
            match.setClubId1(a.getClubId());
            match.setClubId2(b.getClubId());
            match.setIsAi1(aIsAi);
            match.setIsAi2(bIsAi);

            Random random = SeasonService.random;

            if (!aIsAi && !bIsAi) {
                MyClub clubA = myClubService.getClubByUserId(a.getUser().getId());
                MyClub clubB = myClubService.getClubByUserId(b.getUser().getId());


                Long adjustedOvrA = playerOvrMap.get(a.getUser().getId());
                Long adjustedOvrB = playerOvrMap.get(b.getUser().getId());

                UserInfo winnerUser = a.getUser();

                if (!Objects.equals(adjustedOvrA, adjustedOvrB)) {
                    winnerUser = (adjustedOvrA > adjustedOvrB) ? a.getUser() : b.getUser();
                }

                System.out.println("🧍 User vs 🧍 User");
                System.out.println("A: " + a.getUser()
                        .getUsername() + " | Club ID: " + clubA.getClubId() + " | adjusted OVR: " + adjustedOvrA);
                System.out.println("B: " + b.getUser()
                        .getUsername() + " | Club ID: " + clubB.getClubId() + " | adjusted  OVR: " + adjustedOvrB);

                winnerParticipant = (winnerUser == null || winnerUser.equals(a.getUser())) ? a : b;
                loserParticipant = (winnerUser == null || winnerUser.equals(a.getUser())) ? b : a;

                if (random.nextBoolean()) {
                    int cntA = generateYellowCardCount(random);
                    int cntB = generateYellowCardCount(random);

                    setYellowCard(b.getUser().getId(), b.getClubId(), cntA);
                    setYellowCard(a.getUser().getId(), a.getClubId(), cntB);
                }

                if (random.nextBoolean()) {
                    int cntA = generateRedCardsCount(random);
                    int cntB = generateRedCardsCount(random);

                    setRedCard(b.getUser().getId(), b.getClubId(), cntA, 0L);
                    setRedCard(a.getUser().getId(), a.getClubId(), cntB, 0L);
                }
            } else if (aIsAi && bIsAi) {
                Long ovra = getAiClubById(a.getClubId()).getOvr();
                Long ovrb = getAiClubById(b.getClubId()).getOvr();

                System.out.println("🤖 AI vs 🤖 AI");
                System.out.println("A (AI): " + a.getUser()
                        .getUsername() + " | Club ID: " + a.getClubId() + " | OVR: " + ovra);
                System.out.println("B (AI): " + b.getUser()
                        .getUsername() + " | Club ID: " + b.getClubId() + " | OVR: " + ovrb);

                winnerParticipant = (ovra >= ovrb) ? a : b;
                loserParticipant = (ovra >= ovrb) ? b : a;
            } else {
                SeasonParticipant human = aIsAi ? b : a;
                SeasonParticipant ai = aIsAi ? a : b;

                System.out.println("human - " + a.getUser().isAi() + " : " + human.getUser().getId());
                System.out.println("ai - " + b.getUser().isAi() + " : " + ai.getUser().getId());

                Long humanOvr = playerOvrMap.get(human.getUser().getId());
                Long aiOvr = getAiClubById(ai.getClubId()).getOvr();

                boolean humanWins = humanOvr >= aiOvr;
                winnerParticipant = humanWins ? human : ai;
                loserParticipant = humanWins ? ai : human;

                // set yellow
                if (random.nextBoolean()) {
                    int c = generateYellowCardCount(random);
                    setYellowCard(human.getUser().getId(), human.getClubId(), c);
                }

                // set red
                if (random.nextBoolean()) {
                    int c = generateRedCardsCount(random);
                    setRedCard(human.getUser().getId(), human.getClubId(), c, 0L);
                }

                System.out.println("🧍 vs 🤖 User vs AI");
                System.out.println("Human: " + human.getUser()
                        .getUsername() + " | Club ID: " + human.getClubId() + " | adjusted OVR: " + humanOvr);
                System.out.println("AI: " + ai.getUser()
                        .getUsername() + " | Club ID: " + ai.getClubId() + " | OVR: " + aiOvr);
            }

            Long loserUserId = loserParticipant.getUser().getId();
            participantRepository.eliminateParticipantByUserIdAndRound(loserUserId, round);
            System.out.println("❌ Eliminated participant - User ID: " + loserUserId);

            // add user coins
            if (!winnerParticipant.getUser().isAi()) {
                UserInfo winner = winnerParticipant.getUser();
                winner.setCoin(2L * round);
                userInfoService.save(winner);
            }

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
        log.info("🏆 Final Winner: " + players.get(0).getUser().getUsername());
        UserInfo winner = players.get(0).getUser();
        if (!winner.isAi()) {
            Long coin = winner.getCoin();
            winner.setCoin(coin + 2L);
            userInfoService.save(winner);
        }
    }
}

private int generateRedCardsCount(Random random) {
    int chance = random.nextInt(100);
    if (chance < 80) return 0;
    else if (chance < 95) return 1;
    else return 2;
}

private int generateYellowCardCount(Random random) {
    int chance = random.nextInt(100) + 1;
    if (chance <= 50) return 2;
    else if (chance <= 90) return 3;
    else if (chance <= 97) return 4;
    else if (chance <= 99) return 5;
    else return 6;
}

private AiClub getAiClubById(Long clubId) {
    return StartupRunner.aiClubList.stream()
            .filter(c -> c.getClubId().equals(clubId))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("AI club ID not found: " + clubId));
}

private void setYellowCard(Long userId, Long clubId, int cnt) {
    try {
        List<MyPlayer> myPlayers = myPlayerService.getMyPlayers(userId);
        int size = 11;

        if (cnt > size) {
            throw new IllegalArgumentException("💥 Not enough players to give yellow cards. Total: " + size);
        }

        Set<Integer> usedIndices = new HashSet<>();
        Random random = SeasonService.random;

        for (int i = 0; i < cnt; i++) {
            int playerIdx;
            do {
                playerIdx = random.nextInt(size);
            } while (usedIndices.contains(playerIdx));

            usedIndices.add(playerIdx);
            MyPlayer selectedPlayer = myPlayers.get(playerIdx);
            Long playerId = selectedPlayer.getPlayerId();

            Long yellowCardCount = (random.nextBoolean()) ? 1L : 2L;

            myPlayerService.setYellowCard(userId, playerId, yellowCardCount);

            System.out.println("\n🟨 Yellow card given:");
            System.out.println("User ID: " + userId);
            System.out.println("Club ID: " + clubId);
            System.out.println("Player ID: " + playerId);
            System.out.println("Player Name: " + selectedPlayer.getName());
            System.out.println("Position: " + selectedPlayer.getPos());
            System.out.println("OVR: " + selectedPlayer.getOvr());
            System.out.println("Yellow Card Count: " + yellowCardCount);
        }
    } catch (Exception e) {
        throw new RuntimeException("❗ setYellowCard error: " + e.getMessage(), e);
    }
}

private void setRedCard(Long userId, Long clubId, int cnt, Long seq_cnt) {
    try {
        List<MyPlayer> myPlayers = myPlayerService.getMyPlayers(userId);
        int size = 11;

        if (cnt > size) {
            throw new IllegalArgumentException("💥 Not enough players to give red cards. Total: " + size);
        }

        Set<Integer> usedIndices = new HashSet<>();
        Random random = SeasonService.random;

        for (int i = 0; i < cnt; i++) {
            int playerIdx;
            do {
                playerIdx = random.nextInt(size);
            } while (usedIndices.contains(playerIdx));

            usedIndices.add(playerIdx);
            MyPlayer selectedPlayer = myPlayers.get(playerIdx);
            Long playerId = selectedPlayer.getPlayerId();

            System.out.println("\n🟥 Red card given:");
            System.out.println("User ID: " + userId);
            System.out.println("Club ID: " + clubId);
            System.out.println("Player ID: " + playerId);
            System.out.println("Player Name: " + selectedPlayer.getName());
            System.out.println("Position: " + selectedPlayer.getPos());
            System.out.println("OVR: " + selectedPlayer.getOvr());
            System.out.println("Red Card Count: " + seq_cnt);

            myPlayerService.setRedCard(userId, playerId, 1L, seq_cnt);
        }
    } catch (Exception e) {
        throw new RuntimeException("❗ setRedCard error: " + e.getMessage(), e);
    }
}

private UserInfo simulateByClub(SeasonParticipant a, SeasonParticipant b, Long yellowCntA, Long yellowCntB) {
    Long aUserId = a.getUser().getId();
    Long bUserId = b.getUser().getId();

    Long aClubId = a.getClubId();
    Long bClubId = b.getClubId();

    if (aClubId == null || bClubId == null) {
        log.warn("❌ simulateByClub: clubId is null (aClubId={}, bClubId={})", aClubId, bClubId);
        return null;
    }

    MyClub clubA = myClubService.getClubByUserId(aUserId);
    MyClub clubB = myClubService.getClubByUserId(bUserId);

    Long ovrA = clubA.getOvr() - (yellowCntA * 5L);
    Long ovrB = clubB.getOvr() - (yellowCntB * 5L);

    log.info("👤 A: {} (OVR: {})", a.getUser().getUsername(), ovrA);
    log.info("👤 B: {} (OVR: {})", b.getUser().getUsername(), ovrB);

    if (Objects.equals(ovrA, ovrB)) {
        log.info("⚖️ Match ended in a draw.");
        return null;
    }

    return ovrA > ovrB ? a.getUser() : b.getUser();
}
}
