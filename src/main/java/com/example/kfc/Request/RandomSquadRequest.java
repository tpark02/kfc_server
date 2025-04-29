package com.example.kfc.Request;

import com.example.kfc.dto.CountryDto;
import com.example.kfc.dto.LeagueDto;
import com.example.kfc.dto.TeamDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RandomSquadRequest {
    private String name;
    private List<CountryDto> countries;
    private List<LeagueDto> leagues;
    private List<TeamDto> clubs;
}
