package com.example.kfc.dto;

import com.example.kfc.entity.Season.Season;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDto {
    private Long id;
    private String name;
    private boolean started;
    private LocalDateTime createdAt;
    private List<String> participantNames;
    private int remainingSeconds; // 👈 추가됨

    public static SeasonDto from(Season season) {
        List<String> names = season.getParticipants().stream()
                .filter(p -> p.getUser() != null)
                .map(p -> p.getUser().getUsername())
                .toList();

        int remaining = 0;
        if (!season.isStarted()) {
            Duration duration = Duration.between(LocalDateTime.now(), season.getCreatedAt().plusSeconds(5));
            remaining = (int) Math.max(0, duration.getSeconds());
        }

        return new SeasonDto(
                season.getId(),
                season.getName(),
                season.isStarted(),
                season.getCreatedAt(),
                names,
                remaining
        );
    }
}

