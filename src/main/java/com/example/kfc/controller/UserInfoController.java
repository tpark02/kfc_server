package com.example.kfc.controller;

import com.example.kfc.Request.UserInfoRequest;
import com.example.kfc.dto.*;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.service.MyFormationService;
import com.example.kfc.service.MyClubService;
import com.example.kfc.service.MyPlayerService;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService userInfoService;
    private final MyClubService myClubService;
    private final MyFormationService myFormationService;
    private final MyPlayerService myPlayerService;

    @GetMapping("/users/{userId}")
    public UserInfoDto getUserInfoById(@PathVariable Long userId) {
        UserInfo info = userInfoService.findUserInfoById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Could not find user info, user id - " + userId));
        return UserInfoDto.from(info);
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> getCurrentUserInfo() {
        Long userId = userInfoService.getCurrentUserId();

        var userinfo = userInfoService.getUserById(userId);
        var myclub = myClubService.getClubsByUser(userinfo).get(0);
        var formation = myFormationService.getFormationsByClub(myclub).orElseThrow(() -> new IllegalArgumentException(
                " user info controller - /api/me - getCurrentUserInfo errr - getting formation"));
        var myPlayers = myPlayerService.getMyPlayers(userId);
        List<MyPlayerDto> myPlayerDtoList = myPlayers.stream().map(MyPlayerDto::from).toList();

        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        result.put("myClub", MyClubDto.from(myclub));
        result.put("myFormation", FormationDto.from(formation));
        result.put("myPlayers", myPlayerDtoList);
        result.put("myCoin", userinfo.getCoin());

        return ResponseEntity.ok(result);
    }
}
