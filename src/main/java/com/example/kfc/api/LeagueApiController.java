package com.example.kfc.api;

import com.example.kfc.dto.LeagueDto;
import com.example.kfc.dto.LeaguePageResponse;
import com.example.kfc.entity.League;
import com.example.kfc.repository.LeagueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
public class LeagueApiController {

    private final LeagueRepository leagueRepository;

    public LeagueApiController(LeagueRepository repository) {
        this.leagueRepository = repository;
    }

    @GetMapping("/api/leagues")
    public LeaguePageResponse getAllLeagues() {
        List<League> list = (List<League>) leagueRepository.findAll();
        List<LeagueDto> forms = list.stream().map(LeagueDto::from).collect(Collectors.toList());
        return new LeaguePageResponse(forms);
    }
}