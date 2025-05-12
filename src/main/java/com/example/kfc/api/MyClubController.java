package com.example.kfc.api;

import com.example.kfc.dto.FormationDto;
import com.example.kfc.dto.MyClubDto;
import com.example.kfc.entity.Formation;
import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.service.FormationService;
import com.example.kfc.service.MyClubService;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyClubController {

    private final UserInfoService userInfoService;
    private final MyClubService myClubService;
    private final FormationService formationService;

    @GetMapping("/users/{userId}/myclubs")
    public List<MyClubDto> getMyClubs(@PathVariable Long userId) {
        UserInfo user = userInfoService.getUserById(userId);
        List<MyClub> clubs = myClubService.getClubsByUser(user);

        return clubs.stream()
                .map(club -> new MyClubDto(
                        club.getClubId(),
                        club.getName(),
                        club.getFormations().stream()
                                .map(f -> new FormationDto(
                                        f.getId(),
                                        f.getName(),
                                        f.getP1(), f.getP2(), f.getP3(),
                                        f.getP4(), f.getP5(), f.getP6(),
                                        f.getP7(), f.getP8(), f.getP9(),
                                        f.getP10(), f.getP11()
                                ))
                                .toList()
                ))
                .toList();
    }


    // ✅ MyClub 생성 (유저당 3개 제한)
    @PostMapping("/users/{userId}/myclubs")
    public MyClub createMyClub(@PathVariable Long userId, @RequestBody MyClub clubRequest) {
        UserInfo user = userInfoService.getUserById(userId);

        List<MyClub> existingClubs = myClubService.getClubsByUser(user);
        if (existingClubs.size() >= 3) {
            throw new IllegalStateException("클럽은 최대 3개까지 생성할 수 있습니다.");
        }

        clubRequest.setUser(user);
        return myClubService.saveClub(clubRequest);
    }

    // ✅ 특정 MyClub에 포메이션 추가 (13개 제한)
    @PostMapping("/myclubs/{myClubId}/formations")
    public Formation addFormationToMyClub(@PathVariable Long myClubId, @RequestBody Formation formationRequest) {
        MyClub club = myClubService.getClubById(myClubId);

        List<Formation> formations = formationService.getFormationsByClub(club);
        if (formations.size() >= 13) {
            throw new IllegalStateException("포메이션은 최대 13개까지 생성할 수 있습니다.");
        }

        formationRequest.setClub(club);
        return formationService.saveFormation(formationRequest);
    }

    // ✅ 특정 MyClub의 포메이션 목록 조회
    @GetMapping("/myclubs/{myClubId}/formations")
    public List<Formation> getFormationsOfMyClub(@PathVariable Long myClubId) {
        MyClub club = myClubService.getClubById(myClubId);
        return formationService.getFormationsByClub(club);
    }

    @PutMapping("/updatemyclub/{clubId}")
    public MyClub updateMyClub(@PathVariable Long clubId, @RequestBody MyClub clubRequest) {
        return myClubService.updateClub(clubId, clubRequest);
    }

    @DeleteMapping("/deletemyclub/{clubId}")
    public void deleteMyClub(@PathVariable Long clubId) {
        myClubService.deleteClub(clubId);
    }
}