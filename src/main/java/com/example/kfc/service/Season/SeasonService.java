package com.example.kfc.service.Season;

import com.example.kfc.dto.ParticipantDto;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.Season.MatchRepository;
import com.example.kfc.repository.Season.SeasonParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// service/SeasonService.java
@Service
@RequiredArgsConstructor
public class SeasonService {

    private final MatchRepository matchRepository;
    private final SeasonParticipantRepository seasonParticipantRepository;

    public List<ParticipantDto> getParticipantsBySeasonId(Long seasonId) {
        List<SeasonParticipant> participants = seasonParticipantRepository.findBySeasonId(seasonId);
        return participants.stream()
                .map(p -> {
                    UserInfo user = p.getUser();
                    return new ParticipantDto(
                            user.getId(),
                            user.getUsername(),  // 또는 user.getName()
                            0L, // rank - 필요시 계산
                            0L  // ovr - 필요시 계산
                    );
                })
                .toList();
    }
}
