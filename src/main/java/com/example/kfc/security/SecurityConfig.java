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
                .csrf(AbstractHttpConfigurer::disable)  // ✅ Modern method to disable CSRF
                .cors(cors -> {})                       // ✅ Allow default CORS
                .headers(headers -> headers
                                 .frameOptions(frame -> frame.disable()) // ✅ Allow H2 Console
                        )
                .authorizeHttpRequests(auth -> auth
                                               .requestMatchers("/api/login", "/api/signup", "/api/register", "/h2-console/**").permitAll()
                                               .requestMatchers("/api/me").authenticated()
                                               .anyRequest().authenticated()
                                      )
                .sessionManagement(sess -> sess
                                           .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // ✅ Required for JWT
                                  )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // ✅ Apply custom filter

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // ✅ Used for comparing bcrypt during login
    }
}
