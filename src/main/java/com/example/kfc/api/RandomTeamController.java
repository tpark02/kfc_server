package com.example.kfc.api;

import com.example.kfc.Response.RandomSquadResponse;
import com.example.kfc.service.RandomTeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
@RequiredArgsConstructor
public class RandomTeamController {

    private final RandomTeamService randomTeamService;

    @RequestMapping("/api/randomteam")
    public RandomSquadResponse getRandomTeam() {
        var res = randomTeamService.generateRandomTeam();
        return new RandomSquadResponse(res.getContent(), res.getTotalOvr(), res.getAverageOvr(), res.getChemistry());
    }
}
