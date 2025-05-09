package com.example.kfc.Request;

import com.example.kfc.dto.PlayerDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SimGenerateRequest {
    private String myTeamName;
    private List<PlayerDto> myTeamMembers;
}
