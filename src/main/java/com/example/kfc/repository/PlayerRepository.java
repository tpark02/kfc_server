package com.example.kfc.repository;

import com.example.kfc.entity.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("SELECT ROUND(AVG(p.ovr)) FROM Player p WHERE p.teamId  = :teamId")
    Long avgOvrTeam(@Param("teamId") Long teamId);

    @Query("SELECT p FROM Player p WHERE p.id = (SELECT MAX(p2.id) FROM Player p2)")
    Player findPlayerWithMaxId();

    @Query("SELECT p FROM Player p WHERE " +
            "(:nation IS NULL OR LOWER(p.nation) IN :nation) AND " +
            "(:team IS NULL OR LOWER(p.team) IN :team) AND " +
            "(:league IS NULL OR LOWER(p.league) IN :league)")
    List<Player> searchPlayersByFilters(@Param("nation") List<String> nation, @Param("team") List<String> team, @Param("league") List<String> league);

    @Query("SELECT p FROM Player p WHERE " +
            "(:name IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "p.age >= :minAge AND p.age <= :maxAge AND " +
            "p.rank >= :minRank AND p.rank <= :maxRank AND " +
            "p.ovr >= :minOvr AND p.ovr <= :maxOvr AND " +
            "(:nation IS NULL OR LOWER(p.nation) IN :nation) AND " +
            "(:team IS NULL OR LOWER(p.team) IN :team) AND " +
            "(:league IS NULL OR LOWER(p.league) IN :league) AND " +
            "(:pos IS NULL OR LOWER(p.pos) IN :pos)")
    Page<Player> searchPlayersWithFilter(@Param("name") String name,
                                         @Param("minAge") Long minAge,
                                         @Param("maxAge") Long maxAge,
                                         @Param("minRank") Long minRank,
                                         @Param("maxRank") Long maxRank,
                                         @Param("minOvr") Long minOvr,
                                         @Param("maxOvr") Long maxOvr,
                                         @Param("nation") List<String> nation,
                                         @Param("team") List<String> team,
                                         @Param("league") List<String> league,
                                         @Param("pos") List<String> position,
                                         Pageable pageable);

    @Query("SELECT p FROM Player p WHERE " +
            "(:name IS NULL OR :name = '' OR LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
            "(:country IS NULL OR :country = '' OR LOWER(p.nation) = LOWER(:country)) AND " +
            "(:club IS NULL OR :club = '' OR LOWER(p.team) = LOWER(:club)) AND " +
            "(:league IS NULL OR :league = '' OR LOWER(p.league) = LOWER(:league)) AND " +
            "(:pos IS NULL OR :pos = '' OR LOWER(p.pos) = LOWER(:pos))")
    Page<Player> searchPlayers(@Param("country") String country,
                               @Param("league") String league,
                               @Param("club") String club,
                               @Param("pos") String pos,
                               @Param("name") String name,
                               Pageable pageable);


    @Query("SELECT p FROM Player p WHERE p.ID = :Id")
    Optional<Player> searchPlayerById(@Param("Id") Long id);

    @Query("SELECT p FROM Player p WHERE (:teamId IS NULL OR p.teamId = :teamId)")
    List<Player> searchClub(@Param("teamId") Long teamId);

    List<Player> findByNameContainingIgnoreCase(String name);

    List<Player> findByOvrLessThanEqual(Long ovr);
}
