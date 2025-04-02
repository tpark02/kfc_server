package com.example.kfc.service;

import com.example.kfc.entity.Player;
import com.example.kfc.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service // 서비스 객체 선언

public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> index() {
        return playerRepository.findAll();
    }
}
