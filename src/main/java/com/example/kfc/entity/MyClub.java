package com.example.kfc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
    private List<Formation> formations = new ArrayList<>();
    // getter/setter 생략
}
