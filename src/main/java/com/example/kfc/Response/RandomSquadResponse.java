package com.example.kfc.Response;

import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.dto.PlayerDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RandomSquadResponse {
    private List<MyPlayerDto> myPlayerList;
    private Long myTeamOvr;
    private Long myTeamClubCohesion;
    private Long myTeamStamina;
    private Long myTeamAge;
    private Long myTeamAtk;
    private Long myTeamDef;
    private Long myTeamPace;
    private Long myTeamSquadValue;
}
