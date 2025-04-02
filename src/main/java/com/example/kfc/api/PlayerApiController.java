package com.example.kfc.api;

import com.example.kfc.entity.Player;
import com.example.kfc.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
public class PlayerApiController {
    @Autowired
    private PlayerService playerService;

    // GET
    @GetMapping("/api/players")
    public List<Player> index() {
        return playerService.index();
    }
}
