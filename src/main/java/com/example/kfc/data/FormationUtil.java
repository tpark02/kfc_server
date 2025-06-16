package com.example.kfc.data;

import com.example.kfc.service.RandomTeamService;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToLongFunction;

public class FormationUtil {

    public static final Map<String, List<String>> formationPosition;

    public static final Map<String, Double> POSITION_MULTIPLIER;

    public static final Set<String> DEFENDERS;

    public static final Set<String> ATTACKERS;

    public static final List<String> formationNames = List.of(
            "442", "433", "352", "4231", "451", "343", "532",
            "541", "41212", "4222", "4321", "4132", "424");

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

    public static <T> Long estimateValue(
            T player,
            ToLongFunction<T> getOvr,
            Function<T, String> getPos,
            Function<T, String> getName
                                        ) {
        double baseValue = Math.pow(getOvr.applyAsLong(player), 2);
        double multiplier = POSITION_MULTIPLIER.getOrDefault(getPos.apply(player), 1.0);
        System.out.println("estimating: " + getName.apply(player) + " / pos=" + getPos.apply(player) + " / ovr=" + getOvr.applyAsLong(player));

        return Math.round(baseValue * multiplier);
    }


    public static <T> Map<String, Long> getDefenseAttackSplit(
            List<T> players,
            ToLongFunction<T> getDef,
            ToLongFunction<T> getSho
                                                             ) {
        double avgDef = players.stream().mapToLong(getDef).average().orElse(0);
        double avgSho = players.stream().mapToLong(getSho).average().orElse(0);

        Map<String, Long> result = new HashMap<>();
        result.put("defense", Math.round(avgDef));
        result.put("attack", Math.round(avgSho));
        return result;
    }

    // 🟡 평균 스탯 계산 (pace, age, stamina 등)
    public static <T> Long getAverageStat(List<T> players, ToLongFunction<T> getter) {
        return (long) Math.round(
                (float) players.stream().filter(Objects::nonNull).mapToLong(getter).sum() / RandomTeamService.startingPlayerCount
                                );
    }

    // 🔴 공격/수비 스플릿
    public static <T> Map<String, Long> getAttackDefenseSplit(
            List<T> players,
            ToLongFunction<T> attackGetter,
            ToLongFunction<T> defenseGetter
                                                             ) {
        double avgAtk = players.stream().mapToLong(attackGetter).average().orElse(0);
        double avgDef = players.stream().mapToLong(defenseGetter).average().orElse(0);

        Map<String, Long> result = new HashMap<>();
        result.put("attack", Math.round(avgAtk));
        result.put("defense", Math.round(avgDef));
        return result;
    }

    // 🔵 클럽 결속도
    public static <T> Long getClubCohesion(List<T> players, Function<T, String> teamGetter) {
        Map<String, Long> teamCount = new HashMap<>();
        for (T p : players) {
            Optional.ofNullable(teamGetter.apply(p))
                    .filter(team -> !team.isEmpty())
                    .ifPresent(team -> teamCount.put(team, teamCount.getOrDefault(team, 0L) + 1));
        }
        return teamCount.values().stream().max(Long::compareTo).orElse(0L) * 10L;
    }

    // 🟢 스쿼드 밸류
    public static <T> Long getSquadValue(List<T> players, Function<T, Long> valueEstimator) {
        return players.stream().mapToLong(p -> valueEstimator.apply(p)).sum();
    }
}
