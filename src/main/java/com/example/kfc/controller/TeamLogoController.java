package com.example.kfc.controller;

import com.example.kfc.entity.TeamLogo;
import com.example.kfc.service.TeamLogoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamLogoController {

    private final TeamLogoService teamLogoService;

    public TeamLogoController(TeamLogoService teamLogoService) {
        this.teamLogoService = teamLogoService;
    }

    @GetMapping("/logos")
    public List<TeamLogo> getAllLogos() {
        return teamLogoService.getAllTeamLogos();
    }

    @GetMapping("/logos/{id}")
    public ResponseEntity<TeamLogo> getLogoById(@PathVariable Long id) {
        return teamLogoService.getTeamLogoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
