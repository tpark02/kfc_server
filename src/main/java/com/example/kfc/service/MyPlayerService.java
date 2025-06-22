package com.example.kfc.service;

import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.MyPlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyPlayerService {

    private final MyPlayerRepository myPlayerRepository;

    public List<MyPlayer> getMyPlayersByPlayerId(Long userId, Long clubId, Long playerId) {
        return myPlayerRepository.findAllMatchingPlayerId(userId, playerId);
    }

    public List<MyPlayer> getMyPlayers(Long userId) {
        return myPlayerRepository.findByUserId(userId);
    }

    public void createEmptyPlayers(Long userId, Long clubId) {
        List<MyPlayer> players = new ArrayList<>();

        for (long i = 1; i <= 27; i++) {
            MyPlayer player = new MyPlayer();
            player.setUserId(userId);
            player.setClubId(clubId);
            player.setIdx(i);
            player.resetStats();
            players.add(player);
        }

        myPlayerRepository.saveAll(players);
    }

    @Transactional
    public int deletePlayer(Long userId, Long idx) {
        return myPlayerRepository.updatePlayer(
                userId,
                idx,
                17738L,
                1L,
                0L, 0L, 0L,
                0L,
                "dummy",
                0L, 0L, 0L, 0L, 0L, 0L, 0L,
                0L, 0L, 0L, 0L, 0L, 0L, 0L,
                0L, 0L, 0L, 0L, 0L, 0L, 0L,
                0L, 0L, 0L, 0L, 0L, 0L, 0L,
                0L, 0L, 0L, 0L, 0L, 0L, 0L,
                0L,
                "LM",
                0L, 0L,
                "Left",
                "0", "0",
                "LW",
                18L,
                "", "", "", "",
                "", "",
                0L, 0L, 0L, 0L, 0L,
                0L, 0L,
                "", ""
                                              );
    }

    @Transactional
    public void setYellowCard(Long userId, Long playerId, Long cnt) {
        int updated = myPlayerRepository.updateYellowCard(userId, playerId, cnt);
        if (updated == 0) {
            throw new IllegalStateException("Failed to update yellow card: no matching player found.");
        }
    }

    @Transactional
    public void setRedCard(Long userId, Long playerId, Long cnt, Long seq_cnt) {
        int updated = myPlayerRepository.updateRedCard(userId, playerId, cnt, seq_cnt);
        if (updated == 0) {
            throw new IllegalStateException("Failed to update red card: no matching player found. - playerId : " + playerId);
        }
    }

    @Transactional
    public void resetYellowCards(Long userId) {
        int updated = myPlayerRepository.resetYellowCard(userId);
        if (updated == 0) {
            throw new IllegalStateException("Failed to reset yellow cards: No matching players found for the given user and club.");
        }
    }

    @Transactional
    public void resetRedCards(Long userId) {
        int updated = myPlayerRepository.resetRedCard(userId);
        if (updated == 0) {
            throw new IllegalStateException("Failed to reset red cards: No matching players found for the given user and club.");
        }
    }

    @Transactional
    public void resetSeqCnt(Long userId) {
        int updated = myPlayerRepository.resetSeqCnt(userId);
        if (updated == 0) {
            throw new IllegalStateException("Failed to reset seq_cnt: No matching players found for the given user and club.");
        }
    }

    @Transactional
    void updateExistingPlayer(MyPlayer myPlayer) {
        myPlayerRepository.save(myPlayer);
    }

    @Transactional
    public boolean updateNewPlayer(Player source, MyPlayer myPlayer) {
        try {
            MyPlayer.PlayerToMyPlayer(source, myPlayer);
            myPlayerRepository.save(myPlayer);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Long getYellowCardCount(Long userId) {
        Long count = myPlayerRepository.countYellowCards(userId);
        return count != null ? count : 0L;
    }

    public Long getRedCardCount(Long userId) {
        Long count = myPlayerRepository.countRedCards(userId);
        return count != null ? count : 0L;
    }

    public void updateIdxForClub(Long userId, Map<Long, Long> rosterMap) {
        try {
            rosterMap.forEach((playerId, idx) -> {
                System.out.println(String.format("Updating idx for userId=%d, clubId=%d, playerId=%d, idx=%d",
                                                 userId, playerId, idx));
                myPlayerRepository.updateIdxByUserIdAndClubIdAndPlayerId(idx, userId, playerId);
            });
        } catch (Exception e) {
            log.error("Failed to update idx for userId={}, clubId={}, error={}", userId, e.getMessage(), e);
            throw new RuntimeException("Failed to update player idx", e);
        }
    }
}
