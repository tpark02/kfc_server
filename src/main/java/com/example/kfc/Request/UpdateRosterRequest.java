package com.example.kfc.Request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class UpdateRosterRequest {
    private Long userId;
    private Long clubId;
    private Map<Long, Long> rosterMap;
}
