package com.example.kfc.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MyClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // ✔ FK가 user.id 참조
    private UserInfo user;

//    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    @OneToOne(mappedBy = "club", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Formation formations;
    // getter/setter 생략

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
