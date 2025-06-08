package com.example.kfc.controller;

import com.example.kfc.dto.AuthRequest;
import com.example.kfc.dto.AuthResponse;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.UserInfoRepository;
import com.example.kfc.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UserInfoRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
                                          );

        String token = jwtUtil.generateToken(request.getUsername());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("❌ 이미 존재하는 사용자입니다.");
        }

        UserInfo newUser = new UserInfo();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword())); // ✅ bcrypt 적용
        newUser.setCoin(0L);
        newUser.setTournamentToken(0L);
        newUser.setLeagueToken(0L);
        newUser.setAi(false);

        userRepository.save(newUser);
        return ResponseEntity.ok("✅ 회원가입 성공");
    }
}
