package com.example.kfc.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@ToString
@Getter
@Setter
public class TeamStatDto {
    public int wins = 0;
    public int draws = 0;
    public int losses = 0;
    public int gf = 0;
    public int ga = 0;
    public int pts = 0;
}
