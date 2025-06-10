package com.example.kfc.repository;

import com.example.kfc.entity.TeamLogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeamLogoRepository extends JpaRepository<TeamLogo, Long> {
    Optional<TeamLogo> findById(Long id);
    @Query("SELECT t FROM TeamLogo t")
    List<TeamLogo> getAllTeamLogos();
}
