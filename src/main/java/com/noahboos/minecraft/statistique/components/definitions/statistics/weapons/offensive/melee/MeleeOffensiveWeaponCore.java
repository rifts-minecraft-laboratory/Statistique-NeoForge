package com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.melee;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Statistic;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;

import java.util.HashMap;
import java.util.Map;

public abstract class MeleeOffensiveWeaponCore<T extends MeleeOffensiveWeaponCore<T>> extends OffensiveWeaponCore<T> {
    protected MeleeOffensiveWeaponCore(Map<String, Statistic> statistics) {
        super(statistics);
    }

    public MeleeOffensiveWeaponCore() {
        super();
    }

    @Override
    protected Map<String, Statistic> getDefaultStatistics() {
        Map<String, Statistic> statistics = new HashMap<>(super.getDefaultStatistics());
        // Common statistics of the melee offensive weapon will be added here. None for now. :3
        return statistics;
    }
}
