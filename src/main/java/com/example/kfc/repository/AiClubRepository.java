package com.example.kfc.repository;

import com.example.kfc.entity.AiClub;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AiClubRepository extends JpaRepository<AiClub, Long> {
        @Modifying
        @Transactional
        @Query("UPDATE AiClub c SET c.ovr = :ovr, c.price = :price, c.age = :age, " +
                "c.pace = :pace, c.def = :def, c.atk = :atk, c.cch = :cch, c.stm = :stm " +
                "WHERE c.clubId = :id")
        int updateClubInfoById(@Param("id") Long id,
                               @Param("ovr") int ovr,
                               @Param("price") int price,
                               @Param("age") int age,
                               @Param("pace") int pace,
                               @Param("def") int def,
                               @Param("atk") int atk,
                               @Param("cch") int cch,
                               @Param("stm") int stm);

}
