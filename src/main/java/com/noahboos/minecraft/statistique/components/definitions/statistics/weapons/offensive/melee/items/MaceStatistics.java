package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee.MeleeOffensiveWeaponCore;

import java.util.Map;

public class MaceStatistics extends MeleeOffensiveWeaponCore<MaceStatistics> {
    public static final Codec<MaceStatistics> CODEC = createCodec(MaceStatistics::new);

    protected MaceStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public MaceStatistics() {
        super();
    }

    @Override
    protected MaceStatistics create(Map<String, Statistic> statistics) {
        return new MaceStatistics(statistics);
    }
}
