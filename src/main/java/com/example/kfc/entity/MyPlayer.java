package com.example.kfc.entity;

import com.example.kfc.dto.MyPlayerDto;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table(name = "my_player")
public class MyPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 id 자동 생성
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long playerId;

    @Column
    private Long clubId;

    @Column
    private Long yellowCard;

    @Column
    private Long redCard;

    @Column
    private Long seq_cnt;

    @Column
    private Long idx;

    @Column
    private Long rank;

    @Column
    private String name;

    @Column
    private Long ovr;

    @Column
    private Long pac;

    @Column
    private Long sho;

    @Column
    private Long pas;

    @Column
    private Long dri;

    @Column
    private Long def;

    @Column
    private Long phy;

    @Column
    private Long acceleration;

    @Column
    private Long sprintSpeed;

    @Column
    private Long positioning;

    @Column
    private Long finishing;

    @Column
    private Long shotPower;

    @Column
    private Long longShots;

    @Column
    private Long volleys;

    @Column
    private Long penalties;

    @Column
    private Long vision;

    @Column
    private Long crossing;

    @Column
    private Long freeKickAccuracy;

    @Column
    private Long shortPassing;

    @Column
    private Long longPassing;

    @Column
    private Long curve;

    @Column
    private Long dribbling;

    @Column
    private Long agility;

    @Column
    private Long balance;

    @Column
    private Long reactions;

    @Column
    private Long ballControl;

    @Column
    private Long composure;

    @Column
    private Long interceptions;

    @Column
    private Long headingAccuracy;

    @Column
    private Long defAwareness;

    @Column
    private Long standingTackle;

    @Column
    private Long slidingTackle;

    @Column
    private Long jumping;

    @Column
    private Long stamina;

    @Column
    private Long strength;

    @Column
    private Long aggression;

    @Column
    private String pos;

    @Column
    private Long weakFoot;

    @Column
    private Long skillMoves;

    @Column
    private String preferredFoot;

    @Column
    private String height;

    @Column
    private String weight;

    @Column
    private String alternativePositions;

    @Column
    private Long age;

    @Column
    private String nation;

    @Column
    private String league;

    @Column
    private String team;

    @Column
    private String playStyle;

    @Column
    private String url;

    @Column
    private String img;

    @Column
    private Long gkDiving;

    @Column
    private Long gkHandling;

    @Column
    private Long gkKicking;

    @Column
    private Long gkPositioning;

    @Column
    private Long gkReflexes;

    public void resetStats() {
        // IDs
        this.playerId = 0L;

        // Match info
        this.yellowCard = 0L;
        this.redCard = 0L;
        this.rank = 0L;
        this.seq_cnt = 0L;
        this.idx = 0L;
        // Base stats
        this.ovr = 0L;
        this.pac = 0L;
        this.sho = 0L;
        this.pas = 0L;
        this.dri = 0L;
        this.def = 0L;
        this.phy = 0L;

        // Detailed stats
        this.acceleration = 0L;
        this.sprintSpeed = 0L;
        this.positioning = 0L;
        this.finishing = 0L;
        this.shotPower = 0L;
        this.longShots = 0L;
        this.volleys = 0L;
        this.penalties = 0L;
        this.vision = 0L;
        this.crossing = 0L;
        this.freeKickAccuracy = 0L;
        this.shortPassing = 0L;
        this.longPassing = 0L;
        this.curve = 0L;
        this.dribbling = 0L;
        this.agility = 0L;
        this.balance = 0L;
        this.reactions = 0L;
        this.ballControl = 0L;
        this.composure = 0L;

        // Defensive stats
        this.interceptions = 0L;
        this.headingAccuracy = 0L;
        this.defAwareness = 0L;
        this.standingTackle = 0L;
        this.slidingTackle = 0L;
        this.jumping = 0L;
        this.stamina = 0L;
        this.strength = 0L;
        this.aggression = 0L;

        // Goalkeeper stats
        this.gkDiving = 0L;
        this.gkHandling = 0L;
        this.gkKicking = 0L;
        this.gkPositioning = 0L;
        this.gkReflexes = 0L;

        // Optional skill metadata
        this.weakFoot = 0L;
        this.skillMoves = 0L;

        // Positional/meta
        this.name = "";
        this.pos = "";
        this.preferredFoot = "";
        this.height = "";
        this.weight = "";
        this.alternativePositions = "";
        this.nation = "";
        this.league = "";
        this.team = "";
        this.playStyle = "";
        this.url = "";
        this.img = "";

        // Age
        this.age = 0L;
    }

    public static MyPlayer fromMyPlayerDto(MyPlayerDto dto) {
        MyPlayer myPlayer = new MyPlayer();
        myPlayer.setUserId(dto.getUserId());
        myPlayer.setPlayerId(dto.getPlayerId());
        myPlayer.setClubId(dto.getClubId());
        myPlayer.setName(dto.getName());
        myPlayer.setOvr(dto.getOvr());
        myPlayer.setPos(dto.getPos());
        myPlayer.setNation(dto.getNation());
        myPlayer.setLeague(dto.getLeague());
        myPlayer.setTeam(dto.getTeam());
        myPlayer.setImg(dto.getImg());

        myPlayer.setIdx(dto.getIdx());
        myPlayer.setYellowCard(dto.getYellowCard());
        myPlayer.setRedCard(dto.getRedCard());
        myPlayer.setRank(0L); // optional default
        myPlayer.setSeq_cnt(0L);

        myPlayer.setPac(dto.getPac());
        myPlayer.setSho(dto.getSho());
        myPlayer.setPas(dto.getPas());
        myPlayer.setDri(dto.getDri());
        myPlayer.setDef(dto.getDef());
        myPlayer.setPhy(dto.getPhy());

        myPlayer.setAcceleration(dto.getAcceleration());
        myPlayer.setSprintSpeed(dto.getSprintSpeed());
        myPlayer.setPositioning(dto.getPositioning());
        myPlayer.setFinishing(dto.getFinishing());
        myPlayer.setShotPower(dto.getShotPower());
        myPlayer.setLongShots(dto.getLongShots());
        myPlayer.setVolleys(dto.getVolleys());
        myPlayer.setPenalties(dto.getPenalties());
        myPlayer.setVision(dto.getVision());
        myPlayer.setCrossing(dto.getCrossing());
        myPlayer.setShortPassing(dto.getShortPassing());
        myPlayer.setLongPassing(dto.getLongPassing());
        myPlayer.setCurve(dto.getCurve());
        myPlayer.setDribbling(dto.getDribbling());
        myPlayer.setAgility(dto.getAgility());
        myPlayer.setBalance(dto.getBalance());
        myPlayer.setReactions(dto.getReactions());
        myPlayer.setBallControl(dto.getBallControl());
        myPlayer.setComposure(dto.getComposure());

        myPlayer.setInterceptions(dto.getInterceptions());
        myPlayer.setHeadingAccuracy(dto.getHeadingAccuracy());
        myPlayer.setDefAwareness(dto.getDefAwareness());
        myPlayer.setStandingTackle(dto.getStandingTackle());
        myPlayer.setSlidingTackle(dto.getSlidingTackle());

        myPlayer.setJumping(dto.getJumping());
        myPlayer.setStamina(dto.getStamina());
        myPlayer.setStrength(dto.getStrength());
        myPlayer.setAggression(dto.getAggression());

        myPlayer.setWeakFoot(dto.getWeakFoot());
        myPlayer.setSkillMoves(dto.getSkillMoves());
        myPlayer.setPreferredFoot(dto.getPreferredFoot());
        myPlayer.setHeight(dto.getHeight());
        myPlayer.setWeight(dto.getWeight());
        myPlayer.setAlternativePositions(dto.getAlternativePositions());
        myPlayer.setAge(dto.getAge());
        myPlayer.setPlayStyle(dto.getPlayStyle());
        myPlayer.setUrl(dto.getUrl());

        myPlayer.setGkDiving(dto.getGkDiving());
        myPlayer.setGkHandling(dto.getGkHandling());
        myPlayer.setGkKicking(dto.getGkKicking());
        myPlayer.setGkPositioning(dto.getGkPositioning());
        myPlayer.setGkReflexes(dto.getGkReflexes());

        return myPlayer;
    }
//    public static MyPlayer from(dto dto, Long userId, Long clubId) {
//        MyPlayer myPlayer = new MyPlayer();
//        myPlayer.setUserId(userId);
//        myPlayer.setPlayerId(dto.getId());
//        myPlayer.setClubId(clubId);
//        myPlayer.setName(dto.getName());
//        myPlayer.setOvr(dto.getOvr());
//        myPlayer.setPos(dto.getPos());
//        myPlayer.setNation(dto.getNation());
//        myPlayer.setLeague(dto.getLeague());
//        myPlayer.setTeam(dto.getTeam());
//        myPlayer.setImg(dto.getImg());
//
//        myPlayer.setYellowCard(0L);
//        myPlayer.setRedCard(0L);
//        myPlayer.setRank(0L); // optional default
//        myPlayer.setSeq_cnt(0L);
//        myPlayer.setIdx(0L);
//
//        myPlayer.setPac(dto.getPac());
//        myPlayer.setSho(dto.getSho());
//        myPlayer.setPas(dto.getPas());
//        myPlayer.setDri(dto.getDri());
//        myPlayer.setDef(dto.getDef());
//        myPlayer.setPhy(dto.getPhy());
//
//        myPlayer.setAcceleration(dto.getAcceleration());
//        myPlayer.setSprintSpeed(dto.getSprintSpeed());
//        myPlayer.setPositioning(dto.getPositioning());
//        myPlayer.setFinishing(dto.getFinishing());
//        myPlayer.setShotPower(dto.getShotPower());
//        myPlayer.setLongShots(dto.getLongShots());
//        myPlayer.setVolleys(dto.getVolleys());
//        myPlayer.setPenalties(dto.getPenalties());
//        myPlayer.setVision(dto.getVision());
//        myPlayer.setCrossing(dto.getCrossing());
//        myPlayer.setShortPassing(dto.getShortPassing());
//        myPlayer.setLongPassing(dto.getLongPassing());
//        myPlayer.setCurve(dto.getCurve());
//        myPlayer.setDribbling(dto.getDribbling());
//        myPlayer.setAgility(dto.getAgility());
//        myPlayer.setBalance(dto.getBalance());
//        myPlayer.setReactions(dto.getReactions());
//        myPlayer.setBallControl(dto.getBallControl());
//        myPlayer.setComposure(dto.getComposure());
//
//        myPlayer.setInterceptions(dto.getInterceptions());
//        myPlayer.setHeadingAccuracy(dto.getHeadingAccuracy());
//        myPlayer.setDefAwareness(dto.getDefAwareness());
//        myPlayer.setStandingTackle(dto.getStandingTackle());
//        myPlayer.setSlidingTackle(dto.getSlidingTackle());
//
//        myPlayer.setJumping(dto.getJumping());
//        myPlayer.setStamina(dto.getStamina());
//        myPlayer.setStrength(dto.getStrength());
//        myPlayer.setAggression(dto.getAggression());
//
//        myPlayer.setWeakFoot(dto.getWeakFoot());
//        myPlayer.setSkillMoves(dto.getSkillMoves());
//        myPlayer.setPreferredFoot(dto.getPreferredFoot());
//        myPlayer.setHeight(dto.getHeight());
//        myPlayer.setWeight(dto.getWeight());
//        myPlayer.setAlternativePositions(dto.getAlternativePositions());
//        myPlayer.setAge(dto.getAge());
//        myPlayer.setPlayStyle(dto.getPlayStyle());
//        myPlayer.setUrl(dto.getUrl());
//
//        myPlayer.setGkDiving(dto.getGkDiving());
//        myPlayer.setGkHandling(dto.getGkHandling());
//        myPlayer.setGkKicking(dto.getGkKicking());
//        myPlayer.setGkPositioning(dto.getGkPositioning());
//        myPlayer.setGkReflexes(dto.getGkReflexes());
//
//        return myPlayer;
//    }
}
