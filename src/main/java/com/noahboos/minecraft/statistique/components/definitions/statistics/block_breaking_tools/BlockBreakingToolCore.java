package com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;

import java.util.HashMap;
import java.util.Map;

public abstract class BlockBreakingToolCore<T extends BlockBreakingToolCore<T>> extends Core<T> {
    protected BlockBreakingToolCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public BlockBreakingToolCore() {
        super();
    }

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(super.getDefaultStatistics());
        statistics.put(StatisticType.BLOCKS_BROKEN.getName(), StatisticType.BLOCKS_BROKEN.getNewStatistic());
        return statistics;
    }
}
