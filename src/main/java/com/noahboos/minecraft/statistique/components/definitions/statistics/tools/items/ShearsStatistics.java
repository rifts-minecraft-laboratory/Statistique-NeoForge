package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;

import java.util.HashMap;
import java.util.Map;

public class ShearsStatistics extends ToolCore {
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
        Map<String, Statistic> statistics = new HashMap<>(new ToolCore().toMap());
        statistics.put(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), StatisticType.REALIZED_SECONDARY_ACTIONS.getNewStatistic());
        statistics.put(StatisticType.CARVED_BLOCKS.getName(), StatisticType.CARVED_BLOCKS.getNewStatistic());
        statistics.put(StatisticType.DISARMED_BLOCKS.getName(), StatisticType.DISARMED_BLOCKS.getNewStatistic());
        statistics.put(StatisticType.HARVESTED_BLOCKS.getName(), StatisticType.HARVESTED_BLOCKS.getNewStatistic());
        statistics.put(StatisticType.REMOVED_ARMOR.getName(), StatisticType.REMOVED_ARMOR.getNewStatistic());
        statistics.put(StatisticType.SHEARED_SHEEP.getName(), StatisticType.SHEARED_SHEEP.getNewStatistic());
        statistics.put(StatisticType.TRIMMED_BLOCKS.getName(), StatisticType.TRIMMED_BLOCKS.getNewStatistic());
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
