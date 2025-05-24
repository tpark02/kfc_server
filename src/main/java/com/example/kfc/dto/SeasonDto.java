package com.example.kfc.dto;

import com.example.kfc.entity.Season.Season;
import com.example.kfc.service.Season.SeasonService;
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
    private LocalDateTime finishedAt;
    private List<String> participantNames;
    private int remainingSeconds;
    private Long userId;
    private String msg;

    public static SeasonDto from(Season season) {
        return from(season, "");
    }

    public static SeasonDto from(Season season, String msg) {
        List<String> names = List.of(); // 기본 빈 리스트

        if (season.getParticipants() != null) {
            names = season.getParticipants().stream()
                    .filter(p -> p.getUser() != null)
                    .map(p -> p.getUser().getUsername())
                    .toList();
        }

        int remaining = 0;
        if (!season.isStarted()) {
            Duration duration =
                    Duration.between(LocalDateTime.now(), season.getCreatedAt().plusSeconds(SeasonService.matchTime / 1000L));
            remaining = (int) Math.max(0, duration.getSeconds());
        }

        return new SeasonDto(
                season.getId(),
                season.getName(),
                season.isStarted(),
                season.getCreatedAt(),
                season.getFinishedAt(),
                names,
                remaining,
                season.getUserId(),
                msg
        );
    }

}

