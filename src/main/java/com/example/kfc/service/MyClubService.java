package com.example.kfc.service;

import com.example.kfc.Request.MyClubRequest;
import com.example.kfc.entity.*;
import com.example.kfc.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyClubService {

    private final MyClubRepository myClubRepository;
    private final UserInfoRepository userInfoRepository;
    private final FormationRepository formationRepository;
    private final MyPlayerRepository myPlayerRepository;
    private final PlayerRepository playerRepository;
    private final MyPlayerService myPlayerService;

//    public MyClub saveClub(MyClub club) {
//        return myClubRepository.save(club);
//    }

    public MyClub getClubByUserIdAndUserId(Long userId, Long clubId) {
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
            formation.setP18(null);
            formation.setP19(null);
            formation.setP20(null);
            formation.setP21(null);
            formation.setP22(null);
            formation.setP23(null);
            formation.setP24(null);
            formation.setP25(null);
            formation.setP26(null);
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
        if (lst.size() != 26) throw new IllegalArgumentException("Exactly 26 players must be provided");
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

        List<Long> playerIds = request.getPlayers();
        List<MyPlayer> existingPlayers = myPlayerRepository.findByUserIdAndClubId(userId, clubId);

        // ✅ 26명이 아니면 중단
        if (existingPlayers.size() != 26) {
            System.out.println("❌ Cannot update. Expected 26 players, found " + existingPlayers.size());
            return Optional.of(existing); // 혹은 Optional.empty() 반환
        }

        // 🔁 26명 순서대로 덮어쓰기
        for (int i = 0; i < 26; i++) {
            Long playerId = playerIds.get(i);

            // 포메이션 P1 ~ P26 설정
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
            myPlayerService.updateMyPlayer(source, target); // 👈 여기가 핵심 UPDATE
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
