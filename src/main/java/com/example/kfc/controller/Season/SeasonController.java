package com.example.kfc.controller.Season;

import com.example.kfc.Request.CreateSeasonRequest;
import com.example.kfc.Response.JoinSeasonResponse;
import com.example.kfc.data.FormationUtil;
import com.example.kfc.dto.MatchResponse;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.dto.ParticipantDto;
import com.example.kfc.dto.SeasonDto;
import com.example.kfc.entity.AiFormation;
import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.Player;
import com.example.kfc.entity.Season.Match;
import com.example.kfc.entity.Season.Season;
import com.example.kfc.entity.Season.SeasonParticipant;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.AiFormationRepository;
import com.example.kfc.repository.Season.MatchRepository;
import com.example.kfc.repository.Season.SeasonParticipantRepository;
import com.example.kfc.repository.Season.SeasonRepository;
import com.example.kfc.repository.UserInfoRepository;
import com.example.kfc.service.MyPlayerService;
import com.example.kfc.service.PlayerService;
import com.example.kfc.service.RandomTeamService;
import com.example.kfc.service.Season.SeasonService;
import com.example.kfc.service.Season.TournamentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.*;
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
    private final MyPlayerService myPlayerService;
    private final AiFormationRepository aiFormationRepository;
    private final PlayerService playerService;

    public static Map<Long, Long> matchParticipantsInfoMap = new HashMap<>();

    @Transactional
    @PostMapping("/{seasonId}/join")
    public ResponseEntity<JoinSeasonResponse> joinSeason(
            @PathVariable Long seasonId,
            @RequestParam Long userId, @RequestParam Long clubId) {

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
        emptySlot.setClubId(clubId);
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

            boolean isAi1 = match.getIsAi1();
            boolean isAi2 = match.getIsAi2();

            List<MyPlayerDto> lst1 = null;
            List<MyPlayerDto> lst2 = null;

            if (isAi1) {
               lst1 = makeAiMyPlayerDtoList(match.getPlayer1().getId(), match.getClubId1());
            } else {
                List<MyPlayer> myPlayerList = myPlayerService.getMyPlayer(match.getPlayer1().getId(), match.getClubId1());
                lst1 = myPlayerList.stream().map(MyPlayerDto::from).collect(Collectors.toList());
            }

            if (isAi2) {
                lst2 = makeAiMyPlayerDtoList(match.getPlayer2().getId(), match.getClubId2());
            } else {
                List<MyPlayer> myPlayerList = myPlayerService.getMyPlayer(match.getPlayer2().getId(), match.getClubId2());
                lst2 = myPlayerList.stream().map(MyPlayerDto::from).collect(Collectors.toList());
            }

            return new MatchResponse(
                    match.getId(),
                    match.getRound(),
                    player1,
                    player2,
                    winner,
                    lst1,
                    lst2
            );
        }).toList();
    }

    @Transactional
    public List<MyPlayerDto> makeAiMyPlayerDtoList(Long userId, Long clubId) {
        try {
            List<AiFormation> ailst = aiFormationRepository.findByClub_ClubId(clubId).orElseThrow(
                    () -> new IllegalArgumentException("AI Formation not found by club id - " + clubId));

            int size = FormationUtil.formationNames.size();
            Random r = SeasonService.random;
            String formationName = FormationUtil.formationNames.get(r.nextInt(size));

            AiFormation aiFormation = ailst.stream()
                    .filter(f -> f.getName().equals(formationName))
                    .findFirst()
                    .orElse(null);

            return validateAiFormation(aiFormation, userId, clubId, 0L, 0L);
        } catch (Exception e) {
            throw new IllegalArgumentException("makeMyPlayerDtoList failed");
        }
    }

    @Transactional
    public List<MyPlayerDto> validateAiFormation(AiFormation aiFormation, Long userId, Long clubId, Long yellowCard, Long redCard) {
        List<MyPlayerDto> lst = new ArrayList<>();

        for (int i = 1; i <= RandomTeamService.numberOfTotalPlayers; i++) {
            String methodName = "getP" + i;
            try {
                Method method = AiFormation.class.getMethod(methodName);
                Long value = (Long) method.invoke(aiFormation);

                // 예: null 값이 있으면 예외 던짐
                if (value == null) {
                    throw new IllegalArgumentException("❌ p" + i + " is null in formation: " + aiFormation.getName());
                }

                Player player = playerService.searchPlayerById(value);
                MyPlayerDto myPlayerDto = MyPlayerDto.from(player, userId, clubId, yellowCard, redCard, (long) i);
                lst.add(myPlayerDto);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException(" validateAiFormation Failed to access " + methodName, e);
            }
        }
        return lst;
    }

//    @PostMapping("/create")
//    public ResponseEntity<Object> createSeason(@RequestBody CreateSeasonRequest request) {
//        String name = request.getName();
//        Long userId = request.getUserId();
//        var lst = seasonRepository.findByUserId(userId);
//
//        lst.forEach(s->{
//            System.out.println(s.getFinishedAt());
//        });
//        var ownerLst = lst.stream()
//                .filter(s -> s.getUserId().equals(userId) && s.getFinishedAt() == null)
//                .toList();
//
//        if (!ownerLst.isEmpty()) {
//            SeasonDto dto = SeasonDto.from(ownerLst.get(0),
//                                           "Your season [" + ownerLst.get(0).getId() + "] is still in progress");
//            return ResponseEntity.ok(dto);
//        }
//
//        Season newSeason = new Season();
//        newSeason.setName(name);
//        newSeason.setUserId(userId);
//        newSeason.setStarted(false);
//        Season savedSeason = seasonRepository.save(newSeason);
//
//        // create 8 empty participants' slots
//        for (int i = 0; i < 8; i++) {
//            SeasonParticipant slot = new SeasonParticipant();
//            slot.setSeason(savedSeason);
//            slot.setUser(null);
//            slot.setRound(1);
//            slot.setEliminated(false);
//            slot.setActive(true);
//            seasonParticipantRepository.save(slot);
//        }
//
//        // the creator joins
//        joinSeason(newSeason.getId(), userId);
//
//        SeasonDto dto = SeasonDto.from(savedSeason, "Season is created " + savedSeason.getId());
//        return ResponseEntity.ok(dto);
//    }

    @PostMapping("/create")
    public ResponseEntity<Object> createSeason(@RequestBody CreateSeasonRequest request) {
        SeasonDto dto = seasonService.createSeason(request.getName(), request.getUserId(), request.getClubId());
        return ResponseEntity.ok(dto);
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

    @GetMapping("/getSeason/{seasonId}")
    public ResponseEntity<SeasonDto> getSeason(@PathVariable Long seasonId) {
        Season season = seasonRepository.findById(seasonId)
                .orElseThrow(() -> new IllegalArgumentException("Season not found"));

        SeasonDto dto = SeasonDto.from(season);
        return ResponseEntity.ok(dto);
    }
}