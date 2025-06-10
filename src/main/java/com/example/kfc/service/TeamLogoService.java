package com.example.kfc.service;

import com.example.kfc.entity.TeamLogo;
import com.example.kfc.repository.TeamLogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamLogoService {

    private final TeamLogoRepository teamLogoRepository;

    public TeamLogoService(TeamLogoRepository teamLogoRepository) {
        this.teamLogoRepository = teamLogoRepository;
    }

    /**
     * Get all team logos.
     */
    public List<TeamLogo> getAllTeamLogos() {
        return teamLogoRepository.getAllTeamLogos(); // same as findAll()
    }

    /**
     * Get a single team logo by ID.
     */
    public Optional<TeamLogo> getTeamLogoById(Long id) {
        return teamLogoRepository.findById(id);
    }
}
