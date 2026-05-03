package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.hybride.items.TridentStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.ranged.RangedOffensiveWeaponCore;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.phys.HitResult;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class OnProjectileImpactResolver {
    public static Core<?> resolveProjectileImpact(ProjectileImpactEvent event, Core<?> statistics) {
        if (event.getProjectile() instanceof Arrow) {
            return resolveProjectileAsArrow(event, statistics);
        } else if (event.getProjectile() instanceof ThrownTrident) {
            return resolveProjectileAsThrownTrident(event, statistics);
        }
        return statistics;
    }

    public static Core<?> resolveProjectileAsArrow(ProjectileImpactEvent event, Core<?> statistics) {
        if (!(statistics instanceof RangedOffensiveWeaponCore<?> _statistics)) return statistics;

        _statistics = _statistics.incrementStatistic(StatisticType.ARROWS_SHOT.getName(), 1);

        HitResult hitResult = event.getRayTraceResult();

        if (hitResult.getType() == HitResult.Type.ENTITY) {
            _statistics = _statistics.incrementStatistic(StatisticType.ARROWS_HIT.getName(), 1);
        } else if (hitResult.getType() == HitResult.Type.BLOCK) {
            _statistics = _statistics.incrementStatistic(StatisticType.ARROWS_MISSED.getName(), 1);
        }

        return _statistics;
    }

    public static Core<?> resolveProjectileAsThrownTrident(ProjectileImpactEvent event, Core<?> statistics) {
        if (!(statistics instanceof TridentStatistics _statistics)) return statistics;

        _statistics = _statistics.incrementStatistic(StatisticType.TRIDENTS_THROWN.getName(), 1);

        HitResult hitResult = event.getRayTraceResult();

        if (hitResult.getType() == HitResult.Type.ENTITY) {
            _statistics = _statistics.incrementStatistic(StatisticType.TRIDENTS_HIT.getName(), 1);
        } else if (hitResult.getType() == HitResult.Type.BLOCK) {
            _statistics = _statistics.incrementStatistic(StatisticType.TRIDENTS_MISSED.getName(), 1);
        }

        return _statistics;
    }
}
