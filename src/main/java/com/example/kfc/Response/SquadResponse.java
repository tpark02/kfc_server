package com.example.kfc.Response;

import com.example.kfc.dto.PlayerDto;
import lombok.Getter;

import java.util.List;

@Getter

public class SquadResponse {
    private final List<PlayerDto> content;
    private final String name;
    public SquadResponse(String name, List<PlayerDto> content) {
        this.content = content;
        this.name = name;
    }
}
