package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class OnEntityDeathResolver {
    public static Core<?> resolveEntityDisposition(LivingDeathEvent event, Core<?> statistics) {
        if (!(statistics instanceof OffensiveWeaponCore<?> _statistics)) return statistics;

        LivingEntity victim = event.getEntity();

        _statistics = _statistics.incrementStatistic(StatisticType.KILLED_ENTITIES.getName(), 1);

        switch (victim) {
            case Monster monster -> {
                _statistics = _statistics.incrementStatistic(StatisticType.KILLED_HOSTILE_ENTITIES.getName(), 1);
            }
            case NeutralMob neutralMob -> {
                _statistics = _statistics.incrementStatistic(StatisticType.KILLED_NEUTRAL_ENTITIES.getName(), 1);
            }
            case Animal animal -> {
                _statistics = _statistics.incrementStatistic(StatisticType.KILLED_PASSIVE_ENTITIES.getName(), 1);
            }
            default -> {
                // TODO - Could be a good idea to implement the treatment of a "KILLED_OTHER_ENTITIES" statistic.
            }
        }

        return _statistics;
    }

    public static Core<?> resolveEntityType(LivingDeathEvent event, Core<?> statistics) {
        // TODO - Implement the treatment of the statistics based on the entity type.
        return statistics;
    }
}
