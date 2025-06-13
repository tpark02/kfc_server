package com.example.kfc.dto;

import com.example.kfc.entity.MyFormation;
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

    public static FormationDto from(MyFormation myFormation) {
        return new FormationDto(
                myFormation.getId(),
                myFormation.getName(),
                myFormation.getP1(),
                myFormation.getP2(),
                myFormation.getP3(),
                myFormation.getP4(),
                myFormation.getP5(),
                myFormation.getP6(),
                myFormation.getP7(),
                myFormation.getP8(),
                myFormation.getP9(),
                myFormation.getP10(),
                myFormation.getP11(),
                myFormation.getP12(),
                myFormation.getP13(),
                myFormation.getP14(),
                myFormation.getP15(),
                myFormation.getP16(),
                myFormation.getP17(),
                myFormation.getP18(),
                myFormation.getP19(),
                myFormation.getP20(),
                myFormation.getP21(),
                myFormation.getP22(),
                myFormation.getP23(),
                myFormation.getP24(),
                myFormation.getP25(),
                myFormation.getP26(),
                myFormation.getP27()
        );
    }
}
