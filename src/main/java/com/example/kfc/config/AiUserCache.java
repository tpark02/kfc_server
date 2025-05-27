package com.example.kfc.config;

import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AiUserCache {

    private final UserInfoRepository userInfoRepository;

    private List<UserInfo> cachedAiUsers = new ArrayList<>();

    @PostConstruct
    public void loadAiUsers() {
        this.cachedAiUsers = userInfoRepository.findByIsAiTrue();
        System.out.println("✅ AI 유저 캐싱 완료: " + cachedAiUsers.size() + "명");
    }

    public UserInfo getAiUser(int index) {
        return cachedAiUsers.get(index % cachedAiUsers.size());
    }

    public List<UserInfo> getAll() {
        return cachedAiUsers;
    }
}
