package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.hybride.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;

import java.util.Map;

public class TridentStatistics extends OffensiveWeaponCore<TridentStatistics> {
    public static final Codec<TridentStatistics> CODEC = createCodec(TridentStatistics::new);

    protected TridentStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public TridentStatistics() {
        super();
    }

    @Override
    protected TridentStatistics create(Map<String, Statistic> statistics) {
        return new TridentStatistics(statistics);
    }
}
