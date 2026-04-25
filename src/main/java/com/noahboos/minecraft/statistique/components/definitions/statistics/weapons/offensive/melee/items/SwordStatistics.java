package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.MeleeOffensiveWeaponCore;

import java.util.Map;

public class SwordStatistics extends MeleeOffensiveWeaponCore<SwordStatistics> {
    public static final Codec<SwordStatistics> CODEC = createCodec(SwordStatistics::new);

    protected SwordStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public SwordStatistics() {
        super();
    }

    @Override
    protected SwordStatistics create(Map<String, Statistic> statistics) {
        return new SwordStatistics(statistics);
    }
}
