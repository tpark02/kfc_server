package com.example.kfc.dto;

import com.example.kfc.entity.MyStore;
import com.example.kfc.entity.Player;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class MyStoreDto {
    private Long id;
    private Long userId;
    private Long playerId;
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

    public static MyStoreDto from(MyStore m) {
        return new MyStoreDto(
                m.getId(),
                m.getUserId(),
                m.getPlayerId(),
                m.getRank(),
                m.getName(),
                m.getOvr(),
                m.getPac(),
                m.getSho(),
                m.getPas(),
                m.getDri(),
                m.getDef(),
                m.getPhy(),
                m.getAcceleration(),
                m.getSprintSpeed(),
                m.getPositioning(),
                m.getFinishing(),
                m.getShotPower(),
                m.getLongShots(),
                m.getVolleys(),
                m.getPenalties(),
                m.getVision(),
                m.getCrossing(),
                m.getFreeKickAccuracy(),
                m.getShortPassing(),
                m.getLongPassing(),
                m.getCurve(),
                m.getDribbling(),
                m.getAgility(),
                m.getBalance(),
                m.getReactions(),
                m.getBallControl(),
                m.getComposure(),
                m.getInterceptions(),
                m.getHeadingAccuracy(),
                m.getDefAwareness(),
                m.getStandingTackle(),
                m.getSlidingTackle(),
                m.getJumping(),
                m.getStamina(),
                m.getStrength(),
                m.getAggression(),
                m.getPos(),
                m.getWeakFoot(),
                m.getSkillMoves(),
                m.getPreferredFoot(),
                m.getHeight(),
                m.getWeight(),
                m.getAlternativePositions(),
                m.getAge(),
                m.getNation(),
                m.getLeague(),
                m.getTeam(),
                m.getPlayStyle(),
                m.getUrl(),
                m.getImg(),
                m.getGkDiving(),
                m.getGkHandling(),
                m.getGkKicking(),
                m.getGkPositioning(),
                m.getGkReflexes()
        );
    }
}
