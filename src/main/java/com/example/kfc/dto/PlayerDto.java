package com.example.kfc.dto;

import com.example.kfc.entity.Player;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PlayerDto {
    private Long id;
    private Long idx;
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
    private Long price;
    private Long teamId;
    private Long leagueId;
    private String leagueUrl;
    private String teamUrl;

    public static PlayerDto from(Player player) {
        return new PlayerDto(
                player.getId(),
                -1L,    // playerDto default idx : -1
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
                player.getGkReflexes(),
                player.getPrice(),
                player.getTeamId(),
                player.getLeagueId(),
                player.getLeagueUrl(),
                player.getTeamUrl()
        );
    }

    public static Player toEntity(PlayerDto dto) {
        Player player = new Player();
        // lombok @Getter만 있으므로 setter 직접 호출이 안 됨 → 생성자 필요 또는 Builder 사용 추천

        // 또는 모든 필드 포함 생성자 사용
        return new Player(
                dto.getId(),
                dto.getRank(),
                dto.getName(),
                dto.getOvr(),
                dto.getPac(),
                dto.getSho(),
                dto.getPas(),
                dto.getDri(),
                dto.getDef(),
                dto.getPhy(),
                dto.getAcceleration(),
                dto.getSprintSpeed(),
                dto.getPositioning(),
                dto.getFinishing(),
                dto.getShotPower(),
                dto.getLongShots(),
                dto.getVolleys(),
                dto.getPenalties(),
                dto.getVision(),
                dto.getCrossing(),
                dto.getFreeKickAccuracy(),
                dto.getShortPassing(),
                dto.getLongPassing(),
                dto.getCurve(),
                dto.getDribbling(),
                dto.getAgility(),
                dto.getBalance(),
                dto.getReactions(),
                dto.getBallControl(),
                dto.getComposure(),
                dto.getInterceptions(),
                dto.getHeadingAccuracy(),
                dto.getDefAwareness(),
                dto.getStandingTackle(),
                dto.getSlidingTackle(),
                dto.getJumping(),
                dto.getStamina(),
                dto.getStrength(),
                dto.getAggression(),
                dto.getPos(),
                dto.getWeakFoot(),
                dto.getSkillMoves(),
                dto.getPreferredFoot(),
                dto.getHeight(),
                dto.getWeight(),
                dto.getAlternativePositions(),
                dto.getAge(),
                dto.getNation(),
                dto.getLeague(),
                dto.getTeam(),
                dto.getPlayStyle(),
                dto.getUrl(),
                dto.getImg(),
                dto.getGkDiving(),
                dto.getGkHandling(),
                dto.getGkKicking(),
                dto.getGkPositioning(),
                dto.getGkReflexes(),
                dto.getPrice(),
                dto.getTeamId(),
                dto.getLeagueId(),
                dto.getLeagueUrl(),
                dto.getTeamUrl()
        );
    }

}
