package com.example.kfc.security;

import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserInfoRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println("✅ [loadUserByUsername] 사용자: " + user.getUsername());
        System.out.println("🔐 [loadUserByUsername] 비밀번호: " + user.getPassword());

        return new CustomUserDetails(user);
    }
}
