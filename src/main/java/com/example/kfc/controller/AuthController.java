package com.example.kfc.controller;

import com.example.kfc.dto.AuthRequest;
import com.example.kfc.dto.AuthResponse;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.UserInfoRepository;
import com.example.kfc.security.JwtUtil;
import com.example.kfc.service.AuthService;
import com.example.kfc.service.MyFormationService;
import com.example.kfc.service.MyClubService;
import com.example.kfc.service.MyPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserInfoRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;
    private final UserInfoRepository userInfoRepository;
    private final MyClubService myClubService;
    private final MyFormationService myFormationService;
    private final MyPlayerService myPlayerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            // 👉 Debug log
            UserInfo user = userInfoRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
            boolean matched = passwordEncoder.matches(request.getPassword(), user.getPassword());
            System.out.println("🧪 Password match result: " + matched);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
                                              );

            String token = jwtUtil.generateToken(request.getUsername());
            UserInfo userinfo = userInfoRepository.findByUsername(request.getUsername())
                    .orElseThrow(() -> new IllegalArgumentException(
                            "Auth Controller - User not found: " + request.getUsername()));

            Long userId = userinfo.getId();

            // myClubService (commented out)

            return ResponseEntity.ok(new AuthResponse(token, userId));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("❌ Username or password does not match.");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody AuthRequest request) {
        System.out.println("✅ username = " + request.getUsername());
        System.out.println("✅ password = " + request.getPassword());
        System.out.println("✅ email = " + request.getEmail());

        try {
            AuthResponse response = authService.signupAndGenerateToken(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
