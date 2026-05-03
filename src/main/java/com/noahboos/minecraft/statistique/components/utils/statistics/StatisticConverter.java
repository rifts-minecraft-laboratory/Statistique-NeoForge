package com.noahboos.minecraft.statistique.components.utils.statistics;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;

import java.util.HashMap;
import java.util.Map;

public class StatisticConverter {
    /**
     * A map that maps legacy names to their current names.
     */
    private static final Map<String, String> LEGACY_TO_CURRENT_MAP = getLegacyToCurrentMap();

    /**
     * @return A map that maps legacy names to their current names.
     */
    private static Map<String, String> getLegacyToCurrentMap() {
        Map<String, String> map = new HashMap<>();
        for (StatisticType type : StatisticType.values()) {
            map.put(type.getLegacyName(), type.getName());
        }
        return map;
    }

    /**
     * Converts a legacy name to the current name if it exists. Otherwise, returns the legacy name.
     * @param legacyName The legacy name to convert.
     * @return The current name, if it exists; otherwise, the provided legacy name.
     */
    public static String convertLegacyName(String legacyName) {
        return LEGACY_TO_CURRENT_MAP.getOrDefault(legacyName, legacyName);
    }

    /**
     * Converts a map of statistics using legacy names to a map of statistics using current names.
     * @param statistics The map of statistics to convert.
     * @return An updated map of statistics.
     */
    public static Map<String, Statistic> convertLegacyStatistics(Map<String, Statistic> statistics) {
        Map<String, Statistic> _statistics = new HashMap<>();
        statistics.forEach((name, statistic) -> {
            String _name = convertLegacyName(name);
            Statistic _statistic = _name.equals(statistic.name()) ? statistic : new Statistic(_name, statistic.value());
            _statistics.put(_name, _statistic);
        });
        return _statistics;
    }
}
