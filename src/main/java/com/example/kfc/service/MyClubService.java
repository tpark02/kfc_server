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
    private final FormationRepository formationRepository;
    private final MyPlayerRepository myPlayerRepository;
    private final PlayerRepository playerRepository;
    private final MyPlayerService myPlayerService;
    private final PlayerService playerService;
    private final RandomTeamService randomTeamService;
    private final TeamLogoRepository teamLogoRepository;

    // ai club
    private final AiClubService aiClubService;
    private final AiFormationService aiFormationService;
    private final LockManager<Long> clubLockManager = new LockManager<>();

    //    public MyClub saveClub(MyClub club) {
//        return myClubRepository.save(club);
//    }
    public MyClub getClubByUserIdAndClubId(Long userId, Long clubId) {
        System.out.println(
                "getClubByUserIdAndClubId - " +
                        "user id : " + userId + ", club id : " + clubId);
        return myClubRepository.findByClubIdAndUserId(clubId, userId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found"));
    }

    public List<MyClub> getClubsByUser(UserInfo user) {
        return myClubRepository.findByUser(user);
    }

    public Optional<MyClub> resetClub(Long userId, Long clubId) {
        // 클럽별 락 가져오기
        clubLockManager.lock(clubId);
        try {
            MyClub existing = myClubRepository.findByClubIdAndUserId(clubId, userId)
                    .orElseThrow(() -> new IllegalArgumentException("Club not found"));

            // 클럽 정보 초기화
            existing.setName(null);
            existing.setOvr(0L);
            existing.setAtk(0L);
            existing.setDef(0L);
            existing.setCch(0L);
            existing.setPace(0L);
            existing.setPrice(0L);
            existing.setAge(0L);
            existing.setStm(0L);

            // 포메이션 초기화
            Optional<Formation> formationOpt = formationRepository.findByClub(existing);
            if (formationOpt.isPresent()) {
                Formation formation = formationOpt.get();
                formation.setName("442");
                for (int i = 1; i <= 17; i++) {
                    Method setter = Formation.class.getMethod("setP" + i, Long.class);
                    setter.invoke(formation, (Long) null);
                }
                formationRepository.save(formation);
            }

            // 선수 초기화
            List<MyPlayer> players = myPlayerRepository.findByUserIdAndClubId(userId, clubId);
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
            MyClub existing = myClubRepository.findByClubIdAndUserId(clubId, userId)
                    .orElseThrow(() -> new IllegalArgumentException("Club not found"));

            var lst = request.getPlayers().stream().filter(p -> p != null).toList();
            if (lst.size() != RandomTeamService.numberOfTotalPlayers) {
                throw new IllegalArgumentException(
                        String.format("Exactly %d players must be provided", RandomTeamService.numberOfTotalPlayers)
                );
            }

            // 클러 정보 업데이트
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

            // 포메이션 조회 또는 생성
            Formation formation = formationRepository.findByClub(existing).orElseGet(Formation::new);
            if (formation.getId() == null) {
                formation.setClub(existing);
            }
            formation.setName(request.getFormationName());

            List<MyPlayerDto> myPlayerDtoLst = request.getPlayers();
            myPlayerDtoLst.sort(Comparator.comparingLong(MyPlayerDto::getIdx));
            List<MyPlayer> existingPlayers = myPlayerRepository.findByUserIdAndClubId(userId, clubId);

            if (existingPlayers.size() != RandomTeamService.numberOfTotalPlayers) {
                throw new IllegalArgumentException(
                        String.format("❌ Expected %d players, found %d", RandomTeamService.numberOfTotalPlayers,
                                      existingPlayers.size())
                );
            }

            for (int i = 0; i < RandomTeamService.numberOfTotalPlayers; i++) {
                MyPlayerDto updated = myPlayerDtoLst.get(i);
                Long playerId = updated.getPlayerId();

                try {
                    Method setter = Formation.class.getMethod("setP" + (i + 1), Long.class);
                    setter.invoke(formation, playerId);
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
            }

            myPlayerRepository.saveAll(existingPlayers);
            formationRepository.save(formation);
            myClubRepository.save(existing);

            return Optional.of(existing);
        } catch (Exception e) {
            log.info("update my club error - {}", e.getMessage());
            return Optional.empty();
        } finally {
            clubLockManager.unlock(clubId);
        }
    }

//    TODO: perhaps used later for creating login. because a user must have 3 clubs
//    public void createMyClub(Long userId, MyClubRequest request) {
//        UserInfo user = userInfoRepository.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//
//        if (request.getPlayers().size() != 26) {
//            throw new IllegalArgumentException("Exactly 26 players must be provided");
//        }
//
//        // Save the club first so it gets an ID
//        List<MyClub> myClubs = myClubRepository.findByUser(user);
//
//        if (myClubs.size() >= 3) {
//            throw new IllegalArgumentException("You cannot create more than 3 clubs");
//        }
//
//        MyClub club = new MyClub();
//        club.setName(request.getClubName());
//        club.setUser(user);
//        club.setOvr(request.getOvr());
//        club.setAtk(request.getAttack());
//        club.setDef(request.getDefense());
//        club.setCch(request.getClubCohesion());
//        club.setPace(request.getPace());
//        club.setPrice(request.getPrice());
//        club.setAge(request.getAge());
//        club.setStm(request.getStamina());
//
//        System.out.println("Saving club: id=" + club.getClubId() + ", name=" + club.getName());
//
//        var targetClub = myClubRepository.save(club);
//
//        // 🔍 Check if a formation already exists for this club
//        Formation formation = formationRepository.findByClub(targetClub)
//                .orElseGet(Formation::new); // new Formation() if not found
//
//        // ⚙️ If it's new, set the club and name
//        if (formation.getId() == null) {
//            formation.setClub(club);
//            formation.setName(request.getFormationName());
//        }
//
//        // Create the formation
//        formation.setName(request.getFormationName());
//        formation.setClub(targetClub); // FK
//        List<Long> players = request.getPlayers();
//        formation.setP1(players.get(0));
//        formation.setP2(players.get(1));
//        formation.setP3(players.get(2));
//        formation.setP4(players.get(3));
//        formation.setP5(players.get(4));
//        formation.setP6(players.get(5));
//        formation.setP7(players.get(6));
//        formation.setP8(players.get(7));
//        formation.setP9(players.get(8));
//        formation.setP10(players.get(9));
//        formation.setP11(players.get(10));
//        formation.setP12(players.get(11));
//        formation.setP13(players.get(12));
//        formation.setP14(players.get(13));
//        formation.setP15(players.get(14));
//        formation.setP16(players.get(15));
//        formation.setP17(players.get(16));
//        formation.setP18(players.get(17));
//        formation.setP19(players.get(18));
//        formation.setP20(players.get(19));
//        formation.setP21(players.get(20));
//        formation.setP22(players.get(21));
//        formation.setP23(players.get(22));
//        formation.setP24(players.get(23));
//        formation.setP25(players.get(24));
//        formation.setP26(players.get(25));
//
//        formationRepository.save(formation);
//    }
}
