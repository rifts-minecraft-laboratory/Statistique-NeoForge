package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.block_breaking.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.block_breaking.BlockBreakingToolCore;

import java.util.Map;

public class ShovelStatistics extends BlockBreakingToolCore<ShovelStatistics> {
    public static final Codec<ShovelStatistics> CODEC = createCodec(ShovelStatistics::new);

    protected ShovelStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public ShovelStatistics() {
        super();
    }

    @Override
    protected ShovelStatistics create(Map<String, Statistic> statistics) {
        return new ShovelStatistics(statistics);
    }
}
