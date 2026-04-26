package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.RangedOffensiveWeaponCore;

import java.util.Map;

public class CrossbowStatistics extends RangedOffensiveWeaponCore<CrossbowStatistics> {
    public static final Codec<CrossbowStatistics> CODEC = createCodec(CrossbowStatistics::new);

    protected CrossbowStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public CrossbowStatistics() {
        super();
    }

    @Override
    protected CrossbowStatistics create(Map<String, Statistic> statistics) {
        return new CrossbowStatistics(statistics);
    }
}
