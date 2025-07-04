package com.example.kfc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "my_formation")
public class MyFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @JsonBackReference
    private MyClub club;

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
}
