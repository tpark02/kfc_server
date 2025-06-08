package com.example.kfc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthFilter jwtAuthFilter) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // ✅ 최신 방식
                .cors(cors -> {})                       // ✅ 기본 CORS 허용 (필요 시 설정 추가 가능)
                .headers(headers -> headers
                                 .frameOptions(frame -> frame.disable()) // ✅ H2 Console 사용 가능하도록
                        )
                .authorizeHttpRequests(auth -> auth
                                               .requestMatchers("/api/login", "/api/register", "/h2-console/**").permitAll()
                                               .anyRequest().authenticated()
                                      )
                .sessionManagement(sess -> sess
                                           .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // ✅ JWT 사용 시 필수
                                  )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // ✅ 커스텀 필터 적용

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // ✅ 로그인 시 bcrypt 비교용
    }
}
