package com.example.kfc.api;

import com.example.kfc.Request.MyClubRequest;
import com.example.kfc.dto.MyClubDto;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.entity.Formation;
import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.Player;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.PlayerRepository;
import com.example.kfc.service.FormationService;
import com.example.kfc.service.MyClubService;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Vite dev 서버 주소
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyClubController {

    private final UserInfoService userInfoService;
    private final MyClubService myClubService;
    private final FormationService formationService;
    private final PlayerRepository playerRepository;

    @GetMapping("/users/{userId}/myclubs")
    public List<MyClubDto> getMyClubs(@PathVariable Long userId) {
        UserInfo user = userInfoService.getUserById(userId);
        List<MyClub> clubs = myClubService.getClubsByUser(user);

        List<MyClubDto> result = new ArrayList<>();

        for (MyClub club : clubs) {
            var formations = club.getFormations();
            Formation f = formations;
            var formationName = f.getName();
            List<PlayerDto> playerDtos = new ArrayList<>();

            for (int i = 1; i <= 26; i++) {
                try {
                    Method getter = Formation.class.getMethod("getP" + i);
                    Long playerId = (Long) getter.invoke(f);
                    if (playerId != null) {
                        Player player = playerRepository.searchPlayerById(playerId);
                        playerDtos.add(PlayerDto.from(player));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            MyClubDto dto = new MyClubDto(
                    club.getClubId(),
                    club.getName(),
                    formationName,
                    playerDtos,
                    club.getOvr(), club.getPrice(), club.getAge(), club.getPace(), club.getDef(),
                    club.getAtk(), club.getCch(), club.getStm()
            );

            result.add(dto);
        }

        return result;

    }

    @PostMapping("/users/{userId}/myclubs")
    public ResponseEntity<?> saveMyClub(@PathVariable Long userId, @RequestBody MyClubRequest request) {
        try {
            myClubService.createMyClub(userId, request);
            return ResponseEntity.ok("클럽 저장 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // ✅ 특정 MyClub의 포메이션 목록 조회
    // todo
    @GetMapping("/myclubs/{myClubId}/formations")
    public List<Formation> getFormationsOfMyClub(@PathVariable Long myClubId) {
        MyClub club = myClubService.getClubById(myClubId);
        var formation = formationService.getFormationsByClub(club);
        var f = formation.orElse(null);

        if (f == null) {
            return null;
        }

        return null;
    }

    @PutMapping("/updatemyclub/{clubId}")
    public ResponseEntity<String> updateMyClub(@PathVariable Long clubId, @RequestBody MyClub clubRequest) {
        try {
            myClubService.updateClub(clubId, clubRequest);
            return ResponseEntity.ok("클럽 수정 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/deletemyclub/{clubId}")
    public void deleteMyClub(@PathVariable Long clubId) {
        myClubService.deleteClub(clubId);
    }
}