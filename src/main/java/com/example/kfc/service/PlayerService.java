package com.example.kfc.service;

import com.example.kfc.dto.PlayerForm;
import com.example.kfc.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service // 서비스 객체 선언

public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Page<PlayerForm> searchPlayers(String search, Long minAge, Long maxAge, Long minRank, Long maxRank, Long minOvr, Long maxOvr, Pageable pageable) {
        if (search == null || search.trim().isEmpty()) {
            return playerRepository.findAll(pageable).map(PlayerForm::from);
        } else {
            return playerRepository.searchPlayersWithFilter(search, minAge, maxAge, minRank, maxRank, minOvr, maxOvr, pageable)
                    .map(PlayerForm::from);
        }
    }
}
