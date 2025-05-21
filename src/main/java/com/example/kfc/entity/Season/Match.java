package com.example.kfc.entity.Season;

import com.example.kfc.entity.UserInfo;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "season_match") // 추천: 예약어 피하기
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Season season;

    @ManyToOne
    private UserInfo player1;

    @ManyToOne
    private UserInfo player2;

    @ManyToOne
    private UserInfo winner;

    private int round;
}
