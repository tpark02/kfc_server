package com.example.kfc.service;

import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.MyPlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyPlayerService {
    @Autowired
    private MyPlayerRepository myPlayerRepository;

    public List<MyPlayer> getMyPlayer(Long userId, Long clubId) {
        return myPlayerRepository.findByUserIdAndClubId(userId, clubId);
    }

    @Transactional
    public void addMyPlayer(Player player, Long userId, Long clubId)
    {
        MyPlayer myPlayer = MyPlayer.from(player, userId, clubId);
        myPlayerRepository.save(myPlayer);
    }

//    @Transactional
//    public Optional<List<Long>> addNewClub(Long userId, Long clubId) {
//        List<MyPlayer> players =
//                myPlayerRepository.findByUserIdAndClubId(userId, clubId);
//
//        if (!players.isEmpty()) {
//            throw new IllegalArgumentException("Club exists: " + clubId);
//        }
//
//        List<Long> res = new ArrayList<>();
//        myPlayerRepository.saveAll(players);
//        return Optional.of(res);
//    }

    @Transactional
    public void updateMyPlayer(Player source, MyPlayer myPlayer) {
        myPlayer.setPlayerId(source.getId());
        myPlayer.setName(source.getName());
        myPlayer.setOvr(source.getOvr());
        myPlayer.setPos(source.getPos());
        myPlayer.setNation(source.getNation());
        myPlayer.setLeague(source.getLeague());
        myPlayer.setTeam(source.getTeam());
        myPlayer.setImg(source.getImg());

        myPlayer.setYellowCard(0L);
        myPlayer.setRedCard(0L);
        myPlayer.setRank(0L);

        myPlayer.setPac(source.getPac());
        myPlayer.setSho(source.getSho());
        myPlayer.setPas(source.getPas());
        myPlayer.setDri(source.getDri());
        myPlayer.setDef(source.getDef());
        myPlayer.setPhy(source.getPhy());

        myPlayer.setAcceleration(source.getAcceleration());
        myPlayer.setSprintSpeed(source.getSprintSpeed());
        myPlayer.setPositioning(source.getPositioning());
        myPlayer.setFinishing(source.getFinishing());
        myPlayer.setShotPower(source.getShotPower());
        myPlayer.setLongShots(source.getLongShots());
        myPlayer.setVolleys(source.getVolleys());
        myPlayer.setPenalties(source.getPenalties());
        myPlayer.setVision(source.getVision());
        myPlayer.setCrossing(source.getCrossing());
        myPlayer.setShortPassing(source.getShortPassing());
        myPlayer.setLongPassing(source.getLongPassing());
        myPlayer.setCurve(source.getCurve());
        myPlayer.setDribbling(source.getDribbling());
        myPlayer.setAgility(source.getAgility());
        myPlayer.setBalance(source.getBalance());
        myPlayer.setReactions(source.getReactions());
        myPlayer.setBallControl(source.getBallControl());
        myPlayer.setComposure(source.getComposure());

        myPlayer.setInterceptions(source.getInterceptions());
        myPlayer.setHeadingAccuracy(source.getHeadingAccuracy());
        myPlayer.setDefAwareness(source.getDefAwareness());
        myPlayer.setStandingTackle(source.getStandingTackle());
        myPlayer.setSlidingTackle(source.getSlidingTackle());

        myPlayer.setJumping(source.getJumping());
        myPlayer.setStamina(source.getStamina());
        myPlayer.setStrength(source.getStrength());
        myPlayer.setAggression(source.getAggression());

        myPlayer.setWeakFoot(source.getWeakFoot());
        myPlayer.setSkillMoves(source.getSkillMoves());
        myPlayer.setPreferredFoot(source.getPreferredFoot());
        myPlayer.setHeight(source.getHeight());
        myPlayer.setWeight(source.getWeight());
        myPlayer.setAlternativePositions(source.getAlternativePositions());
        myPlayer.setAge(source.getAge());
        myPlayer.setPlayStyle(source.getPlayStyle());
        myPlayer.setUrl(source.getUrl());

        myPlayer.setGkDiving(source.getGkDiving());
        myPlayer.setGkHandling(source.getGkHandling());
        myPlayer.setGkKicking(source.getGkKicking());
        myPlayer.setGkPositioning(source.getGkPositioning());
        myPlayer.setGkReflexes(source.getGkReflexes());

        myPlayerRepository.save(myPlayer);
    }
}
