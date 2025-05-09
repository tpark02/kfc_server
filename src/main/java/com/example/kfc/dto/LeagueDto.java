package com.example.kfc.dto;

import com.example.kfc.entity.League;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class LeagueDto {
    private Long id;
    private String name;
    private String url;

    public static LeagueDto from(League league) {
        return new LeagueDto(league.getId(), league.getName(), league.getUrl());
    }
}
