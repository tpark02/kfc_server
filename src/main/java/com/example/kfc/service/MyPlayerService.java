package com.example.kfc.service;

import com.example.kfc.entity.MyPlayer;
import com.example.kfc.entity.Player;
import com.example.kfc.repository.MyPlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyPlayerService {

    private final MyPlayerRepository myPlayerRepository;

    public List<MyPlayer> getMyPlayersByPlayerId(Long userId, Long clubId, Long playerId) {
        return myPlayerRepository.findAllMatchingPlayerId(userId, clubId, playerId);
    }

    public List<MyPlayer> getMyPlayers(Long userId, Long clubId) {
        return myPlayerRepository.findByUserIdAndClubId(userId, clubId);
    }

    public void createEmptyPlayers(Long userId, Long clubId) {
        List<MyPlayer> players = new ArrayList<>();

        for (long i = 1; i <= 27; i++) {
            MyPlayer player = new MyPlayer();
            player.setUserId(userId);
            player.setClubId(clubId);
            player.setIdx(i); // idx를 1~27로 지정

            player.resetStats(); // 모든 stat 초기화

            players.add(player);
        }

        myPlayerRepository.saveAll(players); // 일괄 저장
    }

//    @Transactional
//    public void addMyPlayer(Player player, Long userId, Long clubId) {
//        MyPlayer myPlayer = MyPlayer.from(player, userId, clubId);
//        myPlayerRepository.save(myPlayer);
//    }

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
    public void setYellowCard(Long userId, Long clubId, Long playerId, Long cnt) {
        int updated = myPlayerRepository.updateYellowCard(userId, clubId, playerId, cnt);
        if (updated == 0) {
            throw new IllegalStateException("❌ Failed to update yellow card: no matching player found.");
        }
    }

    @Transactional
    public void setRedCard(Long userId, Long clubId, Long playerId, Long cnt, Long seq_cnt) {
        int updated = myPlayerRepository.updateRedCard(userId, clubId, playerId, cnt, seq_cnt);
        if (updated == 0) {
            throw new IllegalStateException(
                    "❌ Failed to update red card: no matching player found. - playerId : " + playerId);
        }
    }

    /**
     * Reset yellow cards for a user's club players
     */
    @Transactional
    public void resetYellowCards(Long userId, Long clubId) {
        int updated = myPlayerRepository.resetYellowCard(userId, clubId);
        if (updated == 0) {
            throw new IllegalStateException(
                    "❌ Failed to reset yellow cards: No matching players found for the given user and club.");
        }
    }

    /**
     * Reset red cards for a user's club players
     */
    @Transactional
    public void resetRedCards(Long userId, Long clubId) {
        int updated = myPlayerRepository.resetRedCard(userId, clubId);
        if (updated == 0) {
            throw new IllegalStateException(
                    "❌ Failed to reset red cards: No matching players found for the given user and club.");
        }
    }

    /**
     * Reset sequence count for a user's club players
     */
    @Transactional
    public void resetSeqCnt(Long userId, Long clubId) {
        int updated = myPlayerRepository.resetSeqCnt(userId, clubId);
        if (updated == 0) {
            throw new IllegalStateException(
                    "❌ Failed to reset seq_cnt: No matching players found for the given user and club.");
        }
    }

    @Transactional
    void updateExistingPlayer(MyPlayer myPlayer) {
        myPlayerRepository.save(myPlayer);
    }

    @Transactional
    public boolean  updateNewPlayer(Player source, MyPlayer myPlayer) {
        try {
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
            return true;
        } catch (Exception e) {
            e.printStackTrace(); // ❗로깅 권장
            return false;
        }
    }

    public Long getYellowCardCount(Long userId, Long clubId) {
        Long count = myPlayerRepository.countYellowCards(userId, clubId);
        return count != null ? count : 0L;
    }

    public Long getRedCardCount(Long userId, Long clubId) {
        Long count = myPlayerRepository.countRedCards(userId, clubId);
        return count != null ? count : 0L;
    }

    public void updateIdxForClub(Long userId, Long clubId, Map<Long, Long> rosterMap) {
        try {
            rosterMap.forEach((playerId, idx) -> {
                System.out.println(String.format("🔁 Updating idx for userId=%d, clubId=%d, playerId=%d, idx=%d",
                                                 userId, clubId, playerId, idx));
                myPlayerRepository.updateIdxByUserIdAndClubIdAndPlayerId(idx, userId, clubId, playerId);
            });
        } catch (Exception e) {
            log.error("❌ Failed to update idx for userId={}, clubId={}, error={}", userId, clubId, e.getMessage(), e);
            throw new RuntimeException("Failed to update player idx", e);
        }
    }
}
