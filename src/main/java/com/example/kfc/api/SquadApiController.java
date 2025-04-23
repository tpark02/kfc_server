package com.example.kfc.api;

import com.example.kfc.Request.SquadRequest;
import com.example.kfc.Request.SquadSearchRequest;
import com.example.kfc.Response.SquadResponse;
import com.example.kfc.dto.PlayerDto;
import com.example.kfc.service.FormationService;
import com.example.kfc.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@Slf4j
@RestController
public class SquadApiController {
    @Autowired
    private PlayerService playerService;

    @Autowired
    private FormationService formationService;

    @PostMapping("/api/squad")
    public Map<String, List<PlayerDto>> getSquadPage(@RequestBody SquadSearchRequest request){
        try {
            String teamName = request.getTeamName();
            var lst = playerService.searchSquad(teamName);
            // Group players by position
            Map<String, List<PlayerDto>> memberByPos = new HashMap<>();
            for (PlayerDto member : lst) {
                memberByPos
                        .computeIfAbsent(member.getPos(), k -> new ArrayList<>())
                        .add(member);
            }

            // Sort each group by OVR (assuming getOvr() exists)
            for (List<PlayerDto> group : memberByPos.values()) {
                group.sort(Comparator.comparingLong(PlayerDto::getOvr).reversed()); // Highest OVR first
            }
            return memberByPos;
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
