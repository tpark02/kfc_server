package com.example.kfc.repository;

import com.example.kfc.entity.Formation;
import com.example.kfc.entity.MyClub;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Formation f SET f.p1 = :p1, f.p2 = :p2, f.p3 = :p3, f.p4 = :p4, f.p5 = :p5, " +
            "f.p6 = :p6, f.p7 = :p7, f.p8 = :p8, f.p9 = :p9, f.p10 = :p10, f.p11 = :p11 " +
            "WHERE f.name = :name")
    int updateFormationByName(@Param("name") String name,
                              @Param("p1") Long p1,
                              @Param("p2") Long p2,
                              @Param("p3") Long p3,
                              @Param("p4") Long p4,
                              @Param("p5") Long p5,
                              @Param("p6") Long p6,
                              @Param("p7") Long p7,
                              @Param("p8") Long p8,
                              @Param("p9") Long p9,
                              @Param("p10") Long p10,
                              @Param("p11") Long p11);

    @Query("SELECT p FROM Formation p WHERE "
            + "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%')))")
    Formation searchFormationByName(@Param("name") String name);

    List<Formation> findByClub(MyClub club);
}

