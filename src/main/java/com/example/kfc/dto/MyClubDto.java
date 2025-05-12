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
    private List<FormationDto> formations; // ✅ 추가됨
}
