package com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.ArmorCore;

import java.util.Map;

public class ChestplateStatistics extends ArmorCore<ChestplateStatistics> {
    public static final Codec<ChestplateStatistics> CODEC = createCodec(ChestplateStatistics::new);

    protected ChestplateStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public ChestplateStatistics() {
        super();
    }

    @Override
    protected ChestplateStatistics create(Map<String, Statistic> statistics) {
        return new ChestplateStatistics(statistics);
    }
}
