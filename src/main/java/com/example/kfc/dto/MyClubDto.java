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
public class MyClubDto {
    private Long clubId;
    private String name;
    private String formationName;
//    private List<FormationDto> formations; // ✅ 추가됨
    private List<MyPlayerDto> players;
    private Long ovr;
    private Long price;
    private Long age;
    private Long pace;
    private Long defense;
    private Long attack;
    private Long clubCohesion;
    private Long stamina;
}
