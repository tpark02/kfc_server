package com.example.kfc.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimGenerateRequest {
    private String myTeamName;
    private Long userId;
    private Long clubId;
}
