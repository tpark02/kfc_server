package com.example.kfc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;

    @Column
    private Long rank;

    @Column
    private String name;

    @Column
    private Long ovr;

    @Column
    private Long pac;

    @Column
    private Long sho;

    @Column
    private Long pas;

    @Column
    private Long dri;

    @Column
    private Long def;

    @Column
    private Long phy;

    @Column
    private Long acceleration;

    @Column
    private Long sprintSpeed;

    @Column
    private Long positioning;

    @Column
    private Long finishing;

    @Column
    private Long shotPower;

    @Column
    private Long longShots;

    @Column
    private Long volleys;

    @Column
    private Long penalties;

    @Column
    private Long vision;

    @Column
    private Long crossing;

    @Column
    private Long freeKickAccuracy;

    @Column
    private Long shortPassing;

    @Column
    private Long longPassing;

    @Column
    private Long curve;

    @Column
    private Long dribbling;

    @Column
    private Long agility;

    @Column
    private Long balance;

    @Column
    private Long reactions;

    @Column
    private Long ballControl;

    @Column
    private Long composure;

    @Column
    private Long interceptions;

    @Column
    private Long headingAccuracy;

    @Column
    private Long defAwareness;

    @Column
    private Long standingTackle;

    @Column
    private Long slidingTackle;

    @Column
    private Long jumping;

    @Column
    private Long stamina;

    @Column
    private Long strength;

    @Column
    private Long aggression;

    @Column
    private String pos;

    @Column
    private Long weakFoot;

    @Column
    private Long skillMoves;

    @Column
    private String preferredFoot;

    @Column
    private String height;

    @Column
    private String weight;

    @Column
    private String alternativePositions;

    @Column
    private Long age;

    @Column
    private String nation;

    @Column
    private String league;

    @Column
    private String team;

    @Column
    private String playStyle;

    @Column
    private String url;

    @Column
    private String img;

    @Column
    private Long gkDiving;

    @Column
    private Long gkHandling;

    @Column
    private Long gkKicking;

    @Column
    private Long gkPositioning;

    @Column
    private Long gkReflexes;
}
