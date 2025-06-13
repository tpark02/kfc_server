package com.example.kfc.dto;

import com.example.kfc.entity.Formation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class FormationDto {
    private Long id;
    private String name;
    private Long p1;
    private Long p2;
    private Long p3;
    private Long p4;
    private Long p5;
    private Long p6;
    private Long p7;
    private Long p8;
    private Long p9;
    private Long p10;
    private Long p11;
    private Long p12;
    private Long p13;
    private Long p14;
    private Long p15;
    private Long p16;
    private Long p17;
    private Long p18;
    private Long p19;
    private Long p20;
    private Long p21;
    private Long p22;
    private Long p23;
    private Long p24;
    private Long p25;
    private Long p26;
    private Long p27;

    public static FormationDto from(Formation formation) {
        return new FormationDto(
                formation.getId(),
                formation.getName(),
                formation.getP1(),
                formation.getP2(),
                formation.getP3(),
                formation.getP4(),
                formation.getP5(),
                formation.getP6(),
                formation.getP7(),
                formation.getP8(),
                formation.getP9(),
                formation.getP10(),
                formation.getP11(),
                formation.getP12(),
                formation.getP13(),
                formation.getP14(),
                formation.getP15(),
                formation.getP16(),
                formation.getP17(),
                formation.getP18(),
                formation.getP19(),
                formation.getP20(),
                formation.getP21(),
                formation.getP22(),
                formation.getP23(),
                formation.getP24(),
                formation.getP25(),
                formation.getP26(),
                formation.getP27()
        );
    }
}
