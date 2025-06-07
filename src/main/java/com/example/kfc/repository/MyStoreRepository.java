package com.example.kfc.repository;

import com.example.kfc.entity.MyStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MyStoreRepository extends JpaRepository<MyStore, Long> {

    Optional<MyStore> findByUserIdAndPlayerId(Long userId, Long playerId);

//    @Query("SELECT MIN(s.id), MAX(s.id) FROM MyStore s WHERE s.userId = :userId")
//    Optional<Object[]> findIdRangeByUserId(@Param("userId") Long userId);

    @Modifying
    @Query("""
    UPDATE MyStore s SET 
        s.playerId = :playerId,
        s.clubId = :clubId,
        s.yellowCard = :yellowCard,
        s.redCard = :redCard,
        s.seq_cnt = :seqCnt,
        s.idx = :idx,
        s.rank = :rank,
        s.name = :name,
        s.ovr = :ovr,
        s.pac = :pac,
        s.sho = :sho,
        s.pas = :pas,
        s.dri = :dri,
        s.def = :def,
        s.phy = :phy,
        s.acceleration = :acceleration,
        s.sprintSpeed = :sprintSpeed,
        s.positioning = :positioning,
        s.finishing = :finishing,
        s.shotPower = :shotPower,
        s.longShots = :longShots,
        s.volleys = :volleys,
        s.penalties = :penalties,
        s.vision = :vision,
        s.crossing = :crossing,
        s.freeKickAccuracy = :freeKickAccuracy,
        s.shortPassing = :shortPassing,
        s.longPassing = :longPassing,
        s.curve = :curve,
        s.dribbling = :dribbling,
        s.agility = :agility,
        s.balance = :balance,
        s.reactions = :reactions,
        s.ballControl = :ballControl,
        s.composure = :composure,
        s.interceptions = :interceptions,
        s.headingAccuracy = :headingAccuracy,
        s.defAwareness = :defAwareness,
        s.standingTackle = :standingTackle,
        s.slidingTackle = :slidingTackle,
        s.jumping = :jumping,
        s.stamina = :stamina,
        s.strength = :strength,
        s.aggression = :aggression,
        s.pos = :pos,
        s.weakFoot = :weakFoot,
        s.skillMoves = :skillMoves,
        s.preferredFoot = :preferredFoot,
        s.height = :height,
        s.weight = :weight,
        s.alternativePositions = :alternativePositions,
        s.age = :age,
        s.nation = :nation,
        s.league = :league,
        s.team = :team,
        s.playStyle = :playStyle,
        s.url = :url,
        s.img = :img,
        s.gkDiving = :gkDiving,
        s.gkHandling = :gkHandling,
        s.gkKicking = :gkKicking,
        s.gkPositioning = :gkPositioning,
        s.gkReflexes = :gkReflexes
    WHERE s.id = :id AND s.userId = :userId
""")
    int updateMyStoreByIdAndUserId(
            @Param("id") Long id,
            @Param("userId") Long userId,
            @Param("playerId") Long playerId,
            @Param("clubId") Long clubId,
            @Param("yellowCard") Long yellowCard,
            @Param("redCard") Long redCard,
            @Param("seqCnt") Long seqCnt,
            @Param("idx") Long idx,
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
            @Param("gkReflexes") Long gkReflexes
                                  );


    @Query("SELECT s FROM MyStore s WHERE s.userId = :userId")
    List<MyStore> getMyStoreData(@Param("userId") Long userId);
}
