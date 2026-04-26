package com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.BlockBreakingToolCore;

import java.util.HashMap;
import java.util.Map;

public class PickaxeStatistics extends BlockBreakingToolCore<PickaxeStatistics> {
    public static final Codec<PickaxeStatistics> CODEC = createCodec(PickaxeStatistics::new);

    protected PickaxeStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public PickaxeStatistics() {
        super();
    }

    @Override
    protected PickaxeStatistics create(Map<String, Statistic> statistics) {
        return new PickaxeStatistics(statistics);
    }
}
