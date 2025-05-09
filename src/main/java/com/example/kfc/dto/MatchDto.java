package com.example.kfc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}
