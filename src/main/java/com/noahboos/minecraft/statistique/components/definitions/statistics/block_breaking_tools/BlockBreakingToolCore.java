package com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;

import java.util.HashMap;
import java.util.Map;

public class BlockBreakingToolCore extends Core {
    public static final Codec<BlockBreakingToolCore> CODEC = Codec.unboundedMap(Codec.STRING, Statistic.CODEC).xmap(BlockBreakingToolCore::fromMap, BlockBreakingToolCore::toMap);

    protected BlockBreakingToolCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public BlockBreakingToolCore() {
        super(getDefaultStatistics());
    }

    @Override
    protected BlockBreakingToolCore create(Map<String, Statistic> statistics) {
        return new BlockBreakingToolCore(statistics);
    }

    private static Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(new Core().toMap());
        statistics.put(StatisticType.BROKEN_BLOCKS.getName(), StatisticType.BROKEN_BLOCKS.getNewStatistic());
        return statistics;
    }

    private static BlockBreakingToolCore fromMap(Map<String, Statistic> map) {
        Map<String, Statistic> statistics = new HashMap<>(new BlockBreakingToolCore().statistics);
        statistics.putAll(map);
        return new BlockBreakingToolCore(statistics);
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
