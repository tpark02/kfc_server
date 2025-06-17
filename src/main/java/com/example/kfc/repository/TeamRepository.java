package com.example.kfc.repository;

import com.example.kfc.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query(value = """
    SELECT * FROM team
    WHERE id NOT IN (:excludedIds)
    ORDER BY RAND()
    LIMIT 20
    """, nativeQuery = true)
    List<Team> findRandom20TeamsExcluding(@Param("excludedIds") List<Long> excludedIds);

}
