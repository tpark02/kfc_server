package com.example.kfc.service;

import com.example.kfc.entity.MyFormation;
import com.example.kfc.entity.MyClub;
import com.example.kfc.repository.MyClubRepository;
import com.example.kfc.repository.MyFormationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class MyFormationService {

    @Autowired
    MyFormationRepository myFormationRepository;
    private final MyClubRepository myClubRepository;

    public MyFormation createEmptyFormation(Long userId, String formationName) {
        MyClub club = myClubRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("❌ Club not found: " + userId));

        MyFormation formation = new MyFormation();
        formation.setName(formationName);
        formation.setClub(club);

        initializeAllPlayerFields(formation); // ✅ Initialize

        return myFormationRepository.save(formation);
    }

    public void initializeAllPlayerFields(MyFormation formation) {
        try {
            for (int i = 1; i <= 27; i++) {
                Field field = MyFormation.class.getDeclaredField("p" + i);
                field.setAccessible(true);
                field.set(formation, 0L); // or null
            }
        } catch (Exception e) {
            throw new RuntimeException("❌ Error while initializing player fields", e);
        }
    }

    public List<Long> loadFormation(String name) {
        var lst = myFormationRepository.searchFormationByName(name);
        List<Long> res = new ArrayList<>(Collections.nCopies(11, 0L));
        res.set(0, lst.getP1() != null ? lst.getP1() : 0L);
        res.set(1, lst.getP2() != null ? lst.getP2() : 0L);
        res.set(2, lst.getP3() != null ? lst.getP3() : 0L);
        res.set(3, lst.getP4() != null ? lst.getP4() : 0L);
        res.set(4, lst.getP5() != null ? lst.getP5() : 0L);
        res.set(5, lst.getP6() != null ? lst.getP6() : 0L);
        res.set(6, lst.getP7() != null ? lst.getP7() : 0L);
        res.set(7, lst.getP8() != null ? lst.getP8() : 0L);
        res.set(8, lst.getP9() != null ? lst.getP9() : 0L);
        res.set(9, lst.getP10() != null ? lst.getP10() : 0L);
        res.set(10, lst.getP11() != null ? lst.getP11() : 0L);
        return res;
    }

    public MyFormation saveFormation(MyFormation myFormation) {
        return myFormationRepository.save(myFormation);
    }

    public Optional<MyFormation> getFormationsByClub(MyClub club) {
        return myFormationRepository.findByClub(club);
    }

    public MyFormation getFormationById(Long formationId) {
        return myFormationRepository.findById(formationId)
                .orElseThrow(() -> new IllegalArgumentException("Formation not found"));
    }

    public void deleteFormation(Long formationId) {
        myFormationRepository.deleteById(formationId);
    }

    public MyFormation updateFormation(Long formationId, MyFormation updated) {
        MyFormation existing = myFormationRepository.findById(formationId)
                .orElseThrow(() -> new IllegalArgumentException("The formation does not exist."));

        existing.setName(updated.getName());
        existing.setP1(updated.getP1());
        existing.setP2(updated.getP2());
        existing.setP3(updated.getP3());
        existing.setP4(updated.getP4());
        existing.setP5(updated.getP5());
        existing.setP6(updated.getP6());
        existing.setP7(updated.getP7());
        existing.setP8(updated.getP8());
        existing.setP9(updated.getP9());
        existing.setP10(updated.getP10());
        existing.setP11(updated.getP11());

        return myFormationRepository.save(existing);
    }
}
