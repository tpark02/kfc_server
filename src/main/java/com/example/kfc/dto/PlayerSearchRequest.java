package com.example.kfc.dto;

import com.example.kfc.filter.CountryFilter;
import com.example.kfc.filter.LeagueFilter;
import com.example.kfc.filter.PlayerPositionFilter;
import com.example.kfc.filter.TeamFilter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerSearchRequest {
    private int page;
    private int size;
    private String search;
    private String sortType;
    private List<CountryFilter> countryFilter;
    private List<TeamFilter> teamFilter;
    private List<LeagueFilter> leagueFilter;
    private List<PlayerPositionFilter> playerPositionFilter;
    // getter & setter 필수!
}
