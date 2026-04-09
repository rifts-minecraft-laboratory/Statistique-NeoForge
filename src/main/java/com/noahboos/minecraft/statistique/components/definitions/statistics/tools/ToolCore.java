package com.noahboos.minecraft.statistique.components.definitions.statistics.tools;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;

import java.util.HashMap;
import java.util.Map;

public class ToolCore extends Core {
    public static final Codec<ToolCore> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(ToolCore::fromMap, ToolCore::toMap);

    protected ToolCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public ToolCore() {
        super(getDefaultStatistics());
    }

    private static Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(new Core().toMap());
        statistics.put(StatisticType.MINED_BLOCKS.getName(), StatisticType.MINED_BLOCKS.getNewStatistic());
        return statistics;
    }

    private static ToolCore fromMap(Map<String, Statistic> map) {
        Map<String, Statistic> statistics = new HashMap<>(new ToolCore().statistics);
        statistics.putAll(map);
        return new ToolCore(statistics);
    }

//    private Map<String, Statistic> toMap() {
//        return statistics;
//    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
