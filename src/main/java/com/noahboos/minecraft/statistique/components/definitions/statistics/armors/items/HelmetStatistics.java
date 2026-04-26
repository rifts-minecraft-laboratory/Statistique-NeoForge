package com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.ArmorCore;

import java.util.Map;

public class HelmetStatistics extends ArmorCore<HelmetStatistics> {
    public static final Codec<HelmetStatistics> CODEC = createCodec(HelmetStatistics::new);

    protected HelmetStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public HelmetStatistics() {
        super();
    }

    @Override
    protected HelmetStatistics create(Map<String, Statistic> statistics) {
        return new HelmetStatistics(statistics);
    }
}
