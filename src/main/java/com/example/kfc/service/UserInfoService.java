package com.example.kfc.service;

import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public Optional<UserInfo> findUserInfoById(Long id) {
        return userInfoRepository.findById(id);
    }

    public Long getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        UserInfo user = userInfoRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return user.getId();
    }

    public UserInfo getUserById(Long userId) {
        return userInfoRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public Optional<UserInfo> getUserByEmail(String email) {
        return userInfoRepository.findByEmail(email);
    }

    public UserInfo save(UserInfo user) {
        return userInfoRepository.save(user);
    }
    public UserInfo generateRandomUser() {
        UserInfo user = new UserInfo();
        user.setUsername("AI_" + UUID.randomUUID().toString().substring(0, 5));
        user.setEmail(user.getUsername() + "@bot.com"); // optional
        user.setPassword("dummy"); // optional, not used
        user.setAi(true);
        return userInfoRepository.save(user); // 저장 후 반환
    }
}
