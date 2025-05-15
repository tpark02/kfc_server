package com.example.kfc.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;
    private String username;
    private String email;
//    @Column(name = "team_name")
//    private String teamName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MyClub> clubs = new ArrayList<>();
}
