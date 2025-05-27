package com.example.kfc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class AiClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;
    private String name;

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AiFormation> formations = new ArrayList<>();    // getter/setter 생략

    private Long ovr;
    private Long price;
    private Long age;
    private Long pace;
    private Long def;
    private Long atk;
    private Long cch;
    private Long stm;
}
