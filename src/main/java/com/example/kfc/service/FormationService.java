package com.example.kfc.service;

import com.example.kfc.repository.FormationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service // 서비스 객체 선언
public class FormationService {
    @Autowired
    FormationRepository formationRepository;

    public int updateFormation(String name, Long p1, Long p2, Long p3,
                                Long p4,
                                Long p5,
                                Long p6,
                                Long p7,
                                Long p8,
                                Long p9,
                                Long p10,
                                Long p11) {
        return formationRepository.updateFormationByName(name, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
    }

    public List<Long> loadFormation(String name) {
        var lst = formationRepository.searchFormationByName(name);
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
}
