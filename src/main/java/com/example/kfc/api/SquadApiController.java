package com.example.kfc.api;

import com.example.kfc.Request.SquadSearchRequest;
import com.example.kfc.dto.PlayerDto;
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
    @PostMapping("/api/squad")
    public Map<String, List<PlayerDto>> getSquadPage(@RequestBody SquadSearchRequest request){
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


}
