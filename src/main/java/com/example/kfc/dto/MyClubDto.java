package com.example.kfc.dto;

import com.example.kfc.entity.MyClub;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class MyClubDto {
    private Long id;
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
                club.getId(),
                club.getClubId(),
                club.getName(),
                club.getFormation() != null ? club.getFormation().getName() : null, // ✅ 여기!
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
