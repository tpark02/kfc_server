package com.example.kfc.api;

import com.example.kfc.Request.SimGenerateRequest;
import com.example.kfc.Request.SimRequest;
import com.example.kfc.Response.SimResultResponse;
import com.example.kfc.dto.MatchDto;
import com.example.kfc.service.SimService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class SimController {
    @Autowired
    private final SimService simService;

    @PostMapping("/api/simulate-league")
    public SimResultResponse simulateLeague(@RequestBody SimRequest request) {
        return simService.simulateLeague(request.getTeams());
    }

    @PostMapping("/api/simulate/generate-schedule")
    public List<MatchDto> generateRandomSchedule(@RequestBody SimGenerateRequest request) {
        return simService.generateRandomSchedule(request.getMyTeamName(), request.getMyTeamMembers());
    }
}
