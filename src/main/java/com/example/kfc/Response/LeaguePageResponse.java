package com.example.kfc.Response;

import com.example.kfc.dto.LeagueDto;
import lombok.Getter;

import java.util.List;

@Getter
public class LeaguePageResponse {
    private final List<LeagueDto> content;

    public LeaguePageResponse(List<LeagueDto> content) {
        this.content = content;
    }
}
