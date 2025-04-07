package com.example.kfc.dto;

import com.example.kfc.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class TeamForm {
    private Long id;
    private String name;
    private String url;

    public static TeamForm from(Team team) {
        return new TeamForm(team.getId(), team.getTeam(), team.getUrl());
    }
}
