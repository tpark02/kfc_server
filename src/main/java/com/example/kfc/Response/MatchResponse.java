package com.example.kfc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResponse {
    private Long id;
    private int round;
    private String player1Name;
    private String player2Name;
    private String winnerName;
}
