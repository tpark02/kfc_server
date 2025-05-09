package com.example.kfc.Response;

import com.example.kfc.dto.PlayerDto;
import lombok.Getter;

import java.util.List;

@Getter

public class SquadResponse {
    private final List<PlayerDto> content;
    private final String name;
    private final String myTeamName;
    public SquadResponse(String name, List<PlayerDto> content, String myTeamName) {
        this.content = content;
        this.name = name;
        this.myTeamName = myTeamName;
    }
}
