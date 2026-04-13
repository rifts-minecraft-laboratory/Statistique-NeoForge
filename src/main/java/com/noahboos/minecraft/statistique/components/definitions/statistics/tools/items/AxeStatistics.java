package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;

import java.util.HashMap;
import java.util.Map;

public class AxeStatistics extends ToolCore {
    public static final Codec<AxeStatistics> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(AxeStatistics::fromMap, AxeStatistics::toMap);

    protected AxeStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public AxeStatistics() {
        super(getDefaultStatistics());
    }

    @Override
    protected AxeStatistics create(Map<String, Statistic> statistics) {
        return new AxeStatistics(statistics);
    }

    private static Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(new ToolCore().toMap());
        statistics.put(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), StatisticType.REALIZED_SECONDARY_ACTIONS.getNewStatistic());
        statistics.put(StatisticType.STRIPPED_BLOCKS.getName(), StatisticType.STRIPPED_BLOCKS.getNewStatistic());
        statistics.put(StatisticType.DEWAXED_BLOCKS.getName(), StatisticType.DEWAXED_BLOCKS.getNewStatistic());
        return statistics;
    }

    private static AxeStatistics fromMap(Map<String, Statistic> map) {
        Map<String, Statistic> statistics = new HashMap<>(new AxeStatistics().statistics);
        statistics.putAll(map);
        return new AxeStatistics(statistics);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
