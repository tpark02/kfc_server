package com.example.kfc.data;

import com.example.kfc.dto.PlayerDto;

import java.util.*;

public class FormationUtil {

    public static final Map<String, List<String>> formationPosition;

    public static final Map<String, Double> POSITION_MULTIPLIER;

    public static final Set<String> DEFENDERS;

    public static final Set<String> ATTACKERS;

    static {
        formationPosition = new HashMap<>();

        List<String> f442 = new ArrayList<>();
        f442.add("GK");
        f442.add("CB2");
        f442.add("CB1");
        f442.add("RB");
        f442.add("LB");
        f442.add("LM");
        f442.add("CM2");
        f442.add("CM1");
        f442.add("RM");
        f442.add("ST2");
        f442.add("ST1");
        formationPosition.put("442", f442);

        List<String> f433 = new ArrayList<>();
        f433.add("GK");
        f433.add("LB");
        f433.add("CB2");
        f433.add("CB1");
        f433.add("RB");
        f433.add("CM3");
        f433.add("CM2");
        f433.add("CM1");
        f433.add("LW");
        f433.add("ST");
        f433.add("RW");
        formationPosition.put("433", f433);

        List<String> f4231 = new ArrayList<>();
        f4231.add("GK");
        f4231.add("LB");
        f4231.add("CB2");
        f4231.add("CB1");
        f4231.add("RB");
        f4231.add("CDM2");
        f4231.add("CDM1");
        f4231.add("CAM3");
        f4231.add("CAM2");
        f4231.add("CAM1");
        f4231.add("ST");
        formationPosition.put("4231", f4231);

        List<String> f451 = new ArrayList<>();
        f451.add("GK");
        f451.add("LB");
        f451.add("CB2");
        f451.add("CB1");
        f451.add("RB");
        f451.add("LM");
        f451.add("CM");
        f451.add("RM");
        f451.add("CAM2");
        f451.add("CAM1");
        f451.add("ST");
        formationPosition.put("451", f451);

        List<String> f343 = new ArrayList<>();
        f343.add("GK");
        f343.add("LB");
        f343.add("CB");
        f343.add("RB");
        f343.add("LM");
        f343.add("CM2");
        f343.add("CM1");
        f343.add("RM");
        f343.add("LW");
        f343.add("ST");
        f343.add("RW");
        formationPosition.put("343", f343);

        List<String> f352 = new ArrayList<>();
        f352.add("GK");
        f352.add("LB");
        f352.add("CB");
        f352.add("RB");
        f352.add("LM");
        f352.add("CDM2");
        f352.add("CAM");
        f352.add("CDM1");
        f352.add("RM");
        f352.add("ST2");
        f352.add("ST1");
        formationPosition.put("352", f352);

        List<String> f532 = new ArrayList<>();
        f532.add("GK");
        f532.add("LB");
        f532.add("CB3");
        f532.add("CB2");
        f532.add("CB1");
        f532.add("RB");
        f532.add("LM");
        f532.add("CM");
        f532.add("RM");
        f532.add("ST2");
        f532.add("ST1");
        formationPosition.put("532", f532);

        List<String> f541 = new ArrayList<>();
        f541.add("GK");
        f541.add("LB");
        f541.add("CB3");
        f541.add("CB2");
        f541.add("CB1");
        f541.add("RB");
        f541.add("LM");
        f541.add("CM2");
        f541.add("CM1");
        f541.add("RM");
        f541.add("ST");
        formationPosition.put("541", f541);

        List<String> f41212 = new ArrayList<>();
        f41212.add("GK");
        f41212.add("LB");
        f41212.add("CB2");
        f41212.add("CB1");
        f41212.add("RB");
        f41212.add("LM");
        f41212.add("CDM");
        f41212.add("RM");
        f41212.add("CAM");
        f41212.add("ST2");
        f41212.add("ST1");
        formationPosition.put("41212", f41212);

        List<String> f4222 = new ArrayList<>();
        f4222.add("GK");
        f4222.add("LB");
        f4222.add("RB");
        f4222.add("CB2");
        f4222.add("CB1");
        f4222.add("CDM2");
        f4222.add("CDM1");
        f4222.add("LM");
        f4222.add("RM");
        f4222.add("ST2");
        f4222.add("ST1");
        formationPosition.put("4222", f4222);

        List<String> f4321 = new ArrayList<>();
        f4321.add("GK");
        f4321.add("LB");
        f4321.add("CB2");
        f4321.add("CB1");
        f4321.add("RB");
        f4321.add("LM");
        f4321.add("CM");
        f4321.add("RM");
        f4321.add("CAM2");
        f4321.add("CAM1");
        f4321.add("ST");
        formationPosition.put("4321", f4321);

        List<String> f4132 = new ArrayList<>();
        f4132.add("GK");
        f4132.add("LB");
        f4132.add("CB2");
        f4132.add("CB1");
        f4132.add("RB");
        f4132.add("LM");
        f4132.add("CM2");
        f4132.add("CM1");
        f4132.add("RM");
        f4132.add("ST2");
        f4132.add("ST1");
        formationPosition.put("4132", f4132);

        List<String> f424 = new ArrayList<>();
        f424.add("GK");
        f424.add("LB");
        f424.add("CB2");
        f424.add("CB1");
        f424.add("RB");
        f424.add("CDM2");
        f424.add("CDM1");
        f424.add("LW");
        f424.add("RW");
        f424.add("ST2");
        f424.add("ST1");
        formationPosition.put("424", f424);

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
