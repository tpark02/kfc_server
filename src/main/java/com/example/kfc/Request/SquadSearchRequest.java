package com.example.kfc.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SquadSearchRequest {
    private int page;
    private String country;
    private String league;
    private String club;
    private String pos;
    private String name;
}
