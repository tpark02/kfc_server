package com.example.kfc.controller;

import com.example.kfc.dto.TeamDto;
import com.example.kfc.Response.TeamPageResponse;
import com.example.kfc.entity.Team;
import com.example.kfc.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
@RequestMapping("/api")
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    public TeamPageResponse getAllTeams() {
        List<Team> list = (List<Team>) teamRepository.findAll();
        List<TeamDto> forms = list.stream().map(TeamDto::from).collect(Collectors.toList());
        return new TeamPageResponse(forms);
    }
}