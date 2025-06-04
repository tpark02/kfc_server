package com.example.kfc.dto;

import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserInfoDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Long coin;
    private Long tournamentToken;
    private Long leagueToken;
    private String isAi;

    public static UserInfoDto from(UserInfo info) {
        String isAi = String.valueOf(info.isAi());
        return new UserInfoDto(info.getId(), info.getUsername(), info.getEmail(), info.getPassword(), info.getCoin(),
                               info.getLeagueToken(), info.getLeagueToken(), isAi);
    }
}
