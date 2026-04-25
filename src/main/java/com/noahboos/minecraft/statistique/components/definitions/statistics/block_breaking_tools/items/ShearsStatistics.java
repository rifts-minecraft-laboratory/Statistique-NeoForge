package com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.BlockBreakingToolCore;

import java.util.HashMap;
import java.util.Map;

public class ShearsStatistics extends BlockBreakingToolCore<ShearsStatistics> {
    public static final Codec<ShearsStatistics> CODEC = createCodec(ShearsStatistics::new);

    protected ShearsStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public ShearsStatistics() {
        super();
    }

    @Override
    protected ShearsStatistics create(Map<String, Statistic> statistics) {
        return new ShearsStatistics(statistics);
    }
}
