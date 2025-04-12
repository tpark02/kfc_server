package com.example.kfc.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class LeaguePageResponse {
    private final List<LeagueDto> content;

    public LeaguePageResponse(List<LeagueDto> content) {
        this.content = content;
    }
}
