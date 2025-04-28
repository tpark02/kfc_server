package com.example.kfc.Response;

import com.example.kfc.dto.PlayerDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class RandomSquadResponse {
    private List<PlayerDto> content;
    private int totalOvr;   // 전체 팀의 OVR 합
    private double averageOvr; // 팀의 평균 OVR
    private int chemistry; // (나중에 관계를 계산해서)

    public RandomSquadResponse(List<PlayerDto> content, int totalovr, double averageOvr, int chemistry){
        this.content = content;
        this.totalOvr = totalovr;
        this.averageOvr = averageOvr;
        this.chemistry = chemistry;
    }
}

// sr