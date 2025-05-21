package com.example.kfc.repository.Season;

import com.example.kfc.entity.Season.Season;
import com.example.kfc.entity.Season.SeasonParticipant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeasonParticipantRepository extends JpaRepository<SeasonParticipant, Long>{
    List<SeasonParticipant> findBySeason(Season season);

    @Query("SELECT p FROM SeasonParticipant p WHERE p.season.id = :seasonId")
    List<SeasonParticipant> findBySeasonId(@Param("seasonId") Long seasonId);

    List<SeasonParticipant> findBySeasonAndRound(Season season, int round);

    @Transactional
    @Modifying
    @Query("DELETE FROM SeasonParticipant sp WHERE sp.season.id = :seasonId AND sp.user.id = :userId")
    void deleteBySeasonIdAndUserId(@Param("seasonId") Long seasonId, @Param("userId") Long userId);
}
