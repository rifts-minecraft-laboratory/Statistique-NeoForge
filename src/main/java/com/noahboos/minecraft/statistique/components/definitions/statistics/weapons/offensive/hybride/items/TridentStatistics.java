package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.hybride.items;

import com.mojang.serialization.Codec;
import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;

import java.util.HashMap;
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

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(super.getDefaultStatistics());
        statistics.put(StatisticType.TRIDENTS_HIT.getName(), StatisticType.TRIDENTS_HIT.getNewStatistic());
        statistics.put(StatisticType.TRIDENTS_MISSED.getName(), StatisticType.TRIDENTS_MISSED.getNewStatistic());
        statistics.put(StatisticType.TRIDENTS_THROWN.getName(), StatisticType.TRIDENTS_THROWN.getNewStatistic());
        return statistics;
    }
}
