package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;

import java.util.HashMap;
import java.util.Map;

public class HoeStatistics extends ToolCore {
    public static final Codec<HoeStatistics> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(HoeStatistics::fromMap, HoeStatistics::toMap);

    protected HoeStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public HoeStatistics() {
        super(getDefaultStatistics());
    }

    @Override
    protected HoeStatistics create(Map<String, Statistic> statistics) {
        return new HoeStatistics(statistics);
    }

    private static Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(new ToolCore().toMap());
        statistics.put(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), StatisticType.REALIZED_SECONDARY_ACTIONS.getNewStatistic());
        statistics.put(StatisticType.TILLED_BLOCKS.getName(), StatisticType.TILLED_BLOCKS.getNewStatistic());
        return statistics;
    }

    private static HoeStatistics fromMap(Map<String, Statistic> map) {
        Map<String, Statistic> statistics = new HashMap<>(new HoeStatistics().statistics);
        statistics.putAll(map);
        return new HoeStatistics(statistics);
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
