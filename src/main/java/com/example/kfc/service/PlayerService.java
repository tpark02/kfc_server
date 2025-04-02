package com.example.kfc.service;

import com.example.kfc.dto.PlayerForm;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.PlayerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<PlayerForm> findAllAsForm(Pageable pageable) {
        long total = playerRepository.count();
        log.info("Total Players: {}", total);

        return playerRepository.findAll(pageable)
                .map(player -> new PlayerForm(
                        player.getId(),
                        player.getRank(),
                        player.getName(),
                        player.getOvr(),
                        player.getPac(),
                        player.getSho(),
                        player.getPas(),
                        player.getDri(),
                        player.getDef(),
                        player.getPhy(),
                        player.getAcceleration(),
                        player.getSprintSpeed(),
                        player.getPositioning(),
                        player.getFinishing(),
                        player.getShotPower(),
                        player.getLongShots(),
                        player.getVolleys(),
                        player.getPenalties(),
                        player.getVision(),
                        player.getCrossing(),
                        player.getFreeKickAccuracy(),
                        player.getShortPassing(),
                        player.getLongPassing(),
                        player.getCurve(),
                        player.getDribbling(),
                        player.getAgility(),
                        player.getBalance(),
                        player.getReactions(),
                        player.getBallControl(),
                        player.getComposure(),
                        player.getInterceptions(),
                        player.getHeadingAccuracy(),
                        player.getDefAwareness(),
                        player.getStandingTackle(),
                        player.getSlidingTackle(),
                        player.getJumping(),
                        player.getStamina(),
                        player.getStrength(),
                        player.getAggression(),
                        player.getPos(),
                        player.getWeakFoot(),
                        player.getSkillMoves(),
                        player.getPreferredFoot(),
                        player.getHeight(),
                        player.getWeight(),
                        player.getAlternativePositions(),
                        player.getAge(),
                        player.getNation(),
                        player.getLeague(),
                        player.getTeam(),
                        player.getPlayStyle(),
                        player.getUrl(),
                        player.getImg(),
                        player.getGkDiving(),
                        player.getGkHandling(),
                        player.getGkKicking(),
                        player.getGkPositioning(),
                        player.getGkReflexes()
                ));
    }


    public Page<Player> findByName(int page) {
        PageRequest pageable = PageRequest.of(page, 10, Sort.by("name").descending());
        return playerRepository.findByNameContains("l", pageable);
    }
}
