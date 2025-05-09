package com.example.kfc.Response;

import com.example.kfc.dto.TeamStatDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class SimResultResponse {
    private Map<String, TeamStatDto> table;
    private List<String> logs;
}