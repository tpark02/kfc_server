package com.example.kfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponse {
    private Long id;
    private int round;
    private String player1Name;
    private String player2Name;
    private String winnerName;
    private List<MyPlayerDto> myPlayerList1;
    private List<MyPlayerDto> myPlayerList2;
}
