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
        MyClub existing =
                myClubRepository.findByClubIdAndUserId(clubId, userId)
                        .orElseThrow(() -> new IllegalArgumentException("Club not found"));

        // 클럽 정보 초기화 (ID와 FK 제외)
        existing.setName(null);
        existing.setOvr(0L);
        existing.setAtk(0L);
        existing.setDef(0L);
        existing.setCch(0L);
        existing.setPace(0L);
        existing.setPrice(0L);
        existing.setAge(0L);
        existing.setStm(0L);

        // 기존 formation 가져오기
        Optional<Formation> formationOpt = formationRepository.findByClub(existing);
        if (formationOpt.isPresent()) {
            Formation formation = formationOpt.get();

            // 포메이션 값 전체 초기화
            formation.setName("442"); // 또는 "default"
            formation.setP1(null);
            formation.setP2(null);
            formation.setP3(null);
            formation.setP4(null);
            formation.setP5(null);
            formation.setP6(null);
            formation.setP7(null);
            formation.setP8(null);
            formation.setP9(null);
            formation.setP10(null);
            formation.setP11(null);
            formation.setP12(null);
            formation.setP13(null);
            formation.setP14(null);
            formation.setP15(null);
            formation.setP16(null);
            formation.setP17(null);
//            formation.setP18(null);
//            formation.setP19(null);
//            formation.setP20(null);
//            formation.setP21(null);
//            formation.setP22(null);
//            formation.setP23(null);
//            formation.setP24(null);
//            formation.setP25(null);
//            formation.setP26(null);
            formationRepository.save(formation);
        }

        // reset my players
        List<MyPlayer> players =
                myPlayerRepository.findByUserIdAndClubId(userId, clubId);

        if (players.isEmpty()) {
            throw new IllegalArgumentException("No players found for clubId: " + clubId);
        }
        for (MyPlayer player : players)
            player.resetStats();

        IntStream.range(0, players.size())
                .forEach(i -> players.get(i).setIdx((long) i));

        myPlayerRepository.saveAll(players);

        return Optional.of(myClubRepository.save(existing));
    }

    public Optional<MyClub> updateMyClub(Long userId, Long clubId, MyClubRequest request) {
        MyClub existing = myClubRepository.findByClubIdAndUserId(clubId, userId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found"));

//        if (request.getPlayers().size() != 26) {
//            throw new IllegalArgumentException("Exactly 26 players must be provided");
//        }

        var lst = request.getPlayers().stream().filter(p -> p != null).toList();
        if (lst.size() != RandomTeamService.numberOfTotalPlayers) throw new IllegalArgumentException(
                String.format("Exactly %d players must be provided", RandomTeamService.numberOfTotalPlayers)
        );
        // 📦 클럽 기본 정보 업데이트
        existing.setName(request.getClubName());
        existing.setOvr(request.getOvr());
        existing.setAtk(request.getAttack());
        existing.setDef(request.getDefense());
        existing.setCch(request.getClubCohesion());
        existing.setPace(request.getPace());
        existing.setPrice(request.getPrice());
        existing.setAge(request.getAge());
        existing.setStm(request.getStamina());

        // 🧩 포메이션 조회 또는 생성
        Formation formation = formationRepository.findByClub(existing)
                .orElseGet(Formation::new);

        if (formation.getId() == null) {
            formation.setClub(existing);
        }
        formation.setName(request.getFormationName());

        List<MyPlayerDto> myPlayerDtoLst = request.getPlayers();

        // sort received myplayer list by idx
        myPlayerDtoLst.sort(Comparator.comparingLong(MyPlayerDto::getIdx));

        List<MyPlayer> existingPlayers = myPlayerRepository.findByUserIdAndClubId(userId, clubId);

        // ✅ if not 17, then stop
        if (existingPlayers.size() != RandomTeamService.numberOfTotalPlayers) {
            String str = String.format("❌ Cannot update. Expected %d players, found %d",
                                       RandomTeamService.numberOfTotalPlayers,
                                       existingPlayers.size());
            log.info(str);
            throw new IllegalArgumentException(str);
        }


        // 🔁 over write 17 players sequencially
        for (int i = 0; i < RandomTeamService.numberOfTotalPlayers; i++) {
            Long playerId = myPlayerDtoLst.get(i).getPlayerId();

            boolean isMyPlayerExist = existingPlayers.stream()
                    .anyMatch(p -> p.getPlayerId().equals(playerId));

            // is My Player exist?
            if (isMyPlayerExist) {
                System.out.println("set existing player - " + playerId);
                MyPlayerDto updated = myPlayerDtoLst.stream()
                        .filter(p -> p.getPlayerId().equals(playerId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("❌ Player not found with ID: " + playerId));

                //MyPlayer target = MyPlayer.fromMyPlayerDto(dto);
                //myPlayerService.updateExistingPlayer(target);

                MyPlayer existingPlayer = existingPlayers.stream()
                        .filter(p -> p.getPlayerId().equals(playerId))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("❌ Player not found with ID: " + playerId));


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

                // 능력치
                existingPlayer.setPac(updated.getPac());
                existingPlayer.setSho(updated.getSho());
                existingPlayer.setPas(updated.getPas());
                existingPlayer.setDri(updated.getDri());
                existingPlayer.setDef(updated.getDef());
                existingPlayer.setPhy(updated.getPhy());

                // 세부 능력치
                existingPlayer.setAcceleration(updated.getAcceleration());
                existingPlayer.setSprintSpeed(updated.getSprintSpeed());
                existingPlayer.setPositioning(updated.getPositioning());
                existingPlayer.setFinishing(updated.getFinishing());
                existingPlayer.setShotPower(updated.getShotPower());
                existingPlayer.setLongShots(updated.getLongShots());
                existingPlayer.setVolleys(updated.getVolleys());
                existingPlayer.setPenalties(updated.getPenalties());

                // 패스 등등
                existingPlayer.setVision(updated.getVision());
                existingPlayer.setCrossing(updated.getCrossing());
                existingPlayer.setShortPassing(updated.getShortPassing());
                existingPlayer.setLongPassing(updated.getLongPassing());
                existingPlayer.setCurve(updated.getCurve());

                // 드리블 등등
                existingPlayer.setDribbling(updated.getDribbling());
                existingPlayer.setAgility(updated.getAgility());
                existingPlayer.setBalance(updated.getBalance());
                existingPlayer.setReactions(updated.getReactions());
                existingPlayer.setBallControl(updated.getBallControl());
                existingPlayer.setComposure(updated.getComposure());

                // 수비 능력
                existingPlayer.setInterceptions(updated.getInterceptions());
                existingPlayer.setHeadingAccuracy(updated.getHeadingAccuracy());
                existingPlayer.setDefAwareness(updated.getDefAwareness());
                existingPlayer.setStandingTackle(updated.getStandingTackle());
                existingPlayer.setSlidingTackle(updated.getSlidingTackle());

                // 신체 및 성향
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

                // GK 전용 스탯
                existingPlayer.setGkDiving(updated.getGkDiving());
                existingPlayer.setGkHandling(updated.getGkHandling());
                existingPlayer.setGkKicking(updated.getGkKicking());
                existingPlayer.setGkPositioning(updated.getGkPositioning());
                existingPlayer.setGkReflexes(updated.getGkReflexes());
            } else {
                // set formation from p1 ~ p16
                try {
                    Method setter = Formation.class.getMethod("setP" + (i + 1), Long.class);
                    setter.invoke(formation, playerId);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to set formation P" + (i + 1), e);
                }
                // Player 원본 데이터
                Player source = playerRepository.searchPlayerById(playerId)
                        .orElseThrow(() -> new IllegalArgumentException("Player not found: " + playerId));
                MyPlayer target = existingPlayers.get(i);
                target.setIdx((long) i);
                myPlayerService.updateNewPlayer(source, target); // 👈 여기가 핵심 UPDATE
            }
        }

        formationRepository.save(formation);
        return Optional.of(myClubRepository.save(existing));
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
