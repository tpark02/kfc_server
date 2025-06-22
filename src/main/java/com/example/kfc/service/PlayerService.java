package com.example.kfc.service;

import com.example.kfc.dto.CountryDto;
import com.example.kfc.dto.LeagueDto;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.dto.TeamDto;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final JdbcTemplate jdbcTemplate;

    public void multiplyOvrByTen() {
        String sql = """
        UPDATE player
        SET ovr = ovr * 10
        WHERE ovr IS NOT NULL;
        """;
        int updated = jdbcTemplate.update(sql);
        System.out.println("✅ Multiplied ovr by 10 for " + updated + " players");
    }

    public void syncPriceWithOvr() {
        String sql = """
        UPDATE player
        SET price = (ovr / 100) * 10
        WHERE ovr IS NOT NULL;
        """;
        int updated = jdbcTemplate.update(sql);
        System.out.println("✅ Synced " + updated + " player prices with ovr");
    }

    public Player searchPlayerById(Long playerId) {
        return playerRepository.searchPlayerById(playerId).orElse(null);
    }

    public Page<PlayerDto> searchPlayersWithFilter(String search, Long minAge, Long maxAge, Long minRank, Long maxRank,
                                                   Long minOvr, Long maxOvr, List<String> nation, List<String> team,
                                                   List<String> league, List<String> position, Pageable pageable) {
        if ((position == null) && (team == null) && (league == null) && (nation == null) && (search == null || search.trim()
                .isEmpty())) {
            return playerRepository.findAll(pageable).map(PlayerDto::from);
        } else {
            return playerRepository.searchPlayersWithFilter(search, minAge, maxAge, minRank, maxRank, minOvr, maxOvr,
                                                            nation, team, league, position, pageable)
                    .map(PlayerDto::from);
        }
    }

    public Page<PlayerDto> searchPlayers(String country, String league, String club, String pos, String name, Long size,
                                         Pageable pageable) {
        return playerRepository.searchPlayers(country, league, club, pos, name, pageable).map(PlayerDto::from);
    }

    public List<Player> search(String query) {
        return new ArrayList<>(playerRepository.findByNameContainingIgnoreCase(query));
    }

    public List<Player> searchPlayersByFilters(List<CountryDto> countries, List<LeagueDto> leagues,
                                               List<TeamDto> clubs) {
        List<String> lowerNation = countries.stream()
                .map(c -> c.getName().toLowerCase())
                .toList();

        List<String> lowerTeam = clubs.stream()
                .map(c -> c.getName().toLowerCase())
                .toList();

        List<String> lowerLeague = leagues.stream()
                .map(l -> l.getName().toLowerCase())
                .toList();

        return playerRepository.searchPlayersByFilters(lowerNation.isEmpty() ? null : lowerNation,
                                                       lowerTeam.isEmpty() ? null : lowerTeam,
                                                       lowerLeague.isEmpty() ? null : lowerLeague);
    }

    public List<Player> searchPlayersByOvr(Long ovr) {
        return playerRepository.findByOvrLessThanEqual(ovr);
    }

    public Player findMaxId() {
        return playerRepository.findPlayerWithMaxId();
    }
}
