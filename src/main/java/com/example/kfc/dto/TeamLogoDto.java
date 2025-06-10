package com.example.kfc.dto;

import com.example.kfc.entity.Team;
import com.example.kfc.entity.TeamLogo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class TeamLogoDto {
    private Long id;
    private String logo_img;

    public static TeamLogoDto from(TeamLogo teamLogo) {
        return new TeamLogoDto(teamLogo.getId(), teamLogo.getLogoImg());
    }
}
