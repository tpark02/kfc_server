package com.example.kfc.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerSearchRequest {
    private int page;
    private int size;
    private String search;
    private String sortType;
    private List<CountryFilter> filters;

    // getter & setter 필수!
}
