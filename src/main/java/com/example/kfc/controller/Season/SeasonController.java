package com.example.kfc.controller.Season;

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
import com.example.kfc.service.Season.TournamentService;
import com.example.kfc.service.Season.SeasonService;
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

    @PostMapping("/{seasonId}/join")
    public ResponseEntity<String> joinSeason(@PathVariable Long seasonId, @RequestParam Long userId) {
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new IllegalArgumentException("❌ 해당 시즌 없음: id = " + seasonId));

        if (season.isStarted()) return ResponseEntity.badRequest().body("리그가 이미 시작됨");

        System.out.println("seasonId = " + seasonId);
        System.out.println("userId = " + userId);

        SeasonParticipant participant = new SeasonParticipant();
        UserInfo user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("joinSeason - couldn't find a user"));

        participant.setUser(user);
        participant.setSeason(season);
        participant.setRound(1);
        participant.setEliminated(false);
        seasonParticipantRepository.save(participant);

        tournamentService.tryStartTournament(season);

        return ResponseEntity.ok("참가 완료");
    }

    @GetMapping("/{seasonId}/matches")
    public List<MatchResponse> getMatches(@PathVariable Long seasonId) {
        List<Match> matches = matchRepository.findBySeasonId(seasonId);

        return matches.stream().map(match -> {
            String player1 = match.getPlayer1() != null ? match.getPlayer1().getUsername() : "❓";
            String player2 = match.getPlayer2() != null ? match.getPlayer2().getUsername() : "❓";
            String winner = match.getWinner() != null ? match.getWinner().getUsername() : "미정";
            return new MatchResponse(
                    match.getId(),
                    match.getRound(),
                    player1,
                    player2,
                    winner
            );
        }).toList();
    }

    // SeasonController.java
    @PostMapping("/create")
    public ResponseEntity<Season> createSeason(@RequestParam String name) {
        Season newSeason = new Season();
        newSeason.setName(name);
        newSeason.setStarted(false);
        return ResponseEntity.ok(seasonRepository.save(newSeason));
    }

    @GetMapping("/all")
    public List<SeasonDto> getAllSeasons() {
        List<Season> seasons = seasonRepository.findAll();
        return seasons.stream()
                .map(SeasonDto::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{seasonId}/participants")
    public ResponseEntity<List<ParticipantDto>> getParticipants(@PathVariable Long seasonId) {
        List<ParticipantDto> participants =
                seasonService.getParticipantsBySeasonId(seasonId);
        return ResponseEntity.ok(participants);
    }

    @DeleteMapping("/{seasonId}/leave")
    public ResponseEntity<String> leaveSeason(
            @PathVariable Long seasonId,
            @RequestParam Long userId
                                             ) {
        seasonParticipantRepository.deleteBySeasonIdAndUserId(seasonId, userId);
        return ResponseEntity.ok("탈퇴 완료");
    }
}
