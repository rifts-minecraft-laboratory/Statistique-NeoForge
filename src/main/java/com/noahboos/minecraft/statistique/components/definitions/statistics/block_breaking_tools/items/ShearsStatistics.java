package com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.BlockBreakingToolCore;

import java.util.HashMap;
import java.util.Map;

public class ShearsStatistics extends BlockBreakingToolCore {
    public static final Codec<ShearsStatistics> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(ShearsStatistics::fromMap, ShearsStatistics::toMap);

    protected ShearsStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public ShearsStatistics() {
        super(getDefaultStatistics());
    }

    @Override
    protected ShearsStatistics create(Map<String, Statistic> statistics) {
        return new ShearsStatistics(statistics);
    }

    private static Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(new BlockBreakingToolCore().toMap());
        return statistics;
    }

    private static ShearsStatistics fromMap(Map<String, Statistic> map) {
        Map<String, Statistic> statistics = new HashMap<>(new ShearsStatistics().statistics);
        statistics.putAll(map);
        return new ShearsStatistics(statistics);
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
