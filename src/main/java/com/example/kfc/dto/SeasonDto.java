package com.example.kfc.dto;

import com.example.kfc.entity.Season.Season;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDto {
    private Long id;
    private String name;
    private List<String> participantNames;

    public static SeasonDto convertToDto(Season season) {
        List<String> participantNames = season.getParticipants().stream()
                .map(p -> p.getUser().getUsername())
                .collect(Collectors.toList());

        return new SeasonDto(season.getId(), season.getName(), participantNames);
    }
}
