package com.example.kfc.service.Season;

import com.example.kfc.dto.ParticipantDto;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.repository.Season.MatchRepository;
import com.example.kfc.repository.Season.SeasonParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

// service/SeasonService.java
@Service
@RequiredArgsConstructor
public class SeasonService {

    private final MatchRepository matchRepository;
    private final SeasonParticipantRepository seasonParticipantRepository;

    public List<ParticipantDto> getParticipantsBySeasonId(Long seasonId) {
        List<SeasonParticipant> participants = seasonParticipantRepository.findActiveBySeasonId(seasonId);

        return participants.stream()
                .filter(p -> {
                    if (p.getUser() == null) {
                        System.out.println("❗ user is null for participantId = " + p.getId());
                        return false;
                    }
                    return true;
                })
                .map(p -> Optional.ofNullable(p.getUser())
                        .map(user -> new ParticipantDto(user.getId(), user.getUsername(), 0L, 0L))
                        .orElse(null))
                .filter(Objects::nonNull)
                .toList();


    }
}
