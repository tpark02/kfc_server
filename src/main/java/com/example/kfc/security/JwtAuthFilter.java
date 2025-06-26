package com.example.kfc.security;

import com.example.kfc.security.CustomUserDetailsService;
import com.example.kfc.security.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        System.out.println("🛂 Filter executed - URI: " + path);

        // ✅ Skip public endpoints
        if (path.startsWith("/api/login") || path.startsWith("/api/signup") || path.startsWith("/api/register") || path.startsWith("/h2-console")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("🚫 No JWT found in header — skipping auth");
            filterChain.doFilter(request, response); // No token = no auth = let it fail later if needed
            return;
        }

        final String token = authHeader.substring(7);
        String username;

        try {
            username = jwtUtil.extractUsername(token);
        } catch (Exception e) {
            System.out.println("❌ Failed to extract username: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 🔥 Important: block bad token
            response.getWriter().write("Invalid JWT token");
            return;
        }

        // Check if user is not already authenticated
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtUtil.isTokenValid(token, userDetails.getUsername())) {
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
                System.out.println("✅ Authentication successful: " + username);
            } else {
                System.out.println("❌ Invalid JWT token");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 🔥 Reject request on invalid token
                response.getWriter().write("Invalid or expired JWT");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}


