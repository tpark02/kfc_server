package com.example.kfc.service;

import com.example.kfc.dto.PlayerDto;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service // 서비스 객체 선언

public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Page<PlayerDto> searchPlayers(String search, Long minAge, Long maxAge, Long minRank, Long maxRank, Long minOvr, Long maxOvr, List<String> nation, List<String> team,List<String> league,List<String> position, Pageable pageable) {
        if ((position == null) && (team == null) && (league == null) && (nation == null) && (search == null || search.trim().isEmpty())) {
            return playerRepository.findAll(pageable).map(PlayerDto::from);
        } else {
            return playerRepository.searchPlayersWithFilter(search, minAge, maxAge, minRank, maxRank, minOvr, maxOvr, nation, team, league, position, pageable)
                    .map(PlayerDto::from);
        }
    }

    public List<PlayerDto> searchSquad(String teamName){
        if (teamName.isEmpty()) {
            return Collections.emptyList(); // or return List.of();
        }
        return playerRepository.searchSquad(teamName).stream().map(PlayerDto::from).toList();
    }

    public Player searchPlayerById(Long id) {
        if (id == 0) return null;
        return playerRepository.searchPlayerById(id);
    }

    public List<Player> search(String query) {
        return playerRepository.findByNameContainingIgnoreCase(query)
                .stream()
                .collect(Collectors.toList());
    }
}
