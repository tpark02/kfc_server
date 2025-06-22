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
    @JsonManagedReference
    private UserInfo user;

    @ManyToOne
    @JsonBackReference
    private Season season;

    private Long clubId;

    private int round;
    private boolean eliminated;

    @Column(nullable = false)
    private boolean active = true;
}
