package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.DefensiveWeaponCore;

import java.util.Map;

public class ShieldStatistics extends DefensiveWeaponCore<ShieldStatistics> {
    public static final Codec<ShieldStatistics> CODEC = createCodec(ShieldStatistics::new);

    protected ShieldStatistics(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public ShieldStatistics() {
        super();
    }

    @Override
    protected ShieldStatistics create(Map<String, Statistic> statistics) {
        return new ShieldStatistics(statistics);
    }

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = super.getDefaultStatistics();
        statistics.put(StatisticType.DAMAGE_BLOCKED.getName(), StatisticType.DAMAGE_BLOCKED.getNewStatistic());
        return statistics;
    }
}
