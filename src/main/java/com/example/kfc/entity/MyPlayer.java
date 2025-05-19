package com.example.kfc.entity;

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
        this.playerId = 0L;
        // Match info
        this.yellowCard = 0L;
        this.redCard = 0L;
        this.rank = 0L;

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

        // GK stats
        this.gkDiving = 0L;
        this.gkHandling = 0L;
        this.gkKicking = 0L;
        this.gkPositioning = 0L;
        this.gkReflexes = 0L;

        // Optional: skill metadata
        this.weakFoot = 0L;
        this.skillMoves = 0L;
    }

    public static MyPlayer from(Player player, Long userId, Long clubId) {
        MyPlayer myPlayer = new MyPlayer();
        myPlayer.setUserId(userId);
        myPlayer.setPlayerId(player.getId());
        myPlayer.setClubId(clubId);
        myPlayer.setName(player.getName());
        myPlayer.setOvr(player.getOvr());
        myPlayer.setPos(player.getPos());
        myPlayer.setNation(player.getNation());
        myPlayer.setLeague(player.getLeague());
        myPlayer.setTeam(player.getTeam());
        myPlayer.setImg(player.getImg());

        myPlayer.setYellowCard(0L);
        myPlayer.setRedCard(0L);
        myPlayer.setRank(0L); // optional default

        myPlayer.setPac(player.getPac());
        myPlayer.setSho(player.getSho());
        myPlayer.setPas(player.getPas());
        myPlayer.setDri(player.getDri());
        myPlayer.setDef(player.getDef());
        myPlayer.setPhy(player.getPhy());

        myPlayer.setAcceleration(player.getAcceleration());
        myPlayer.setSprintSpeed(player.getSprintSpeed());
        myPlayer.setPositioning(player.getPositioning());
        myPlayer.setFinishing(player.getFinishing());
        myPlayer.setShotPower(player.getShotPower());
        myPlayer.setLongShots(player.getLongShots());
        myPlayer.setVolleys(player.getVolleys());
        myPlayer.setPenalties(player.getPenalties());
        myPlayer.setVision(player.getVision());
        myPlayer.setCrossing(player.getCrossing());
        myPlayer.setShortPassing(player.getShortPassing());
        myPlayer.setLongPassing(player.getLongPassing());
        myPlayer.setCurve(player.getCurve());
        myPlayer.setDribbling(player.getDribbling());
        myPlayer.setAgility(player.getAgility());
        myPlayer.setBalance(player.getBalance());
        myPlayer.setReactions(player.getReactions());
        myPlayer.setBallControl(player.getBallControl());
        myPlayer.setComposure(player.getComposure());

        myPlayer.setInterceptions(player.getInterceptions());
        myPlayer.setHeadingAccuracy(player.getHeadingAccuracy());
        myPlayer.setDefAwareness(player.getDefAwareness());
        myPlayer.setStandingTackle(player.getStandingTackle());
        myPlayer.setSlidingTackle(player.getSlidingTackle());

        myPlayer.setJumping(player.getJumping());
        myPlayer.setStamina(player.getStamina());
        myPlayer.setStrength(player.getStrength());
        myPlayer.setAggression(player.getAggression());

        myPlayer.setWeakFoot(player.getWeakFoot());
        myPlayer.setSkillMoves(player.getSkillMoves());
        myPlayer.setPreferredFoot(player.getPreferredFoot());
        myPlayer.setHeight(player.getHeight());
        myPlayer.setWeight(player.getWeight());
        myPlayer.setAlternativePositions(player.getAlternativePositions());
        myPlayer.setAge(player.getAge());
        myPlayer.setPlayStyle(player.getPlayStyle());
        myPlayer.setUrl(player.getUrl());

        myPlayer.setGkDiving(player.getGkDiving());
        myPlayer.setGkHandling(player.getGkHandling());
        myPlayer.setGkKicking(player.getGkKicking());
        myPlayer.setGkPositioning(player.getGkPositioning());
        myPlayer.setGkReflexes(player.getGkReflexes());

        return myPlayer;
    }
}
