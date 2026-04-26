package com.noahboos.minecraft.statistique.components.definitions.statistics.armors.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.ArmorCore;

import java.util.Map;

public class LeggingsStatistics extends ArmorCore<LeggingsStatistics> {
    public static final Codec<LeggingsStatistics> CODEC = createCodec(LeggingsStatistics::new);

    protected LeggingsStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public LeggingsStatistics() {
        super();
    }

    @Override
    protected LeggingsStatistics create(Map<String, Statistic> statistics) {
        return new LeggingsStatistics(statistics);
    }
}
