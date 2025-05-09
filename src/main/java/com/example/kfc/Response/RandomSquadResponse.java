package com.example.kfc.Response;

import com.example.kfc.dto.PlayerDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RandomSquadResponse {
    private List<PlayerDto> content;
    private Long myTeamOvr; // 팀의 평균 OVR
    private int chemistry; // (나중에 관계를 계산해서)
    private String myTeamName;

    public RandomSquadResponse(List<PlayerDto> content, Long myTeamOvr, int chemistry, String myTeamName){
        this.content = content;
        this.myTeamOvr = myTeamOvr;
        this.chemistry = chemistry;
        this.myTeamName = myTeamName;
    }
}

// sr