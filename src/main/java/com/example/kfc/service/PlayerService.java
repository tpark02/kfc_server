package com.example.kfc.service;

import com.example.kfc.dto.CountryDto;
import com.example.kfc.dto.LeagueDto;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.dto.TeamDto;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service // 서비스 객체 선언

public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Page<PlayerDto> searchPlayersWithFilter(String search, Long minAge, Long maxAge, Long minRank, Long maxRank, Long minOvr, Long maxOvr, List<String> nation, List<String> team,List<String> league,List<String> position, Pageable pageable) {
        if ((position == null) && (team == null) && (league == null) && (nation == null) && (search == null || search.trim().isEmpty())) {
            return playerRepository.findAll(pageable).map(PlayerDto::from);
        } else {
            return playerRepository.searchPlayersWithFilter(search, minAge, maxAge, minRank, maxRank, minOvr, maxOvr, nation, team, league, position, pageable)
                    .map(PlayerDto::from);
        }
    }

    public Page<PlayerDto> searchPlayers(String country, String league, String club, String pos, String name, Long size, Pageable pageable){
        return playerRepository.searchPlayers(country, league, club, pos, name, pageable).map(PlayerDto::from);
    }

    public List<PlayerDto> searchClub(String teamName){
        if (teamName.isEmpty()) {
            return Collections.emptyList(); // or return List.of();
        }
        return playerRepository.searchClub(teamName).stream().map(PlayerDto::from).toList();
    }

    public Player searchPlayerById(Long id) {
        if (id == 0) return null;
        return playerRepository.searchPlayerById(id);
    }

    public List<Player> search(String query) {
        return new ArrayList<>(playerRepository.findByNameContainingIgnoreCase(query));
    }

    public List<Player> searchPlayersByFilters(List<CountryDto> countries, List<LeagueDto> leagues, List<TeamDto> clubs) {
        List<String> lowerNation = countries.stream()
                .map(c -> c.getName().toLowerCase())
                .toList();

        List<String> lowerTeam = clubs.stream()
                .map(c -> c.getName().toLowerCase())
                .toList();

        List<String> lowerLeague = leagues.stream()
                .map(l -> l.getName().toLowerCase())
                .toList();

        return playerRepository.searchPlayersByFilters(lowerNation.isEmpty() ? null : lowerNation, lowerTeam.isEmpty() ? null : lowerTeam, lowerLeague.isEmpty() ? null : lowerLeague);
    }
}
