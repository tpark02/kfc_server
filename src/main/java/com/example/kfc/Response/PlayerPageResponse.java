package com.example.kfc.Response;

import com.example.kfc.dto.PlayerDto;
import lombok.Getter;

import java.util.List;

@Getter
public class PlayerPageResponse {

    private final List<PlayerDto> playerList;
    private final int number;
    private int size;
    private int totalPages;
    private long totalElements;

    public PlayerPageResponse(List<PlayerDto> playerDtoList, int number, int size, int totalPages, long totalElements) {
        this.playerList = playerDtoList;
        this.number = number;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
}
