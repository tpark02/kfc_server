package com.example.kfc.controller;

import com.example.kfc.Request.MyClubRequest;
import com.example.kfc.dto.MyClubDto;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.entity.Formation;
import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.PlayerRepository;
import com.example.kfc.service.MyClubService;
import com.example.kfc.service.MyPlayerService;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173") // Vite dev 서버 주소
@RestController
//@RequestMapping("/api")
@RequiredArgsConstructor
public class MyClubController {

    private final UserInfoService userInfoService;
    private final MyClubService myClubService;
    //private final FormationService formationService;
    private final PlayerRepository playerRepository;
    private final MyPlayerService myPlayerService;

    @GetMapping("/users/{userId}/myclubs")
    public List<MyClubDto> getMyClubs(@PathVariable Long userId) {
        UserInfo user = userInfoService.getUserById(userId);
        List<MyClub> clubs = myClubService.getClubsByUser(user);
        List<MyClubDto> result = new ArrayList<>();

        for (MyClub club : clubs) {
            List<MyPlayer> myPlayers = myPlayerService.getMyPlayer(userId, club.getClubId());

            var lst = myPlayers.stream().map(MyPlayerDto::from).toList();

            Formation f = club.getFormations();
            var formationName = f.getName();
            //List<PlayerDto> playerDtos = new ArrayList<>();

//            for (int i = 1; i <= 26; i++) {
//                try {
//                    Method getter = Formation.class.getMethod("getP" + i);
//                    Long playerId = (Long) getter.invoke(f);
//                    if (playerId != null) {
//                        Player player =
//                        playerRepository.searchPlayerById(playerId).orElse(null);
//
//                        if (player == null) {
//                            throw new IllegalArgumentException("player does not exist [" + playerId.toString() + "]");
//                        }
//
//                        playerDtos.add(PlayerDto.from(player));
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }

            MyClubDto dto = new MyClubDto(
                    club.getClubId(),
                    club.getName(),
                    formationName,
                    lst,
                    club.getOvr(), club.getPrice(), club.getAge(), club.getPace(), club.getDef(),
                    club.getAtk(), club.getCch(), club.getStm()
            );

            result.add(dto);
        }

        return result;

    }

//    TODO: perhaps used later for creating login. because a user must have 3 clubs
//    @GetMapping("/users/{userId}/myplayers")
//    public List<MyClubDto> getMyPlayers(@PathVariable Long userId) {
//        UserInfo user = userInfoService.getUserById(userId);
//
//    }

//    @PostMapping("/users/{userId}/myclubs")
//    public ResponseEntity<?> createMyClub(@PathVariable Long userId, @RequestBody MyClubRequest request) {
//        try {
//            myClubService.createMyClub(userId, request);
//            return ResponseEntity.ok("클럽 저장 성공");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }

    @PutMapping("/updatemyclub/{userId}/{clubId}")
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

    @DeleteMapping("/deletemyclub/{userId}/{clubId}")
    public ResponseEntity<String> deleteMyClub(@PathVariable Long userId, @PathVariable Long clubId) {
        try {
            var updatedClub = myClubService.resetClub(userId, clubId).orElse(null);
            return updatedClub != null ? ResponseEntity.ok("club deleted") : ResponseEntity.ok("club deletion failed");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}