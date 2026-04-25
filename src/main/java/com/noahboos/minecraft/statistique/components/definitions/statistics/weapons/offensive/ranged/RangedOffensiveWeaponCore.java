package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;

import java.util.HashMap;
import java.util.Map;

public abstract class RangedOffensiveWeaponCore<T extends RangedOffensiveWeaponCore<T>> extends OffensiveWeaponCore<T> {
    protected RangedOffensiveWeaponCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public RangedOffensiveWeaponCore() {
        super();
    }

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(super.getDefaultStatistics());
        // Common statistics of the ranged offensive weapon will be added here. None for now. :3
        return statistics;
    }
}
