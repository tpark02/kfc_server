package com.example.kfc.api;

import com.example.kfc.Request.RandomSquadRequest;
import com.example.kfc.Response.RandomSquadResponse;
import com.example.kfc.dto.CountryDto;
import com.example.kfc.dto.LeagueDto;
import com.example.kfc.dto.TeamDto;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.service.RandomTeamService;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
@RequiredArgsConstructor
public class RandomTeamController {

    private final RandomTeamService randomTeamService;
    private final UserInfoService userInfoService;

    @PostMapping("/api/randomteam")
    public RandomSquadResponse getRandomTeam(@RequestBody RandomSquadRequest request) {
        String formation  = request.getName();
        List<CountryDto> countries = request.getCountries();
        List<LeagueDto> leagues = request.getLeagues();
        List<TeamDto> clubs = request.getClubs();

        for (var c : countries) System.out.println(c.getName());
        for (var c : leagues) System.out.println(c.getName());
        for (var c : clubs) System.out.println(c.getName());

        System.out.println(formation);

        var res = randomTeamService.generateRandomTeamByPosition(formation, countries, leagues, clubs);

        UserInfo user = userInfoService.findUserInfoById(1L)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 없음"));

        return new RandomSquadResponse(res.getContent(), res.getMyTeamOvr(), res.getChemistry(), user.getTeamName());
    }
}
