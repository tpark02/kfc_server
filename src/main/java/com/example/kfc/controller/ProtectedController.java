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
        response.put("message", "🔐 This data is only accessible to authenticated users.");
        return ResponseEntity.ok(response);
    }
}
