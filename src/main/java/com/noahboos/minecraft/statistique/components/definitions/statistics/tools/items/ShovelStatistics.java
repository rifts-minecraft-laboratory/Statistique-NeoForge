package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;

import java.util.HashMap;
import java.util.Map;

public class ShovelStatistics extends ToolCore {
    public static final Codec<ShovelStatistics> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(ShovelStatistics::fromMap, ShovelStatistics::toMap);

    protected ShovelStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public ShovelStatistics() {
        super(getDefaultStatistics());
    }

    @Override
    protected ShovelStatistics create(Map<String, Statistic> statistics) {
        return new ShovelStatistics(statistics);
    }

    private static Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(new ToolCore().toMap());
        statistics.put(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), StatisticType.REALIZED_SECONDARY_ACTIONS.getNewStatistic());
        statistics.put(StatisticType.DOUSED_FIRES.getName(), StatisticType.DOUSED_FIRES.getNewStatistic());
        statistics.put(StatisticType.FLATTENED_BLOCKS.getName(), StatisticType.FLATTENED_BLOCKS.getNewStatistic());
        return statistics;
    }

    private static ShovelStatistics fromMap(Map<String, Statistic> map) {
        Map<String, Statistic> statistics = new HashMap<>(new ShovelStatistics().statistics);
        statistics.putAll(map);
        return new ShovelStatistics(statistics);
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
