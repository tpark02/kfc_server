package com.example.kfc.controller.Season;

import com.example.kfc.Response.JoinSeasonResponse;
import com.example.kfc.dto.MatchResponse;
import com.example.kfc.dto.ParticipantDto;
import com.example.kfc.dto.SeasonDto;
import com.example.kfc.entity.Season.Match;
import com.example.kfc.entity.Season.Season;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.Season.MatchRepository;
import com.example.kfc.repository.Season.SeasonParticipantRepository;
import com.example.kfc.repository.Season.SeasonRepository;
import com.example.kfc.repository.UserInfoRepository;
import com.example.kfc.service.Season.SeasonService;
import com.example.kfc.service.Season.TournamentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/season")
public class SeasonController {
    private final SeasonParticipantRepository seasonParticipantRepository;
    private final TournamentService tournamentService;
    private final MatchRepository matchRepository;
    private final UserInfoRepository userInfoRepository;
    private final SeasonRepository seasonRepository;
    private final SeasonService seasonService;

    @Transactional
    @PostMapping("/{seasonId}/join")
    public ResponseEntity<JoinSeasonResponse> joinSeason(
            @PathVariable Long seasonId,
            @RequestParam Long userId) {

        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new IllegalArgumentException("❌ Season not found: id = " + seasonId));

        if (season.isStarted()) {
            return ResponseEntity.badRequest()
                    .body(new JoinSeasonResponse(seasonId, "The league has already started"));
        }

        UserInfo user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("joinSeason - couldn't find user"));

        boolean alreadyJoined = seasonParticipantRepository.existsBySeasonIdAndUserId(seasonId, userId);
        if (alreadyJoined) {
            return ResponseEntity.ok(new JoinSeasonResponse(seasonId, "Already joined"));
        }

        SeasonParticipant emptySlot = seasonParticipantRepository
                .findFirstBySeasonIdAndUserIsNullAndActiveTrueOrderByIdAsc(seasonId)
                .orElseThrow(() -> new IllegalStateException("No empty slot available"));

        emptySlot.setUser(user);
        seasonParticipantRepository.save(emptySlot);

        //tournamentService.tryStartTournament
        // (season);

        return ResponseEntity.ok(new JoinSeasonResponse(seasonId, "Joined successfully"));
    }


    @GetMapping("/{seasonId}/matches")
    public List<MatchResponse> getMatches(@PathVariable Long seasonId) {
        List<Match> matches = matchRepository.findBySeasonId(seasonId);

        return matches.stream().map(match -> {
            String player1 = match.getPlayer1() != null ? match.getPlayer1().getUsername() : "❓";
            String player2 = match.getPlayer2() != null ? match.getPlayer2().getUsername() : "❓";
            String winner = match.getWinner() != null ? match.getWinner().getUsername() : "TBD";
            return new MatchResponse(
                    match.getId(),
                    match.getRound(),
                    player1,
                    player2,
                    winner
            );
        }).toList();
    }

    @PostMapping("/create")
    public ResponseEntity<Season> createSeason(@RequestParam String name) {
        Season newSeason = new Season();
        newSeason.setName(name);
        newSeason.setStarted(false);
        Season savedSeason = seasonRepository.save(newSeason);

        // Pre-create 8 empty participant slots
        for (int i = 0; i < 8; i++) {
            SeasonParticipant slot = new SeasonParticipant();
            slot.setSeason(savedSeason);
            slot.setUser(null); // empty slot
            slot.setRound(1);
            slot.setEliminated(false);
            slot.setActive(true); // for soft delete handling
            seasonParticipantRepository.save(slot);
        }

        return ResponseEntity.ok(savedSeason);
    }

    @GetMapping("/all")
    public List<SeasonDto> getAllSeasons() {
        List<Season> seasons = seasonRepository.findAll();
        return seasons.stream()
                .map(SeasonDto::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{seasonId}/participants")
    public ResponseEntity<List<ParticipantDto>> getParticipants(@PathVariable Long seasonId) {
        List<ParticipantDto> participants = seasonService.getParticipantsBySeasonId(seasonId);
        return ResponseEntity.ok(participants);
    }

    @PutMapping("/{seasonId}/leave")
    public ResponseEntity<String> softLeaveSeason(
            @PathVariable Long seasonId,
            @RequestParam Long userId
                                                 ) {
        // Find the participant to soft delete
        SeasonParticipant participant = seasonParticipantRepository
                .findBySeasonIdAndUserIdAndActiveTrue(seasonId, userId)
                .orElseThrow(() -> new IllegalArgumentException("Participant not found"));

        // Soft delete: mark inactive and release slot
        participant.setActive(false);
        participant.setUser(null); // mark slot as reusable
        seasonParticipantRepository.save(participant);

        return ResponseEntity.ok("Soft leave successful");
    }

    @GetMapping("/{seasonId}")
    public ResponseEntity<SeasonDto> getSeason(@PathVariable Long seasonId) {
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new IllegalArgumentException("Season not found"));

        SeasonDto dto = SeasonDto.from(season);
        return ResponseEntity.ok(dto);
    }
}