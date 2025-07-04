package com.example.kfc.entity.Season;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    @Column
    private boolean started;

    @OneToMany(mappedBy = "season")
    @JsonManagedReference
    private List<SeasonParticipant> participants;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime finishedAt;

    @Column
    private Long userId;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
