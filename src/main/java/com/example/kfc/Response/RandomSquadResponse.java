package com.example.kfc.Response;

import com.example.kfc.dto.PlayerDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RandomSquadResponse {
    private List<PlayerDto> content;
    private Long myTeamOvr;
    private Long chemistry;
    private String myTeamName;
    private Long myTeamClubCohesion;
    private Long myTeamStamina;
    private Long myTeamAge;
    private Long myTeamAtk;
    private Long myTeamDef;
    private Long myTeamPace;
    private Long myTeamSquadValue;
//    private List<PlayerDto> benchPlayers;
}
