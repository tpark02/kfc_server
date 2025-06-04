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
                               @Param("ovr") Long ovr,
                               @Param("price") Long price,
                               @Param("age") Long age,
                               @Param("pace") Long pace,
                               @Param("def") Long def,
                               @Param("atk") Long atk,
                               @Param("cch") Long cch,
                               @Param("stm") Long stm);

}
