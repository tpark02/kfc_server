package com.example.kfc.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "ai_formation")
public class AiFormation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id", nullable = false)
    private AiClub club;

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
}
