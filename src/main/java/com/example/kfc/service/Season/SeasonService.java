package com.example.kfc.service.Season;

import com.example.kfc.dto.ParticipantDto;
import com.example.kfc.entity.Season.Season;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.Season.MatchRepository;
import com.example.kfc.repository.Season.SeasonParticipantRepository;
import com.example.kfc.repository.Season.SeasonRepository;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// service/SeasonService.java
@Service
@RequiredArgsConstructor
public class SeasonService {
    public static final Long matchTime = 3000L;
    private final MatchRepository matchRepository;
    private final SeasonParticipantRepository seasonParticipantRepository;
    private final SeasonRepository seasonRepository;
    private final UserInfoService userInfoService;
    private final TournamentService tournamentService;

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

    @Scheduled(fixedRate = matchTime) // 분마다 실행
    public void checkSeasonStartConditions() {
        List<Season> waitingSeasons = seasonRepository.findByStartedFalse();

        for (Season season : waitingSeasons) {
            //if (Duration.between(season.getCreatedAt(), LocalDateTime.now()).toMinutes() >= 5) {
            if (Duration.between(season.getCreatedAt(), LocalDateTime.now()).getSeconds() >= 5) {

                List<SeasonParticipant> slots = seasonParticipantRepository.findBySeason(season);
                long filledCount = slots.stream().filter(p -> p.getUser() != null).count();

                long emptyCount = 8 - filledCount;

                if (emptyCount > 0) {
                    Iterator<SeasonParticipant> emptySlots = slots.stream()
                            .filter(p -> p.getUser() == null)
                            .iterator();

                    for (int i = 0; i < emptyCount && emptySlots.hasNext(); i++) {
                        UserInfo aiUser = userInfoService.generateRandomUser();
                        SeasonParticipant slot = emptySlots.next();
                        slot.setUser(aiUser);
                        seasonParticipantRepository.save(slot);
                    }
                }

                //season.setStarted(true);
                seasonRepository.save(season);
                tournamentService.tryStartTournament(season);
            }
        }
    }


}
