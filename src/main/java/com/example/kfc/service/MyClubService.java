package com.example.kfc.service;

import com.example.kfc.Request.MyClubRequest;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.entity.*;
import com.example.kfc.manager.LockManager;
import com.example.kfc.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyClubService {

    private final MyClubRepository myClubRepository;
    private final UserInfoRepository userInfoRepository;
    private final MyFormationRepository myFormationRepository;
    private final MyPlayerRepository myPlayerRepository;
    private final TeamLogoRepository teamLogoRepository;

    // ai club
    private final LockManager<Long> clubLockManager = new LockManager<>();

    public MyClub createClubForUser(Long userId, String clubName) {
        UserInfo user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("❌ user id not exist: " + userId));

        MyClub club = new MyClub();
        club.setName(clubName);
        club.setUser(user);
        club.setClubId(1L);

        club.setOvr(0L);
        club.setAge(0L);
        club.setPrice(0L);
        club.setAtk(0L);
        club.setDef(0L);
        club.setCch(0L);
        club.setPace(0L);
        club.setStm(0L);
        club.setNation("");

        return myClubRepository.save(club);
    }

    public MyClub getClubByUserId(Long userId) {
        System.out.println(
                "getClubByUserId - " +
                        "user id : " + userId);
        return myClubRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found"));
    }

    public List<MyClub> getClubsByUser(UserInfo user) {
        return myClubRepository.findByUser(user);
    }

    public Optional<MyClub> resetClub(Long userId, Long clubId) {
        clubLockManager.lock(clubId);
        try {
            MyClub existing = myClubRepository.findByUserId(userId)
                    .orElseThrow(() -> new IllegalArgumentException("Club not found"));

            existing.setName(null);
            existing.setOvr(0L);
            existing.setAtk(0L);
            existing.setDef(0L);
            existing.setCch(0L);
            existing.setPace(0L);
            existing.setPrice(0L);
            existing.setAge(0L);
            existing.setStm(0L);

            Optional<MyFormation> formationOpt = myFormationRepository.findByClub(existing);
            if (formationOpt.isPresent()) {
                MyFormation myFormation = formationOpt.get();
                myFormation.setName("442");
                for (int i = 1; i <= 17; i++) {
                    Method setter = MyFormation.class.getMethod("setP" + i, Long.class);
                    setter.invoke(myFormation, (Long) null);
                }
                myFormationRepository.save(myFormation);
            }

            List<MyPlayer> players = myPlayerRepository.findByUserId(userId);
            if (players.isEmpty()) {
                throw new IllegalArgumentException("No players found for clubId: " + clubId);
            }

            for (MyPlayer player : players)
                player.resetStats();

            IntStream.range(0, players.size()).forEach(i -> players.get(i).setIdx((long) i));
            myPlayerRepository.saveAll(players);

            return Optional.of(myClubRepository.save(existing));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            clubLockManager.unlock(clubId);
        }
    }

    @Transactional
    public Optional<MyClub> updateMyClub(Long userId, Long clubId, MyClubRequest request) {
        clubLockManager.lock(clubId);
        try {
            MyClub existing = myClubRepository.findByUserId(userId)
                    .orElseThrow(() -> new IllegalArgumentException("Club not found"));

            var lst = request.getPlayers().stream().filter(p -> p != null).toList();
            if (lst.size() != RandomTeamService.totalPlayersCount) {
                throw new IllegalArgumentException(
                        String.format("Exactly %d players must be provided", RandomTeamService.totalPlayersCount)
                );
            }

            existing.setName(request.getClubName());
            existing.setOvr(request.getOvr());
            existing.setAtk(request.getAttack());
            existing.setDef(request.getDefense());
            existing.setCch(request.getClubCohesion());
            existing.setPace(request.getPace());
            existing.setPrice(request.getPrice());
            existing.setAge(request.getAge());
            existing.setStm(request.getStamina());
            existing.setNation(request.getMyNation());

            TeamLogo teamLogo = teamLogoRepository.findById(request.getMyLogoId())
                    .orElseThrow(() -> new IllegalArgumentException("Logo not found - " + request.getMyLogoId()));
            existing.setTeamLogo(teamLogo);

            MyFormation myFormation = myFormationRepository.findByClub(existing).orElseGet(MyFormation::new);
            if (myFormation.getId() == null) {
                myFormation.setClub(existing);
            }
            myFormation.setName(request.getFormationName());

            List<MyPlayerDto> myPlayerDtoLst = request.getPlayers();
            myPlayerDtoLst.sort(Comparator.comparingLong(MyPlayerDto::getIdx));
            List<MyPlayer> existingPlayers = myPlayerRepository.findByUserId(userId);

            if (existingPlayers.size() != RandomTeamService.totalPlayersCount) {
                throw new IllegalArgumentException(
                        String.format("❌ Expected %d players, found %d", RandomTeamService.totalPlayersCount,
                                      existingPlayers.size())
                );
            }

            for (int i = 0; i < RandomTeamService.totalPlayersCount; i++) {
                MyPlayerDto updated = myPlayerDtoLst.get(i);
                Long playerId = updated.getPlayerId();

                try {
                    Method setter = MyFormation.class.getMethod("setP" + (i + 1), Long.class);
                    setter.invoke(myFormation, playerId);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to set formation P" + (i + 1), e);
                }

                MyPlayer target = existingPlayers.get(i);
                target.setPos(updated.getPos());
                target.setUserId(userId);
                target.setPlayerId(updated.getPlayerId());
                target.setClubId(updated.getClubId());
                target.setIdx(updated.getIdx());
                target.setYellowCard(updated.getYellowCard());
                target.setRedCard(updated.getRedCard());
                target.setRank(updated.getRank());
                target.setSeq_cnt(0L);
                target.setName(updated.getName());
                target.setOvr(updated.getOvr());
                target.setPac(updated.getPac());
                target.setSho(updated.getSho());
                target.setPas(updated.getPas());
                target.setDri(updated.getDri());
                target.setDef(updated.getDef());
                target.setPhy(updated.getPhy());
                target.setAcceleration(updated.getAcceleration());
                target.setSprintSpeed(updated.getSprintSpeed());
                target.setPositioning(updated.getPositioning());
                target.setFinishing(updated.getFinishing());
                target.setShotPower(updated.getShotPower());
                target.setLongShots(updated.getLongShots());
                target.setVolleys(updated.getVolleys());
                target.setPenalties(updated.getPenalties());
                target.setVision(updated.getVision());
                target.setCrossing(updated.getCrossing());
                target.setFreeKickAccuracy(updated.getFreeKickAccuracy());
                target.setShortPassing(updated.getShortPassing());
                target.setLongPassing(updated.getLongPassing());
                target.setCurve(updated.getCurve());
                target.setDribbling(updated.getDribbling());
                target.setAgility(updated.getAgility());
                target.setBalance(updated.getBalance());
                target.setReactions(updated.getReactions());
                target.setBallControl(updated.getBallControl());
                target.setComposure(updated.getComposure());
                target.setInterceptions(updated.getInterceptions());
                target.setHeadingAccuracy(updated.getHeadingAccuracy());
                target.setDefAwareness(updated.getDefAwareness());
                target.setStandingTackle(updated.getStandingTackle());
                target.setSlidingTackle(updated.getSlidingTackle());
                target.setJumping(updated.getJumping());
                target.setStamina(updated.getStamina());
                target.setStrength(updated.getStrength());
                target.setAggression(updated.getAggression());
                target.setWeakFoot(updated.getWeakFoot());
                target.setSkillMoves(updated.getSkillMoves());
                target.setPreferredFoot(updated.getPreferredFoot());
                target.setHeight(updated.getHeight());
                target.setWeight(updated.getWeight());
                target.setAlternativePositions(updated.getAlternativePositions());
                target.setAge(updated.getAge());
                target.setNation(updated.getNation());
                target.setLeague(updated.getLeague());
                target.setTeam(updated.getTeam());
                target.setPlayStyle(updated.getPlayStyle());
                target.setUrl(updated.getUrl());
                target.setImg(updated.getImg());
                target.setGkDiving(updated.getGkDiving());
                target.setGkHandling(updated.getGkHandling());
                target.setGkKicking(updated.getGkKicking());
                target.setGkPositioning(updated.getGkPositioning());
                target.setGkReflexes(updated.getGkReflexes());
                target.setTeamId(updated.getTeamId());
                target.setLeagueId(updated.getLeagueId());
                target.setLeagueUrl(updated.getLeagueUrl());
                target.setTeamUrl(updated.getTeamUrl());
            }

            myPlayerRepository.saveAll(existingPlayers);
            myFormationRepository.save(myFormation);
            myClubRepository.save(existing);

            return Optional.of(existing);
        } catch (Exception e) {
            log.info("update my club error - {}", e.getMessage());
            return Optional.empty();
        } finally {
            clubLockManager.unlock(clubId);
        }
    }
}
