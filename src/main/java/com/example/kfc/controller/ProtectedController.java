package com.example.kfc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    @GetMapping("/protected")
    public ResponseEntity<Map<String, String>> getProtectedData() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "🔐 이 데이터는 인증된 사용자만 접근 가능합니다.");
        return ResponseEntity.ok(response);
    }
}
