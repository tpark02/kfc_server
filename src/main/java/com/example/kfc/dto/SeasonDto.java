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
        SeasonDto dto = new SeasonDto();
        dto.setId(season.getId());
        dto.setName(season.getName());

        // ✅ Null-safe 처리
        List<String> participantNames = season.getParticipants().stream()
                .filter(p -> p.getUser() != null) // 필수
                .map(p -> p.getUser().getUsername())
                .collect(Collectors.toList());

        dto.setParticipantNames(participantNames);
        return dto;
    }
}
