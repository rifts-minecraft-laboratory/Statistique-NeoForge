package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.block_breaking.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.block_breaking.BlockBreakingToolCore;

import java.util.Map;

public class AxeStatistics extends BlockBreakingToolCore<AxeStatistics> {
    public static final Codec<AxeStatistics> CODEC = createCodec(AxeStatistics::new);

    protected AxeStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public AxeStatistics() {
        super();
    }

    @Override
    protected AxeStatistics create(Map<String, Statistic> statistics) {
        return new AxeStatistics(statistics);
    }
}
