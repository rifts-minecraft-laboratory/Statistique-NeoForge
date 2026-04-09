package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;

import java.util.HashMap;
import java.util.Map;

public class AxeStatistics extends ToolCore {
    public static final Codec<AxeStatistics> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(AxeStatistics::fromMap, AxeStatistics::toMap);

    private static AxeStatistics fromMap(Map<String, Statistic> map) {
        AxeStatistics axeStatistics = new AxeStatistics();
        axeStatistics.statistics.putAll(map);
        return axeStatistics;
    }

    private Map<String, Statistic> toMap() {
        return new HashMap<>(statistics);
    }
}
