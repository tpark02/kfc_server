package com.example.kfc.dto;

import com.example.kfc.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class PlayerDto {
    private Long id;
    private Long rank;
    private String name;
    private Long ovr;
    private Long pac;
    private Long sho;
    private Long pas;
    private Long dri;
    private Long def;
    private Long phy;
    private Long acceleration;
    private Long sprintSpeed;
    private Long positioning;
    private Long finishing;
    private Long shotPower;
    private Long longShots;
    private Long volleys;
    private Long penalties;
    private Long vision;
    private Long crossing;
    private Long freeKickAccuracy;
    private Long shortPassing;
    private Long longPassing;
    private Long curve;
    private Long dribbling;
    private Long agility;
    private Long balance;
    private Long reactions;
    private Long ballControl;
    private Long composure;
    private Long interceptions;
    private Long headingAccuracy;
    private Long defAwareness;
    private Long standingTackle;
    private Long slidingTackle;
    private Long jumping;
    private Long stamina;
    private Long strength;
    private Long aggression;
    private String pos;
    private Long weakFoot;
    private Long skillMoves;
    private String preferredFoot;
    private String height;
    private String weight;
    private String alternativePositions;
    private Long age;
    private String nation;
    private String league;
    private String team;
    private String playStyle;
    private String url;
    private String img;
    private Long gkDiving;
    private Long gkHandling;
    private Long gkKicking;
    private Long gkPositioning;
    private Long gkReflexes;

    public static PlayerDto from(Player player) {
        return new PlayerDto(
                player.getId(),
                player.getRank(),
                player.getName(),
                player.getOvr(),
                player.getPac(),
                player.getSho(),
                player.getPas(),
                player.getDri(),
                player.getDef(),
                player.getPhy(),
                player.getAcceleration(),
                player.getSprintSpeed(),
                player.getPositioning(),
                player.getFinishing(),
                player.getShotPower(),
                player.getLongShots(),
                player.getVolleys(),
                player.getPenalties(),
                player.getVision(),
                player.getCrossing(),
                player.getFreeKickAccuracy(),
                player.getShortPassing(),
                player.getLongPassing(),
                player.getCurve(),
                player.getDribbling(),
                player.getAgility(),
                player.getBalance(),
                player.getReactions(),
                player.getBallControl(),
                player.getComposure(),
                player.getInterceptions(),
                player.getHeadingAccuracy(),
                player.getDefAwareness(),
                player.getStandingTackle(),
                player.getSlidingTackle(),
                player.getJumping(),
                player.getStamina(),
                player.getStrength(),
                player.getAggression(),
                player.getPos(),
                player.getWeakFoot(),
                player.getSkillMoves(),
                player.getPreferredFoot(),
                player.getHeight(),
                player.getWeight(),
                player.getAlternativePositions(),
                player.getAge(),
                player.getNation(),
                player.getLeague(),
                player.getTeam(),
                player.getPlayStyle(),
                player.getUrl(),
                player.getImg(),
                player.getGkDiving(),
                player.getGkHandling(),
                player.getGkKicking(),
                player.getGkPositioning(),
                player.getGkReflexes()
        );
    }
}
