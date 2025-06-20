package com.example.kfc.service;// service/AuthService.java

import com.example.kfc.dto.AuthRequest;
import com.example.kfc.dto.AuthResponse;
import com.example.kfc.entity.MyFormation;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.UserInfoRepository;
import com.example.kfc.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private UserInfoRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private JwtUtil jwtUtil;

    private final MyClubService myClubService;
    private final MyFormationService myFormationService;
    private final MyPlayerService myPlayerService;

    public AuthResponse signupAndGenerateToken(AuthRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("This username is already taken. Please choose another.");
        }

        UserInfo newUser = new UserInfo();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setEmail(request.getEmail());
        newUser.setAi(false);
        newUser.setCoin(100L);
        newUser.setTournamentToken(2L);
        newUser.setLeagueToken(2L);

        UserInfo savedUser = userRepository.save(newUser);

        String token = jwtUtil.generateToken(savedUser.getUsername());
        Long userId = savedUser.getId(); // ✅ 저장 후 ID 추출

        myClubService.createClubForUser(userId, "");
        myFormationService.createEmptyFormation(userId, "");
        myPlayerService.createEmptyPlayers(userId, 1L);

        return new AuthResponse(token, userId);
    }
}
