package com.example.kfc.service;

import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.MyPlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyPlayerService {
    @Autowired
    private MyPlayerRepository myPlayerRepository;

//    public MyPlayer getMyPlayer(Long id, Long clubId) {
//        return myPlayerRepository.findByIdAndClubId(id, clubId)
//                .orElseThrow(() -> new RuntimeException("Player not found"));
//    }

    @Transactional
    public void addMyPlayer(Player player, Long userId, Long clubId)
    {
        MyPlayer myPlayer = MyPlayer.from(player, userId, clubId);
        myPlayerRepository.save(myPlayer);
    }

    @Transactional
    public Optional<List<Long>> addNewClub(Long userId, Long clubId) {
        List<MyPlayer> players = myPlayerRepository.findByUserIdAndClubId(userId, clubId).orElse(null);

        if (players == null)
            throw new IllegalArgumentException("No players found for clubId: " + clubId);

        List<Long> res = new ArrayList<>();
        for (MyPlayer player : players) {
            player.resetStats();
            res.add(player.getId());
        }

        myPlayerRepository.saveAll(players);
        return Optional.of(res);
    }

    @Transactional
    public void updateMyPlayer(Player player, Long clubId, Long row) {
        MyPlayer myPlayer = myPlayerRepository.findById(row)
                .orElseThrow(() -> new IllegalArgumentException("MyPlayer not found for id: " + row));

        myPlayer.setPlayerId(player.getId());
        //myPlayer.setClubId(clubId);
        myPlayer.setName(player.getName());
        myPlayer.setOvr(player.getOvr());
        myPlayer.setPos(player.getPos());
        myPlayer.setNation(player.getNation());
        myPlayer.setLeague(player.getLeague());
        myPlayer.setTeam(player.getTeam());
        myPlayer.setImg(player.getImg());

        myPlayer.setYellowCard(0L);
        myPlayer.setRedCard(0L);
        myPlayer.setRank(0L); // optional default

        myPlayer.setPac(player.getPac());
        myPlayer.setSho(player.getSho());
        myPlayer.setPas(player.getPas());
        myPlayer.setDri(player.getDri());
        myPlayer.setDef(player.getDef());
        myPlayer.setPhy(player.getPhy());

        myPlayer.setAcceleration(player.getAcceleration());
        myPlayer.setSprintSpeed(player.getSprintSpeed());
        myPlayer.setPositioning(player.getPositioning());
        myPlayer.setFinishing(player.getFinishing());
        myPlayer.setShotPower(player.getShotPower());
        myPlayer.setLongShots(player.getLongShots());
        myPlayer.setVolleys(player.getVolleys());
        myPlayer.setPenalties(player.getPenalties());
        myPlayer.setVision(player.getVision());
        myPlayer.setCrossing(player.getCrossing());
        myPlayer.setShortPassing(player.getShortPassing());
        myPlayer.setLongPassing(player.getLongPassing());
        myPlayer.setCurve(player.getCurve());
        myPlayer.setDribbling(player.getDribbling());
        myPlayer.setAgility(player.getAgility());
        myPlayer.setBalance(player.getBalance());
        myPlayer.setReactions(player.getReactions());
        myPlayer.setBallControl(player.getBallControl());
        myPlayer.setComposure(player.getComposure());

        myPlayer.setInterceptions(player.getInterceptions());
        myPlayer.setHeadingAccuracy(player.getHeadingAccuracy());
        myPlayer.setDefAwareness(player.getDefAwareness());
        myPlayer.setStandingTackle(player.getStandingTackle());
        myPlayer.setSlidingTackle(player.getSlidingTackle());

        myPlayer.setJumping(player.getJumping());
        myPlayer.setStamina(player.getStamina());
        myPlayer.setStrength(player.getStrength());
        myPlayer.setAggression(player.getAggression());

        myPlayer.setWeakFoot(player.getWeakFoot());
        myPlayer.setSkillMoves(player.getSkillMoves());
        myPlayer.setPreferredFoot(player.getPreferredFoot());
        myPlayer.setHeight(player.getHeight());
        myPlayer.setWeight(player.getWeight());
        myPlayer.setAlternativePositions(player.getAlternativePositions());
        myPlayer.setAge(player.getAge());
        myPlayer.setPlayStyle(player.getPlayStyle());
        myPlayer.setUrl(player.getUrl());

        myPlayer.setGkDiving(player.getGkDiving());
        myPlayer.setGkHandling(player.getGkHandling());
        myPlayer.setGkKicking(player.getGkKicking());
        myPlayer.setGkPositioning(player.getGkPositioning());
        myPlayer.setGkReflexes(player.getGkReflexes());

        myPlayerRepository.save(myPlayer);
    }
}
