package com.example.kfc.repository;

import com.example.kfc.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query(value = "SELECT * FROM team ORDER BY RAND() LIMIT 20", nativeQuery = true)
    List<Team> findRandom20Teams();
}
