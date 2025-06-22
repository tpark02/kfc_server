package com.example.kfc.controller;

import com.example.kfc.Request.PlayerSearchRequest;
import com.example.kfc.Response.PlayerPageResponse;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.filter.CountryFilter;
import com.example.kfc.filter.LeagueFilter;
import com.example.kfc.filter.PlayerPositionFilter;
import com.example.kfc.filter.TeamFilter;
import com.example.kfc.service.MyClubService;
import com.example.kfc.service.MyPlayerService;
import com.example.kfc.service.PlayerService;
import com.example.kfc.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
@RequestMapping("/api")
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private MyClubService myClubService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MyPlayerService myPlayerService;

    private List<CountryFilter> countryFilter = new ArrayList<>();
    private List<TeamFilter> teamFilter = new ArrayList<>();
    private List<LeagueFilter> leagueFilters = new ArrayList<>();
    private List<PlayerPositionFilter> posFilter = new ArrayList<>();

    @Bean
    public PageableHandlerMethodArgumentResolverCustomizer customize() {
        return p -> {
            p.setOneIndexedParameters(false);    // 1 페이지 부터 시작
            p.setMaxPageSize(100);       // 한 페이지에 10개씩 출력
        };
    }


    @PostMapping("/players")
    public PlayerPageResponse getPlayerPage(@RequestBody PlayerSearchRequest request) {
        try {
            int page = request.getPage();
            int size = request.getSize() > 0 ? request.getSize() : 100;
            String search = request.getSearch();
            String sortType = request.getSortType();
            //filters = request.getFilters();
            countryFilter = request.getCountryFilter();
            teamFilter = request.getTeamFilter();
            leagueFilters = request.getLeagueFilter();
            posFilter = request.getPlayerPositionFilter();

            Sort sort = Sort.by("ovr").descending(); // 기본값

            if ("AGE_ASC".equals(sortType)) {
                sort = Sort.by("age").ascending();
            } else if ("AGE_DESC".equals(sortType)) {
                sort = Sort.by("age").descending();
            } else if ("RANK_ASC".equals(sortType)) {
                sort = Sort.by("rank").descending();
            } else if ("RANK_DESC".equals(sortType)) {
                sort = Sort.by("rank").ascending();
            } else if ("OVR_ASC".equals(sortType)) {
                sort = Sort.by("ovr").ascending();
            } else if ("OVR_DESC".equals(sortType)) {
                sort = Sort.by("ovr").descending();
            }

            List<String> nation = countryFilter.stream()
                    .map(CountryFilter::getName)
                    .map(String::toLowerCase)
                    .toList();

            List<String> team = teamFilter.stream()
                    .map(TeamFilter::getName)
                    .map(String::toLowerCase)
                    .toList();

            List<String> league = leagueFilters.stream()
                    .map(LeagueFilter::getName)
                    .map(String::toLowerCase)
                    .toList();

            List<String> position = posFilter.stream()
                    .map(PlayerPositionFilter::getCode)
                    .map(String::toLowerCase)
                    .toList();


            Pageable sortedPageable = PageRequest.of(
                    page,
                    size,
                    sort
                                                    );

            String lowerName = (search == null || search.isBlank()) ? null : search.toLowerCase();

            Page<PlayerDto> p = playerService.searchPlayersWithFilter(search, 0L, 100L, 0L, 999999L, 0L, 1000L,
                                                                      nation.isEmpty() ? null : nation,
                                                                      team.isEmpty() ? null : team,
                                                                      league.isEmpty() ? null : league,
                                                                      position.isEmpty() ? null : position,
                                                                      sortedPageable);

            return new PlayerPageResponse(
                    p.getContent(),
                    p.getNumber(),
                    p.getSize(),
                    p.getTotalPages(),
                    p.getTotalElements()
            );
        } catch (Exception e) {
            log.info("PlayerApiController - /players : " + e.getMessage());
            return null;
        }
    }

    @GetMapping("/users/{userId}/players")
    public List<PlayerDto> getMyClubPlayers(@PathVariable Long userId) {
        try {
            UserInfo user = userInfoService.getUserById(userId);
            List<MyPlayer> myPlayers = myPlayerService.getMyPlayers(userId);
            return myPlayers.stream().map(p -> {
                var player = playerService.searchPlayerById(p.getPlayerId());
                return PlayerDto.from(player);
            }).toList();
        } catch (Exception e) {
            log.info("PlayerApiController - /players/{userId}/{clubId} : " + e.getMessage());
            return null;
        }
    }
}
