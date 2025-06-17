package com.example.kfc.repository;

import com.example.kfc.entity.MyPlayer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MyPlayerRepository extends JpaRepository<MyPlayer, Long> {
    @Query("SELECT m FROM MyPlayer m WHERE m.userId = :userId AND m.playerId = :playerId")
    List<MyPlayer> findAllMatchingPlayerId(@Param("userId") Long userId,
                                           @Param("playerId") Long playerId);
    List<MyPlayer> findByUserIdAndClubId(Long userId, Long clubId);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.yellowCard = :yellowCard " +
            "WHERE p.userId = :userId AND p.clubId = :clubId AND p.playerId = :playerId")
    int updateYellowCard(@Param("userId") Long userId,
                         @Param("playerId") Long playerId,
                         @Param("yellowCard") Long yellowCard);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.redCard = :redCard, p.seq_cnt = :seq_cnt  " +
            "WHERE p.userId = :userId AND p.clubId = :clubId AND p.playerId = :playerId")
    int updateRedCard(@Param("userId") Long userId,
                      @Param("playerId") Long playerId,
                      @Param("redCard") Long redCard,
                      @Param("seq_cnt") Long seq_cnt);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.yellowCard = 0 WHERE p.userId = :userId")
    int resetYellowCard(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.redCard = 0 WHERE p.userId = :userId")
    int resetRedCard(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.seq_cnt = 0 WHERE p.userId = :userId")
    int resetSeqCnt(@Param("userId") Long userId);

    @Query("SELECT SUM(p.yellowCard) FROM MyPlayer p WHERE p.userId = :userId")
    Long countYellowCards(@Param("userId") Long userId);

    @Query("SELECT SUM(p.redCard) FROM MyPlayer p WHERE p.userId = :userId")
    Long countRedCards(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE MyPlayer p SET p.idx = :idx WHERE p.userId = :userId AND p.playerId = :playerId")
    int updateIdxByUserIdAndClubIdAndPlayerId(Long idx, Long userId, Long playerId);
}
