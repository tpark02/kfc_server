package com.example.kfc.service;

import com.example.kfc.Request.MyClubRequest;
import com.example.kfc.dto.MyPlayerDto;
import com.example.kfc.entity.*;
import com.example.kfc.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyClubService {
    private final Map<Long, ReentrantLock> clubLocks = new ConcurrentHashMap<>();

    private final MyClubRepository myClubRepository;
    private final UserInfoRepository userInfoRepository;
    private final FormationRepository formationRepository;
    private final MyPlayerRepository myPlayerRepository;
    private final PlayerRepository playerRepository;
    private final MyPlayerService myPlayerService;
    private final PlayerService playerService;
    private final RandomTeamService randomTeamService;

    // ai club
    private final AiClubService aiClubService;
    private final AiFormationService aiFormationService;
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
        ReentrantLock lock = clubLocks.computeIfAbsent(clubId, k -> new ReentrantLock());

        lock.lock(); // 락 획득
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
            lock.unlock(); // 락 해제
        }
    }

    public Optional<MyClub> updateMyClub(Long userId, Long clubId, MyClubRequest request) {
        // 클럽별 락 가져오기 또는 생성
        ReentrantLock lock = clubLocks.computeIfAbsent(clubId, id -> new ReentrantLock());

        lock.lock(); // 🔒 락 획득
        try {
            MyClub existing = myClubRepository.findByClubIdAndUserId(clubId, userId)
                    .orElseThrow(() -> new IllegalArgumentException("Club not found"));

            var lst = request.getPlayers().stream().filter(p -> p != null).toList();
            if (lst.size() != RandomTeamService.numberOfTotalPlayers) {
                throw new IllegalArgumentException(
                        String.format("Exactly %d players must be provided", RandomTeamService.numberOfTotalPlayers)
                );
            }

            // 클럽 정보 업데이트
            existing.setName(request.getClubName());
            existing.setOvr(request.getOvr());
            existing.setAtk(request.getAttack());
            existing.setDef(request.getDefense());
            existing.setCch(request.getClubCohesion());
            existing.setPace(request.getPace());
            existing.setPrice(request.getPrice());
            existing.setAge(request.getAge());
            existing.setStm(request.getStamina());

            // 포메이션 조회 또는 생성
            Formation formation = formationRepository.findByClub(existing)
                    .orElseGet(Formation::new);
            if (formation.getId() == null) {
                formation.setClub(existing);
            }
            formation.setName(request.getFormationName());

            List<MyPlayerDto> myPlayerDtoLst = request.getPlayers();
            myPlayerDtoLst.sort(Comparator.comparingLong(MyPlayerDto::getIdx));
            List<MyPlayer> existingPlayers = myPlayerRepository.findByUserIdAndClubId(userId, clubId);

            if (existingPlayers.size() != RandomTeamService.numberOfTotalPlayers) {
                throw new IllegalArgumentException(
                        String.format("❌ Expected %d players, found %d", RandomTeamService.numberOfTotalPlayers, existingPlayers.size())
                );
            }

            for (int i = 0; i < RandomTeamService.numberOfTotalPlayers; i++) {
                Long playerId = myPlayerDtoLst.get(i).getPlayerId();

                boolean isMyPlayerExist = existingPlayers.stream()
                        .anyMatch(p -> p.getPlayerId().equals(playerId));

                if (isMyPlayerExist) {
                    MyPlayerDto updated = myPlayerDtoLst.stream()
                            .filter(p -> p.getPlayerId().equals(playerId))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("❌ Player not found: " + playerId));

                    MyPlayer existingPlayer = existingPlayers.stream()
                            .filter(p -> p.getPlayerId().equals(playerId))
                            .findFirst()
                            .orElseThrow(() -> new IllegalArgumentException("❌ Player not found: " + playerId));

                    existingPlayer.setClubId(updated.getClubId());
                    existingPlayer.setName(updated.getName());
                    existingPlayer.setOvr(updated.getOvr());
                    existingPlayer.setPos(updated.getPos());
                    existingPlayer.setNation(updated.getNation());
                    existingPlayer.setLeague(updated.getLeague());
                    existingPlayer.setTeam(updated.getTeam());
                    existingPlayer.setImg(updated.getImg());
                    existingPlayer.setIdx(updated.getIdx());
                    existingPlayer.setYellowCard(updated.getYellowCard());
                    existingPlayer.setRedCard(updated.getRedCard());
                    existingPlayer.setRank(updated.getRank());
                    existingPlayer.setSeq_cnt(0L);

                    // 능력치 및 상세 스탯 업데이트
                    existingPlayer.setPac(updated.getPac());
                    existingPlayer.setSho(updated.getSho());
                    existingPlayer.setPas(updated.getPas());
                    existingPlayer.setDri(updated.getDri());
                    existingPlayer.setDef(updated.getDef());
                    existingPlayer.setPhy(updated.getPhy());
                    existingPlayer.setAcceleration(updated.getAcceleration());
                    existingPlayer.setSprintSpeed(updated.getSprintSpeed());
                    existingPlayer.setPositioning(updated.getPositioning());
                    existingPlayer.setFinishing(updated.getFinishing());
                    existingPlayer.setShotPower(updated.getShotPower());
                    existingPlayer.setLongShots(updated.getLongShots());
                    existingPlayer.setVolleys(updated.getVolleys());
                    existingPlayer.setPenalties(updated.getPenalties());
                    existingPlayer.setVision(updated.getVision());
                    existingPlayer.setCrossing(updated.getCrossing());
                    existingPlayer.setShortPassing(updated.getShortPassing());
                    existingPlayer.setLongPassing(updated.getLongPassing());
                    existingPlayer.setCurve(updated.getCurve());
                    existingPlayer.setDribbling(updated.getDribbling());
                    existingPlayer.setAgility(updated.getAgility());
                    existingPlayer.setBalance(updated.getBalance());
                    existingPlayer.setReactions(updated.getReactions());
                    existingPlayer.setBallControl(updated.getBallControl());
                    existingPlayer.setComposure(updated.getComposure());
                    existingPlayer.setInterceptions(updated.getInterceptions());
                    existingPlayer.setHeadingAccuracy(updated.getHeadingAccuracy());
                    existingPlayer.setDefAwareness(updated.getDefAwareness());
                    existingPlayer.setStandingTackle(updated.getStandingTackle());
                    existingPlayer.setSlidingTackle(updated.getSlidingTackle());
                    existingPlayer.setJumping(updated.getJumping());
                    existingPlayer.setStamina(updated.getStamina());
                    existingPlayer.setStrength(updated.getStrength());
                    existingPlayer.setAggression(updated.getAggression());
                    existingPlayer.setWeakFoot(updated.getWeakFoot());
                    existingPlayer.setSkillMoves(updated.getSkillMoves());
                    existingPlayer.setPreferredFoot(updated.getPreferredFoot());
                    existingPlayer.setHeight(updated.getHeight());
                    existingPlayer.setWeight(updated.getWeight());
                    existingPlayer.setAlternativePositions(updated.getAlternativePositions());
                    existingPlayer.setAge(updated.getAge());
                    existingPlayer.setPlayStyle(updated.getPlayStyle());
                    existingPlayer.setUrl(updated.getUrl());
                    existingPlayer.setGkDiving(updated.getGkDiving());
                    existingPlayer.setGkHandling(updated.getGkHandling());
                    existingPlayer.setGkKicking(updated.getGkKicking());
                    existingPlayer.setGkPositioning(updated.getGkPositioning());
                    existingPlayer.setGkReflexes(updated.getGkReflexes());

                } else {
                    // 신규 플레이어인 경우 포메이션에 배치
                    try {
                        Method setter = Formation.class.getMethod("setP" + (i + 1), Long.class);
                        setter.invoke(formation, playerId);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to set formation P" + (i + 1), e);
                    }

                    Player source = playerRepository.searchPlayerById(playerId)
                            .orElseThrow(() -> new IllegalArgumentException("Player not found: " + playerId));
                    MyPlayer target = existingPlayers.get(i);
                    target.setIdx((long) i);
                    myPlayerService.updateNewPlayer(source, target);
                }
            }

            return Optional.of(existing);
        } finally {
            lock.unlock(); // 🔓 락 해제
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
