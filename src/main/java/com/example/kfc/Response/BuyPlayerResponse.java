package com.example.kfc.Response;

import com.example.kfc.entity.MyPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class BuyPlayerResponse {
    private List<MyPlayer> updatedMyPlayers;
    private String msg;
    private String purchasedPlayer;
}
