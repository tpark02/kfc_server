package com.example.kfc.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MyClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clubId;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserInfo user;

    @OneToOne(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private MyFormation formation;

    private Long ovr;
    private Long price;
    private Long age;
    private Long pace;
    private Long def;
    private Long atk;
    private Long cch;
    private Long stm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_logo_id", referencedColumnName = "id")
    private TeamLogo teamLogo;

    @Column
    private String nation;
}
