package com.example.kfc.repository;

import com.example.kfc.entity.AiFormation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AiFormationRepository extends JpaRepository<AiFormation, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE AiFormation a SET " +
            "a.p1 = :p1, a.p2 = :p2, a.p3 = :p3, a.p4 = :p4, a.p5 = :p5, " +
            "a.p6 = :p6, a.p7 = :p7, a.p8 = :p8, a.p9 = :p9, a.p10 = :p10, " +
            "a.p11 = :p11, a.p12 = :p12, a.p13 = :p13, a.p14 = :p14, a.p15 = :p15, " +
            "a.p16 = :p16, a.p17 = :p17, a.p18 = :p18, a.p19 = :p19, a.p20 = :p20, " +
            "a.p21 = :p21, a.p22 = :p22, a.p23 = :p23, a.p24 = :p24, a.p25 = :p25, a.p26 = :p26 " +
            "WHERE a.name = :name and a.club.id = :clubId")
    int updateAiFormation(@Param("clubId") Long clubId, @Param("name") String name,
                              @Param("p1") Integer p1, @Param("p2") Integer p2, @Param("p3") Integer p3,
                              @Param("p4") Integer p4, @Param("p5") Integer p5, @Param("p6") Integer p6,
                              @Param("p7") Integer p7, @Param("p8") Integer p8, @Param("p9") Integer p9,
                              @Param("p10") Integer p10, @Param("p11") Integer p11, @Param("p12") Integer p12,
                              @Param("p13") Integer p13, @Param("p14") Integer p14, @Param("p15") Integer p15,
                              @Param("p16") Integer p16, @Param("p17") Integer p17, @Param("p18") Integer p18,
                              @Param("p19") Integer p19, @Param("p20") Integer p20, @Param("p21") Integer p21,
                              @Param("p22") Integer p22, @Param("p23") Integer p23, @Param("p24") Integer p24,
                              @Param("p25") Integer p25, @Param("p26") Integer p26);

}
