package com.example.kfc.entity;

import com.example.kfc.entity.Season.SeasonParticipant;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;
    private String username;
    private String email;
    private String password;
//    @Column(name = "team_name")
//    private String teamName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore // clubs에서 다시 user로 가는 걸 막기 위해 무시
    private List<MyClub> clubs = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonBackReference // Participant → UserInfo는 직렬화되지 않음
    private List<SeasonParticipant> participants = new ArrayList<>();
}
