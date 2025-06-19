package com.example.kfc.repository;

import com.example.kfc.entity.MyPlayer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MyPlayerRepository extends JpaRepository<MyPlayer, Long> {
    @Modifying
    @Transactional
    @Query("""
    UPDATE MyPlayer p SET
        p.playerId = :playerId,
        p.clubId = :clubId,
        p.yellowCard = :yellowCard,
        p.redCard = :redCard,
        p.seq_cnt = :seqCnt,
        p.idx = :idx,
        p.rank = :rank,
        p.name = :name,
        p.ovr = :ovr,
        p.pac = :pac,
        p.sho = :sho,
        p.pas = :pas,
        p.dri = :dri,
        p.def = :def,
        p.phy = :phy,
        p.acceleration = :acceleration,
        p.sprintSpeed = :sprintSpeed,
        p.positioning = :positioning,
        p.finishing = :finishing,
        p.shotPower = :shotPower,
        p.longShots = :longShots,
        p.volleys = :volleys,
        p.penalties = :penalties,
        p.vision = :vision,
        p.crossing = :crossing,
        p.freeKickAccuracy = :freeKickAccuracy,
        p.shortPassing = :shortPassing,
        p.longPassing = :longPassing,
        p.curve = :curve,
        p.dribbling = :dribbling,
        p.agility = :agility,
        p.balance = :balance,
        p.reactions = :reactions,
        p.ballControl = :ballControl,
        p.composure = :composure,
        p.interceptions = :interceptions,
        p.headingAccuracy = :headingAccuracy,
        p.defAwareness = :defAwareness,
        p.standingTackle = :standingTackle,
        p.slidingTackle = :slidingTackle,
        p.jumping = :jumping,
        p.stamina = :stamina,
        p.strength = :strength,
        p.aggression = :aggression,
        p.pos = :pos,
        p.weakFoot = :weakFoot,
        p.skillMoves = :skillMoves,
        p.preferredFoot = :preferredFoot,
        p.height = :height,
        p.weight = :weight,
        p.alternativePositions = :alternativePositions,
        p.age = :age,
        p.nation = :nation,
        p.league = :league,
        p.team = :team,
        p.playStyle = :playStyle,
        p.url = :url,
        p.img = :img,
        p.gkDiving = :gkDiving,
        p.gkHandling = :gkHandling,
        p.gkKicking = :gkKicking,
        p.gkPositioning = :gkPositioning,
        p.gkReflexes = :gkReflexes,
        p.teamId = :teamId,
        p.leagueId = :leagueId,
        p.leagueUrl = :leagueUrl,
        p.teamUrl = :teamUrl
    WHERE p.userId = :userId AND p.idx = :idx
""")
    int updatePlayer(
            @Param("userId") Long userId,
            @Param("idx") Long idx,
            @Param("playerId") Long playerId,
            @Param("clubId") Long clubId,
            @Param("yellowCard") Long yellowCard,
            @Param("redCard") Long redCard,
            @Param("seqCnt") Long seqCnt,
            @Param("rank") Long rank,
            @Param("name") String name,
            @Param("ovr") Long ovr,
            @Param("pac") Long pac,
            @Param("sho") Long sho,
            @Param("pas") Long pas,
            @Param("dri") Long dri,
            @Param("def") Long def,
            @Param("phy") Long phy,
            @Param("acceleration") Long acceleration,
            @Param("sprintSpeed") Long sprintSpeed,
            @Param("positioning") Long positioning,
            @Param("finishing") Long finishing,
            @Param("shotPower") Long shotPower,
            @Param("longShots") Long longShots,
            @Param("volleys") Long volleys,
            @Param("penalties") Long penalties,
            @Param("vision") Long vision,
            @Param("crossing") Long crossing,
            @Param("freeKickAccuracy") Long freeKickAccuracy,
            @Param("shortPassing") Long shortPassing,
            @Param("longPassing") Long longPassing,
            @Param("curve") Long curve,
            @Param("dribbling") Long dribbling,
            @Param("agility") Long agility,
            @Param("balance") Long balance,
            @Param("reactions") Long reactions,
            @Param("ballControl") Long ballControl,
            @Param("composure") Long composure,
            @Param("interceptions") Long interceptions,
            @Param("headingAccuracy") Long headingAccuracy,
            @Param("defAwareness") Long defAwareness,
            @Param("standingTackle") Long standingTackle,
            @Param("slidingTackle") Long slidingTackle,
            @Param("jumping") Long jumping,
            @Param("stamina") Long stamina,
            @Param("strength") Long strength,
            @Param("aggression") Long aggression,
            @Param("pos") String pos,
            @Param("weakFoot") Long weakFoot,
            @Param("skillMoves") Long skillMoves,
            @Param("preferredFoot") String preferredFoot,
            @Param("height") String height,
            @Param("weight") String weight,
            @Param("alternativePositions") String alternativePositions,
            @Param("age") Long age,
            @Param("nation") String nation,
            @Param("league") String league,
            @Param("team") String team,
            @Param("playStyle") String playStyle,
            @Param("url") String url,
            @Param("img") String img,
            @Param("gkDiving") Long gkDiving,
            @Param("gkHandling") Long gkHandling,
            @Param("gkKicking") Long gkKicking,
            @Param("gkPositioning") Long gkPositioning,
            @Param("gkReflexes") Long gkReflexes,
            @Param("teamId") Long teamId,
            @Param("leagueId") Long leagueId,
            @Param("leagueUrl") String leagueUrl,
            @Param("teamUrl") String teamUrl
                    );


    @Query("SELECT m FROM MyPlayer m WHERE m.userId = :userId AND m.playerId = :playerId")
    List<MyPlayer> findAllMatchingPlayerId(@Param("userId") Long userId,
                                           @Param("playerId") Long playerId);
    List<MyPlayer> findByUserIdAndClubId(Long userId, Long clubId);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.yellowCard = :yellowCard " +
            "WHERE p.userId = :userId AND p.clubId = :clubId AND p.playerId = :playerId")
    int updateYellowCard(@Param("userId") Long userId,
                         @Param("playerId") Long playerId,
                         @Param("yellowCard") Long yellowCard);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.redCard = :redCard, p.seq_cnt = :seq_cnt  " +
            "WHERE p.userId = :userId AND p.clubId = :clubId AND p.playerId = :playerId")
    int updateRedCard(@Param("userId") Long userId,
                      @Param("playerId") Long playerId,
                      @Param("redCard") Long redCard,
                      @Param("seq_cnt") Long seq_cnt);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.yellowCard = 0 WHERE p.userId = :userId")
    int resetYellowCard(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.redCard = 0 WHERE p.userId = :userId")
    int resetRedCard(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query("UPDATE MyPlayer p SET p.seq_cnt = 0 WHERE p.userId = :userId")
    int resetSeqCnt(@Param("userId") Long userId);

    @Query("SELECT SUM(p.yellowCard) FROM MyPlayer p WHERE p.userId = :userId")
    Long countYellowCards(@Param("userId") Long userId);

    @Query("SELECT SUM(p.redCard) FROM MyPlayer p WHERE p.userId = :userId")
    Long countRedCards(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query("UPDATE MyPlayer p SET p.idx = :idx WHERE p.userId = :userId AND p.playerId = :playerId")
    int updateIdxByUserIdAndClubIdAndPlayerId(Long idx, Long userId, Long playerId);
}
