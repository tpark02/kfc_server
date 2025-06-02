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

    @Column(name = "player1_club_id")
    private Long clubId1;

    @ManyToOne
    private UserInfo player2;

    @Column(name = "player2_club_id")
    private Long clubId2;

    @ManyToOne
    private UserInfo winner;

    @Column(name="is_ai1")
    private Boolean isAi1 = false;

    @Column(name="is_ai2")
    private Boolean isAi2 = false;

    private int round;
}
