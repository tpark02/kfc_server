package com.example.kfc.dto;

import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.MyPlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MyClubDto {
    private Long clubId;
    private String name;
    private String formationName;
    private List<MyPlayerDto> players;

    private Long ovr;
    private Long price;
    private Long age;
    private Long pace;
    private Long defense;
    private Long attack;
    private Long clubCohesion;
    private Long stamina;

    private String nation;
    private String teamLogoImg;

    public static MyClubDto from(MyClub club) {
        return new MyClubDto(
                club.getClubId(),
                club.getName(),
                club.getFormations() != null ? club.getFormations().getName() : null, // ✅ 여기!
                null, // players는 이후 처리
                club.getOvr(),
                club.getPrice(),
                club.getAge(),
                club.getPace(),
                club.getDef(),
                club.getAtk(),
                club.getCch(),
                club.getStm(),
                club.getNation(),
                club.getTeamLogo() != null ? club.getTeamLogo().getLogoImg() : null
        );
    }
}
