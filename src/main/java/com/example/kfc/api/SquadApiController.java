package com.example.kfc.api;

import com.example.kfc.Request.SquadRequest;
import com.example.kfc.Request.SquadSearchRequest;
import com.example.kfc.Response.PlayerPageResponse;
import com.example.kfc.Response.SquadResponse;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.service.FormationService;
import com.example.kfc.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
public class SquadApiController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private FormationService formationService;

    @PostMapping("/api/squadsearch")
    public PlayerPageResponse getSquadPage(@RequestBody SquadSearchRequest request){
        try {
            int page = request.getPage();
            String country = request.getCountry();
            String league = request.getLeague();
            String club = request.getClub();
            String pos = request.getPos();
            String name = request.getName();

            if (name != null && !name.trim().isEmpty()) {
                name = "%" + name.trim() + "%";
            } else {
                name = "";
            }

            Sort sort = Sort.by("ovr").descending(); // 기본값
            Pageable sortedPageable = PageRequest.of(
                    page,
                    30,
                    sort);
            Page<PlayerDto> p = playerService.searchPlayers(country, league, club, pos, name, 30L, sortedPageable);
            return new PlayerPageResponse(
                    p.getContent(),
                    p.getNumber(),
                    p.getSize(),
                    p.getTotalPages(),
                    p.getTotalElements());
        }
        catch (Exception e) {
            log.info(e.toString());
            return null;
        }
    }

    @PostMapping("/api/savesquad")
    public boolean saveSquad(@RequestBody SquadRequest request){
        try {
            String name = request.getName();
            Long p1 = request.getP1();
            Long p2 = request.getP2();
            Long p3 = request.getP3();
            Long p4 = request.getP4();
            Long p5 = request.getP5();
            Long p6 = request.getP6();
            Long p7 = request.getP7();
            Long p8 = request.getP8();
            Long p9 = request.getP9();
            Long p10 = request.getP10();
            Long p11 = request.getP11();

            int res = formationService.updateFormation(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
            return res != 0;
        }
        catch (Exception e){
            log.info(e.toString());
            return false;
        }
    }

    @PostMapping("/api/loadsquad")
    public SquadResponse loadSquad(@RequestBody SquadRequest request) {
        try {
            String name = request.getName();
            var lst = formationService.loadFormation(name);

            lst.forEach(n -> log.info(n.toString()));

            List<PlayerDto> playerDtoList = new ArrayList<>();

            for (Long n : lst) {
                if (n == 0L) {
                    playerDtoList.add(new PlayerDto());
                    continue;
                }
                var p = playerService.searchPlayerById(n);
                playerDtoList.add(PlayerDto.from(p));
            }

            return new SquadResponse(name, playerDtoList);
        }
        catch (Exception e){
            log.info(e.toString());
            return new SquadResponse("", null);
        }
    }
}
