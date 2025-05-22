package com.example.kfc.repository.Season;

import com.example.kfc.entity.Season.Season;
import com.example.kfc.entity.Season.SeasonParticipant;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SeasonParticipantRepository extends JpaRepository<SeasonParticipant, Long>{
    List<SeasonParticipant> findBySeason(Season season);

    @Query("SELECT p FROM SeasonParticipant p WHERE p.season.id = :seasonId")
    List<SeasonParticipant> findBySeasonId(@Param("seasonId") Long seasonId);

    List<SeasonParticipant> findBySeasonAndRound(Season season, int round);

    @Transactional
    @Modifying
    @Query("DELETE FROM SeasonParticipant sp WHERE sp.season.id = :seasonId AND sp.user.id = :userId")
    void deleteBySeasonIdAndUserId(@Param("seasonId") Long seasonId, @Param("userId") Long userId);

    Optional<SeasonParticipant> findFirstBySeasonIdAndUserIsNullAndActiveTrue(Long seasonId);

    boolean existsBySeasonIdAndUserId(Long seasonId, Long userId);

    @Query("SELECT p FROM SeasonParticipant p WHERE p.season.id = :seasonId AND p.active = true")
    List<SeasonParticipant> findActiveBySeasonId(@Param("seasonId") Long seasonId);

    // 탈퇴 처리 대상 조회
    Optional<SeasonParticipant> findBySeasonIdAndUserIdAndActiveTrue(Long seasonId, Long userId);

    // 참가 여부 확인 (중복 참가 방지용)
    boolean existsBySeasonIdAndUserIdAndActiveTrue(Long seasonId, Long userId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<SeasonParticipant> findFirstBySeasonIdAndUserIsNullAndActiveTrueOrderByIdAsc(Long seasonId);
}
