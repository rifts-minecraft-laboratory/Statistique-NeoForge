package com.noahboos.minecraft.statistique.components.definitions.statistics.tools.block_breaking.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.block_breaking.BlockBreakingToolCore;

import java.util.Map;

public class HoeStatistics extends BlockBreakingToolCore<HoeStatistics> {
    public static final Codec<HoeStatistics> CODEC = createCodec(HoeStatistics::new);

    protected HoeStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public HoeStatistics() {
        super();
    }

    @Override
    protected HoeStatistics create(Map<String, Statistic> statistics) {
        return new HoeStatistics(statistics);
    }
}
