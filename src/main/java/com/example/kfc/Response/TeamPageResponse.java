package com.example.kfc.Response;

import com.example.kfc.dto.TeamDto;
import lombok.Getter;

import java.util.List;

@Getter
public class TeamPageResponse {
    private final List<TeamDto> content;

    public TeamPageResponse(List<TeamDto> content) {
        this.content = content;
    }
}
