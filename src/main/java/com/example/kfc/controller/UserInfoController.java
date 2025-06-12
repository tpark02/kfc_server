package com.example.kfc.controller;

import com.example.kfc.Request.UserInfoRequest;
import com.example.kfc.dto.UserInfoDto;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoService userInfoService;

    @PostMapping("/userInfo/")
    public UserInfoDto getUserInfoById(@RequestBody UserInfoRequest request) {
        Long userId = request.getUserId();
        UserInfo info = userInfoService.findUserInfoById(userId).orElseThrow(() -> new IllegalArgumentException("Could not find user info, user id - " + userId));
        return UserInfoDto.from(info);
    }

    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> getCurrentUserInfo() {
        Long userId = userInfoService.getCurrentUserId();

        Map<String, Object> result = new HashMap<>();
        result.put("userId", userId);
        return ResponseEntity.ok(result);
    }
}
