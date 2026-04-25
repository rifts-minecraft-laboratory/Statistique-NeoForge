package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.RangedOffensiveWeaponCore;

import java.util.Map;

public class BowStatistics extends RangedOffensiveWeaponCore<BowStatistics> {
    public static final Codec<BowStatistics> CODEC = createCodec(BowStatistics::new);

    protected BowStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public BowStatistics() {
        super();
    }

    @Override
    protected BowStatistics create(Map<String, Statistic> statistics) {
        return new BowStatistics(statistics);
    }
}
