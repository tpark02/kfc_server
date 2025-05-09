package com.example.kfc.data;

import com.example.kfc.dto.PlayerDto;

import java.util.*;

public class FormationUtil {

    public static final LinkedHashMap<String, LinkedHashMap<String, Integer>> FORMATION_POSITION_COUNTS;

    public static final Map<String, Double> POSITION_MULTIPLIER;

    public static final Set<String> DEFENDERS;

    public static final Set<String> ATTACKERS;

    static {
        FORMATION_POSITION_COUNTS = new LinkedHashMap<>();

        LinkedHashMap<String, Integer> f442 = new LinkedHashMap<>();
        f442.put("GK", 1);
        f442.put("LB", 1);
        f442.put("CB", 2);
        f442.put("RB", 1);
        f442.put("LM", 1);
        f442.put("CM", 2);
        f442.put("RM", 1);
        f442.put("ST", 2);
        FORMATION_POSITION_COUNTS.put("442", f442);

        LinkedHashMap<String, Integer> f433 = new LinkedHashMap<>();
        f433.put("GK", 1);
        f433.put("LB", 1);
        f433.put("CB", 2);
        f433.put("RB", 1);
        f433.put("CM", 3);
        f433.put("LW", 1);
        f433.put("ST", 1);
        f433.put("RW", 1);
        FORMATION_POSITION_COUNTS.put("433", f433);

        LinkedHashMap<String, Integer> f4231 = new LinkedHashMap<>();
        f4231.put("GK", 1);
        f4231.put("LB", 1);
        f4231.put("CB", 2);
        f4231.put("RB", 1);
        f4231.put("CDM", 2);
        f4231.put("CAM", 3);
        f4231.put("ST", 1);
        FORMATION_POSITION_COUNTS.put("4231", f4231);

        LinkedHashMap<String, Integer> f451 = new LinkedHashMap<>();
        f451.put("GK", 1);
        f451.put("LB", 1);
        f451.put("CB", 2);
        f451.put("RB", 1);
        f451.put("LM", 1);
        f451.put("CM", 1);
        f451.put("RM", 1);
        f451.put("CAM", 2);
        f451.put("ST", 1);
        FORMATION_POSITION_COUNTS.put("451", f451);

        LinkedHashMap<String, Integer> f343 = new LinkedHashMap<>();
        f343.put("GK", 1);
        f343.put("LB", 1);
        f343.put("CB", 1);
        f343.put("RB", 1);
        f343.put("LM", 1);
        f343.put("CM", 2);
        f343.put("RM", 1);
        f343.put("LW", 1);
        f343.put("ST", 1);
        f343.put("RW", 1);
        FORMATION_POSITION_COUNTS.put("343", f343);

        LinkedHashMap<String, Integer> f352 = new LinkedHashMap<>();
        f352.put("GK", 1);
        f352.put("LB", 1);
        f352.put("CB", 1);
        f352.put("RB", 1);
        f352.put("LM", 1);
        f352.put("CDM", 2);
        f352.put("CAM", 1);
        f352.put("RM", 1);
        f352.put("ST", 2);
        FORMATION_POSITION_COUNTS.put("352", f352);

        LinkedHashMap<String, Integer> f532 = new LinkedHashMap<>();
        f532.put("GK", 1);
        f532.put("LB", 1);
        f532.put("CB", 3);
        f532.put("RB", 1);
        f532.put("LM", 1);
        f532.put("CM", 1);
        f532.put("RM", 1);
        f532.put("ST", 2);
        FORMATION_POSITION_COUNTS.put("532", f532);

        LinkedHashMap<String, Integer> f541 = new LinkedHashMap<>();
        f541.put("GK", 1);
        f541.put("LB", 1);
        f541.put("CB", 3);
        f541.put("RB", 1);
        f541.put("LM", 1);
        f541.put("CM", 2);
        f541.put("RM", 1);
        f541.put("ST", 1);
        FORMATION_POSITION_COUNTS.put("541", f541);

        LinkedHashMap<String, Integer> f41212 = new LinkedHashMap<>();
        f41212.put("GK", 1);
        f41212.put("LB", 1);
        f41212.put("CB", 2);
        f41212.put("RB", 1);
        f41212.put("LM", 1);
        f41212.put("CDM", 1);
        f41212.put("RM", 1);
        f41212.put("CAM", 1);
        f41212.put("ST", 2);
        FORMATION_POSITION_COUNTS.put("41212", f41212);

        LinkedHashMap<String, Integer> f4222 = new LinkedHashMap<>();
        f4222.put("GK", 1);
        f4222.put("LB", 1);
        f4222.put("RB", 1);
        f4222.put("CB", 2);
        f4222.put("CDM", 2);
        f4222.put("LM", 1);
        f4222.put("RM", 1);
        f4222.put("ST", 2);
        FORMATION_POSITION_COUNTS.put("4222", f4222);

        LinkedHashMap<String, Integer> f4321 = new LinkedHashMap<>();
        f4321.put("GK", 1);
        f4321.put("LB", 1);
        f4321.put("CB", 2);
        f4321.put("RB", 1);
        f4321.put("LM", 1);
        f4321.put("CM", 1);
        f4321.put("RM", 1);
        f4321.put("CAM", 2);
        f4321.put("ST", 1);
        FORMATION_POSITION_COUNTS.put("4321", f4321);

        LinkedHashMap<String, Integer> f4132 = new LinkedHashMap<>();
        f4132.put("GK", 1);
        f4132.put("LB", 1);
        f4132.put("CB", 2);
        f4132.put("RB", 1);
        f4132.put("LM", 1);
        f4132.put("CM", 2);
        f4132.put("RM", 1);
        f4132.put("ST", 2);
        FORMATION_POSITION_COUNTS.put("4132", f4132);

        LinkedHashMap<String, Integer> f424 = new LinkedHashMap<>();
        f424.put("GK", 1);
        f424.put("LB", 1);
        f424.put("CB", 2);
        f424.put("RB", 1);
        f424.put("CDM", 2);
        f424.put("LW", 1);
        f424.put("RW", 1);
        f424.put("ST", 2);
        FORMATION_POSITION_COUNTS.put("424", f424);

        // positionMultiplier
        Map<String, Double> posMulti = new HashMap<>();
        posMulti.put("GK", 0.9);
        posMulti.put("CB", 1.0);
        posMulti.put("LB", 1.0);
        posMulti.put("RB", 1.0);
        posMulti.put("CDM", 1.05);
        posMulti.put("CM", 1.1);
        posMulti.put("CAM", 1.15);
        posMulti.put("LM", 1.1);
        posMulti.put("RM", 1.1);
        posMulti.put("LW", 1.2);
        posMulti.put("RW", 1.2);
        posMulti.put("ST", 1.3);
        posMulti.put("CF", 1.25);
        POSITION_MULTIPLIER = Collections.unmodifiableMap(posMulti);

        // defenders
        DEFENDERS = Set.of("GK", "CB", "LB", "RB", "LWB", "RWB", "CDM");

        // attackers
        ATTACKERS = Set.of("ST", "CF", "CAM", "LW", "RW", "LM", "RM");
    }

    public static Long estimateValue(PlayerDto player) {
        double baseValue = Math.pow(player.getOvr(), 2) * 1000;
        double multiplier = POSITION_MULTIPLIER.getOrDefault(player.getPos(), 1.0);
        System.out.println("estimating: " + player.getName() + " / pos=" + player.getPos() + " / ovr=" + player.getOvr());

        return Math.round(baseValue * multiplier);
    }

    public static Map<String, Long> getDefenseAttackSplit(List<PlayerDto> players) {
        double avgDef = players.stream()
                .mapToLong(PlayerDto::getDef)
                .average()
                .orElse(0);

        double avgSho = players.stream()
                .mapToLong(PlayerDto::getSho)
                .average()
                .orElse(0);

        Map<String, Long> result = new HashMap<>();
        result.put("defense", Math.round(avgDef));
        result.put("attack", Math.round(avgSho));
        return result;
    }

    public static Long getPaceIndex(List<PlayerDto> players) {
        long sum = players.stream().mapToLong(PlayerDto::getPac).sum();
        return (long) Math.round((float) sum / 11);
    }

    public  static Long getTeamAge(List<PlayerDto> players) {
        long sum = players.stream().mapToLong(PlayerDto::getAge).sum();
        return (long) Math.round((float) sum / 11);
    }

    public static Long getClubCohesion(List<PlayerDto> players) {
        Map<String, Long> clubCount = new HashMap<>();

        for (var p : players) {
            if (p != null && p.getTeam() != null && !p.getTeam().isEmpty()) {
                clubCount.put(p.getTeam(), clubCount.getOrDefault(p.getTeam(), 0L) + 1);
            }
        }
        return clubCount.values().stream().max(Long::compareTo).orElse(0L) * 10L;
    }

    public static Long getTeamStamina(List<PlayerDto> players) {
        long sum = players.stream().mapToLong(PlayerDto::getStamina).sum();
        return (long) Math.round((float) sum / 11);
    }
}
