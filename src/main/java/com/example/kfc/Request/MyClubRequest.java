package com.example.kfc.Request;

import lombok.Getter;

import java.util.List;

@Getter
public class MyClubRequest {
    private String clubName;
    private String formationName;
    private List<Long> players; // must be 17
    private Long ovr;
    private Long price;
    private Long age;
    private Long pace;
    private Long defense;
    private Long attack;
    private Long clubCohesion;
    private Long stamina;
}
