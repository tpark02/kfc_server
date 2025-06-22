package com.example.kfc.controller;

import com.example.kfc.Request.MyClubRequest;
import com.example.kfc.data.FormationUtil;
import com.example.kfc.dto.MyClubDto;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.entity.*;
import com.example.kfc.repository.PlayerRepository;
import com.example.kfc.service.MyClubService;
import com.example.kfc.service.MyPlayerService;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.IntStream;

//@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MyClubController {

    private final UserInfoService userInfoService;
    private final MyClubService myClubService;
    private final MyPlayerService myPlayerService;

    @GetMapping("/users/{userId}/clubs")
    public MyClubDto getMyClubs(@PathVariable Long userId) {
        try {
            UserInfo user = userInfoService.getUserById(userId);
            List<MyClub> clubs = myClubService.getClubsByUser(user);
            var club = clubs.get(0);
            List<MyPlayer> myPlayers = myPlayerService.getMyPlayers(userId);

            var lst = myPlayers.stream().map(MyPlayerDto::from).toList();
            MyFormation f = club.getFormation();

            var formationName = f.getName();

            // calc team ovr
            double avg = IntStream.range(0, Math.min(17, lst.size()))
                    .mapToLong(i -> lst.get(i).getOvr())
                    .average()
                    .orElse(0.0);
            System.out.println("random formation - avg: " + avg);

            Long myTeamOvr = (long) avg;

            // total squad value
            Long squadValue = lst.stream()
                    .mapToLong(p -> FormationUtil.estimateValue(p, MyPlayerDto::getOvr, MyPlayerDto::getPos,
                                                                MyPlayerDto::getName))
                    .sum();

            // atk, def
            Map<String, Long> atkdef = FormationUtil.getDefenseAttackSplit(lst, MyPlayerDto::getDef,
                                                                           MyPlayerDto::getSho);
            Long atk = atkdef.get("attack");
            Long def = atkdef.get("defense");

            Long pace = FormationUtil.getAverageStat(lst, MyPlayerDto::getPac);
            Long age = FormationUtil.getAverageStat(lst, MyPlayerDto::getAge);
            Long stamina = FormationUtil.getAverageStat(lst, MyPlayerDto::getStamina);
            Long cohesion = FormationUtil.getClubCohesion(lst, MyPlayerDto::getTeam);
            int chemistry = calculateChemistry(lst);

            MyClubDto dto = new MyClubDto(
                    club.getId(),
                    club.getName(),
                    formationName,
                    lst,
                    myTeamOvr,
                    squadValue,
                    age,
                    pace,
                    def,
                    atk,
                    (long) chemistry,
                    stamina,
                    club.getNation(),
                    club.getTeamLogo() != null ? club.getTeamLogo().getLogoImg() : null,
                    club.getTeamLogo() != null ? club.getTeamLogo().getId() : null
            );
            return dto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int calculateChemistry(List<MyPlayerDto> players) {
        int chemistry = 0;

        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals("dummy"))
                continue;

            for (int j = i + 1; j < players.size(); j++) {
                MyPlayerDto p1 = players.get(i);
                MyPlayerDto p2 = players.get(j);

                if (p1.getNation().equals(p2.getNation())) {
                    chemistry += 5;
                }
                if (p1.getLeague().equals(p2.getLeague())) {
                    chemistry += 3;
                }
                if (p1.getTeam().equals(p2.getTeam())) {
                    chemistry += 7;
                }
            }
        }

        return chemistry;
    }

    @PutMapping("/users/{userId}/clubs/{clubId}")
    public ResponseEntity<String> updateMyClub(
            @PathVariable Long userId,
            @PathVariable Long clubId,
            @RequestBody MyClubRequest clubRequest) {
        try {
            Optional<MyClub> updatedClub = myClubService.updateMyClub(userId, clubId, clubRequest);

            if (updatedClub.isPresent()) {
                return ResponseEntity.ok("club saved");
            } else {
                return ResponseEntity.ok("club saving failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error: " + e.getMessage());
        }
    }

    @DeleteMapping("/users/{userId}/clubs/{clubId}")
    public ResponseEntity<String> deleteMyClub(@PathVariable Long userId, @PathVariable Long clubId) {
        try {
            var updatedClub = myClubService.resetClub(userId, clubId).orElse(null);
            return updatedClub != null ? ResponseEntity.ok("club deleted") : ResponseEntity.ok("club deletion failed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/users/{userId}/players/{idx}")
    public ResponseEntity<String> updatePlayer(@PathVariable Long userId, @PathVariable Long idx) {
        try {
            int updated = myPlayerService.deletePlayer(userId, idx);

            if (updated > 0) {
                return ResponseEntity.ok("✅ Update successful");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("❌ Update failed: player not found");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("🔥 server error: " + e.getMessage());
        }
    }
}