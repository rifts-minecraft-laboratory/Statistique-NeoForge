package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.RangedOffensiveWeaponCore;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class OnProjectileImpactResolver {
    public static Core<?> resolveProjectileImpact(ProjectileImpactEvent event, Core<?> statistics) {
        if (!(statistics instanceof RangedOffensiveWeaponCore<?> _statistics)) return statistics;

        _statistics = _statistics.incrementStatistic(StatisticType.TOTAL_SHOT_ARROWS.getName(), 1);

        HitResult hitResult = event.getRayTraceResult();

        if (hitResult.getType() == HitResult.Type.ENTITY) {
            _statistics = _statistics.incrementStatistic(StatisticType.HIT_ARROWS.getName(), 1);
        } else if (hitResult.getType() == HitResult.Type.BLOCK) {
            _statistics = _statistics.incrementStatistic(StatisticType.MISSED_ARROWS.getName(), 1);
        }

        return _statistics;
    }
}
