package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;

import java.util.HashMap;
import java.util.Map;

public class PickaxeStatistics extends ToolCore {
    public static final Codec<PickaxeStatistics> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(PickaxeStatistics::fromMap, PickaxeStatistics::toMap);

    protected PickaxeStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public PickaxeStatistics() {
        super(getDefaultStatistics());
    }

    @Override
    protected PickaxeStatistics create(Map<String, Statistic> statistics) {
        return new PickaxeStatistics(statistics);
    }

    private static Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(new ToolCore().toMap());
        return statistics;
    }

    private static PickaxeStatistics fromMap(Map<String, Statistic> map) {
        Map<String, Statistic> statistics = new HashMap<>(new PickaxeStatistics().statistics);
        statistics.putAll(map);
        return new PickaxeStatistics(statistics);
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
