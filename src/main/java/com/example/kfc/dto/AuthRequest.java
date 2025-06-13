package com.example.kfc.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor // ✅ 반드시 추가
public class AuthRequest {
    private String username;
    private String password;
    private String email;
}
