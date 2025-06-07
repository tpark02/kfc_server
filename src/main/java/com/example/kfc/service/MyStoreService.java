package com.example.kfc.service;

import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.MyStore;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.MyStoreRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyStoreService {
    private final MyStoreRepository myStoreRepository;

    public MyStore findByUserIdAndPlayerId(Long userId, Long playerId) {
        return myStoreRepository.findByUserIdAndPlayerId(userId, playerId).orElseThrow(
                () -> new IllegalArgumentException(
                        "MyStore not found for userId=" + userId + ", playerId=" + playerId));
    }

    @Transactional
    public boolean updateNewPlayer(Long id, Long userId, Player player) {
        int result = myStoreRepository.updateMyStoreByIdAndUserId(
                id,
                userId,
                player.getId(),
                -1L, // clubId
                0L,  // yellowCard
                0L,  // redCard
                0L,  // seq_cnt
                -1L, // idx
                player.getRank(),
                player.getName(),
                player.getOvr(),
                player.getPac(),
                player.getSho(),
                player.getPas(),
                player.getDri(),
                player.getDef(),
                player.getPhy(),
                player.getAcceleration(),
                player.getSprintSpeed(),
                player.getPositioning(),
                player.getFinishing(),
                player.getShotPower(),
                player.getLongShots(),
                player.getVolleys(),
                player.getPenalties(),
                player.getVision(),
                player.getCrossing(),
                player.getFreeKickAccuracy(),
                player.getShortPassing(),
                player.getLongPassing(),
                player.getCurve(),
                player.getDribbling(),
                player.getAgility(),
                player.getBalance(),
                player.getReactions(),
                player.getBallControl(),
                player.getComposure(),
                player.getInterceptions(),
                player.getHeadingAccuracy(),
                player.getDefAwareness(),
                player.getStandingTackle(),
                player.getSlidingTackle(),
                player.getJumping(),
                player.getStamina(),
                player.getStrength(),
                player.getAggression(),
                player.getPos(),
                player.getWeakFoot(),
                player.getSkillMoves(),
                player.getPreferredFoot(),
                player.getHeight(),
                player.getWeight(),
                player.getAlternativePositions(),
                player.getAge(),
                player.getNation(),
                player.getLeague(),
                player.getTeam(),
                player.getPlayStyle(),
                player.getUrl(),
                player.getImg(),
                player.getGkDiving(),
                player.getGkHandling(),
                player.getGkKicking(),
                player.getGkPositioning(),
                player.getGkReflexes()
                                                                 );

        return result > 0;
    }

//    public Pair<Long, Long> findIdRangeByUserId(Long userId) {
//        Object[] result = myStoreRepository.findIdRangeByUserId(userId).orElseThrow(() -> new IllegalArgumentException("No range found for userId=" + userId));
//
//        Long minId = result[0] != null ? (Long) result[0] : -1L;
//        Long maxId = result[1] != null ? (Long) result[1] : -1L;
//        return Pair.of(minId, maxId);
//    }

    public List<MyStore> getMyStore(Long userId) {
        List<MyStore> lst = myStoreRepository.getMyStoreData(userId);
        return lst;
    }
}
