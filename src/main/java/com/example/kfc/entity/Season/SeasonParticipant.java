package com.example.kfc.entity.Season;

import com.example.kfc.entity.UserInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class SeasonParticipant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonManagedReference // Participant → UserInfo 는 직렬화
    private UserInfo user;

    @ManyToOne
    @JsonBackReference // Participant → Season 방향은 무시
    private Season season;

    private int round; // 1 = 8강, 2 = 4강, 3 = 결승
    private boolean eliminated;
}
