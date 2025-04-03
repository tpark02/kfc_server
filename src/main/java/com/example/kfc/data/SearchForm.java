package com.example.kfc.data;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class SearchForm {
    private Long ovr;
    private Long pac;
    private Long sho;
    private Long pas;
    private Long dri;
    private Long def;
    private Long phy;
    private Long acceleration;
    private Long sprintSpeed;
    private Long positioning;
    private Long finishing;
    private Long shotPower;
    private Long longShots;
    private SortType sortType;
}
