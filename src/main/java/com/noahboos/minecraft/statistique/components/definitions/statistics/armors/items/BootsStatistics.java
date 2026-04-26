package com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.ArmorCore;

import java.util.Map;

public class BootsStatistics extends ArmorCore<BootsStatistics> {
    public static final Codec<BootsStatistics> CODEC = createCodec(BootsStatistics::new);

    protected BootsStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public BootsStatistics() {
        super();
    }

    @Override
    protected BootsStatistics create(Map<String, Statistic> statistics) {
        return new BootsStatistics(statistics);
    }
}
