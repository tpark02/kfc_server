package com.example.kfc.data;

import java.util.HashMap;
import java.util.Map;

public class FormationPositionCounts {

    public static final Map<String, Map<String, Integer>> FORMATION_POSITION_COUNTS;

    static {
        FORMATION_POSITION_COUNTS = new HashMap<>();

        FORMATION_POSITION_COUNTS.put("442", Map.of(
                "ST", 2,
                "LM", 1,
                "RM", 1,
                "CAM", 2,
                "LB", 1,
                "CDM", 2,
                "RB", 1,
                "GK", 1
                                                   ));

        FORMATION_POSITION_COUNTS.put("433", Map.of(
                "ST", 2,
                "RW", 1,
                "LM", 1,
                "CM", 1,
                "RM", 1,
                "LB", 1,
                "CB", 2,
                "RB", 1,
                "GK", 1
                                                   ));

        FORMATION_POSITION_COUNTS.put("4231", Map.of(
                "ST", 1,
                "CAM", 3,
                "CDM", 2,
                "LB", 1,
                "CB", 2,
                "RB", 1,
                "GK", 1
                                                    ));

        FORMATION_POSITION_COUNTS.put("451", Map.of(
                "ST", 1,
                "LM", 2,
                "CAM", 1,
                "RM", 2,
                "LB", 1,
                "CB", 2,
                "RB", 1,
                "GK", 1
                                                   ));

        FORMATION_POSITION_COUNTS.put("343", Map.of(
                "LW", 1,
                "ST", 1,
                "RW", 1,
                "LM", 1,
                "CAM", 2,
                "RM", 1,
                "CB", 3,
                "GK", 1
                                                   ));

        FORMATION_POSITION_COUNTS.put("352", Map.of(
                "ST", 2,
                "LM", 1,
                "CM", 3,
                "RM", 1,
                "CB", 3,
                "GK", 1
                                                   ));

        FORMATION_POSITION_COUNTS.put("532", Map.of(
                "ST", 2,
                "CM", 3,
                "LB", 1,
                "CB", 3,
                "RB", 1,
                "GK", 1
                                                   ));

        FORMATION_POSITION_COUNTS.put("541", Map.of(
                "ST", 1,
                "LM", 1,
                "CM", 2,
                "RM", 1,
                "LB", 1,
                "CB", 3,
                "RB", 1,
                "GK", 1
                                                   ));

        FORMATION_POSITION_COUNTS.put("41212", Map.of(
                "ST", 2,
                "CAM", 1,
                "CM", 2,
                "CDM", 1,
                "LB", 2,
                "CB", 1,
                "RB", 1,
                "GK", 1
                                                     ));

        FORMATION_POSITION_COUNTS.put("4222", Map.of(
                "ST", 2,
                "CAM", 2,
                "CDM", 2,
                "LB", 2,
                "RB", 2,
                "GK", 1
                                                    ));

        FORMATION_POSITION_COUNTS.put("4321", Map.of(
                "ST", 1,
                "CAM", 2,
                "CM", 3,
                "LB", 1,
                "CB", 2,
                "RB", 1,
                "GK", 1
                                                    ));

        FORMATION_POSITION_COUNTS.put("4132", Map.of(
                "ST", 2,
                "LM", 1,
                "CAM", 1,
                "RM", 1,
                "CDM", 1,
                "LB", 1,
                "CB", 2,
                "RB", 1,
                "GK", 1
                                                    ));

        FORMATION_POSITION_COUNTS.put("424", Map.of(
                "LW", 1,
                "ST", 2,
                "RW", 1,
                "CM", 2,
                "LB", 1,
                "CB", 2,
                "RB", 1,
                "GK", 1
                                                   ));
    }
}
