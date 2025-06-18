package com.example.kfc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MatchDto {
    private String homeTeam;
    private String awayTeam;
    private int round;
    private Long ovr;
    private String res;
    private List<PlayerDto> members;
    private Long addStats;
    private String teamImg;
}
