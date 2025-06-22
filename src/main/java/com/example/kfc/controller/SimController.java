package com.example.kfc.controller;

import com.example.kfc.Request.SimGenerateRequest;
import com.example.kfc.Request.SimRequest;
import com.example.kfc.Response.SimResultResponse;
import com.example.kfc.dto.MatchDto;
import com.example.kfc.service.SimService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class SimController {
    @Autowired
    private final SimService simService;

    @PostMapping("/simulations/schedule")
    public List<MatchDto> generateRandomSchedule(@RequestBody SimGenerateRequest request) {
        return simService.generateRandomSchedule(request.getUserId(), request.getClubId());
    }
}
