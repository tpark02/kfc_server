package com.example.kfc.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSeasonRequest {
    private String name;
    private Long userId;
    private Long clubId;
}
