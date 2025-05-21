package com.example.kfc.entity.Season;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private boolean started;

    @OneToMany(mappedBy = "season")
    @JsonManagedReference // Season → Participant 방향만 직렬화
    private List<SeasonParticipant> participants;
}
