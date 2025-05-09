package com.example.kfc.dto;

import com.example.kfc.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class TeamDto {
    private Long id;
    private String name;
    private String url;

    public static TeamDto from(Team team) {
        return new TeamDto(team.getId(), team.getTeam(), team.getUrl());
    }
}
