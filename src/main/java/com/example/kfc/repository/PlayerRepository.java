package com.example.kfc.repository;

import com.example.kfc.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT p FROM Player p WHERE " +
            "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "p.age >= :minAge AND p.age <= :maxAge AND " +
            "p.rank >= :minRank AND p.rank <= :maxRank AND " +
            "p.ovr >= :minOvr AND p.ovr <= :maxOvr AND " +
            "(:nation IS NULL OR p.nation IN :nation)")
    Page<Player> searchPlayersWithFilter(@Param("name") String name,
                                         @Param("minAge") Long minAge,
                                         @Param("maxAge") Long maxAge,
                                         @Param("minRank") Long minRank,
                                         @Param("maxRank") Long maxRank,
                                         @Param("minOvr") Long minOvr,
                                         @Param("maxOvr") Long maxOvr,
                                         @Param("nation") List<String> nation,
                                         Pageable pageable);
}
