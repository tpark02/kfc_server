package com.example.kfc.repository.Season;

import com.example.kfc.entity.Season.Match;
import com.example.kfc.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findBySeasonId(Long seasonId);

    @Query(value = """
    SELECT DISTINCT u.*\s
    FROM season_match m\s
    JOIN user_info u ON m.player1_id = u.id\s
    WHERE m.season_id = :seasonId
    UNION
    SELECT DISTINCT u.*\s
    FROM season_match m\s
    JOIN user_info u ON m.player2_id = u.id\s
    WHERE m.season_id = :seasonId
   \s""", nativeQuery = true)
    List<UserInfo> findParticipantsBySeasonId(@Param("seasonId") Long seasonId);
}

