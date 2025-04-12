package com.example.kfc.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class PlayerPageResponse {

    private final List<PlayerDto> content;
    private final int number;
    private int size;
    private int totalPages;
    private long totalElements;

    public PlayerPageResponse(List<PlayerDto> content, int number, int size, int totalPages, long totalElements) {
        this.content = content;
        this.number = number;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }
}
