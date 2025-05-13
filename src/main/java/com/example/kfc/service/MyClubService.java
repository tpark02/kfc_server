package com.example.kfc.service;

import com.example.kfc.Request.MyClubRequest;
import com.example.kfc.entity.Formation;
import com.example.kfc.entity.MyClub;
import com.example.kfc.entity.UserInfo;
import com.example.kfc.repository.FormationRepository;
import com.example.kfc.repository.MyClubRepository;
import com.example.kfc.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyClubService {

    private final MyClubRepository myClubRepository;
    private final UserInfoRepository userInfoRepository;
    private final FormationRepository formationRepository;

//    public MyClub saveClub(MyClub club) {
//        return myClubRepository.save(club);
//    }

    public List<MyClub> getClubsByUser(UserInfo user) {
        return myClubRepository.findByUser(user);
    }

    public MyClub getClubById(Long clubId) {
        return myClubRepository.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("Club not found"));
    }

    public void deleteClub(Long clubId) {
        myClubRepository.deleteById(clubId);
    }
    public MyClub updateClub(Long clubId, MyClub request) {
        MyClub existing = getClubById(clubId);
        existing.setName(request.getName());
        return myClubRepository.save(existing);
    }

    public void saveMyClub(Long userId, MyClubRequest request) {
        UserInfo user = userInfoRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (request.getPlayers().size() != 26) {
            throw new IllegalArgumentException("Exactly 26 players must be provided");
        }

        // Save the club first so it gets an ID
        List<MyClub> myClubs = myClubRepository.findByUser(user);

        if (myClubs.size() >= 3) {
            throw new IllegalArgumentException("You cannot create more than 3 clubs");
        }

        MyClub club = new MyClub();
        club.setName(request.getClubName());
        club.setUser(user);
        club.setOvr(request.getOvr());
        club.setAtk(request.getAttack());
        club.setDef(request.getDefense());
        club.setCch(request.getClubCohesion());
        club.setPace(request.getPace());
        club.setPrice(request.getPrice());
        club.setAge(request.getAge());
        club.setStm(request.getStamina());

        System.out.println("Saving club: id=" + club.getClubId() + ", name=" + club.getName());

        var targetClub = myClubRepository.save(club);

        // 🔍 Check if a formation already exists for this club
        Formation formation = formationRepository.findByClub(targetClub).orElseGet(Formation::new); // new Formation() if not found

        // ⚙️ If it's new, set the club and name
        if (formation.getId() == null) {
            formation.setClub(club);
            formation.setName(request.getFormationName());
        }

        // Create the formation
        formation.setName(request.getFormationName());
        formation.setClub(targetClub); // FK
        List<Long> players = request.getPlayers();
        formation.setP1(players.get(0));
        formation.setP2(players.get(1));
        formation.setP3(players.get(2));
        formation.setP4(players.get(3));
        formation.setP5(players.get(4));
        formation.setP6(players.get(5));
        formation.setP7(players.get(6));
        formation.setP8(players.get(7));
        formation.setP9(players.get(8));
        formation.setP10(players.get(9));
        formation.setP11(players.get(10));
        formation.setP12(players.get(11));
        formation.setP13(players.get(12));
        formation.setP14(players.get(13));
        formation.setP15(players.get(14));
        formation.setP16(players.get(15));
        formation.setP17(players.get(16));
        formation.setP18(players.get(17));
        formation.setP19(players.get(18));
        formation.setP20(players.get(19));
        formation.setP21(players.get(20));
        formation.setP22(players.get(21));
        formation.setP23(players.get(22));
        formation.setP24(players.get(23));
        formation.setP25(players.get(24));
        formation.setP26(players.get(25));

        // find the club id
        // if exist then save with the found club id
        // if not found, create new formation
        formationRepository.save(formation);
    }
}
