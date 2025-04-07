package com.example.kfc.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class TeamPageResponse {
    private final List<TeamForm> content;

    public TeamPageResponse(List<TeamForm> content) {
        this.content = content;
    }
}
