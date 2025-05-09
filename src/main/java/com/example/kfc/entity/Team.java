package com.example.kfc.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;

    @Column
    private String team;

    @Column
    private String url;

    public Team(String bye) {
        this.team = bye;
        this.url = "";
    }
}
