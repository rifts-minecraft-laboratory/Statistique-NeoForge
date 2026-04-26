package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class OnEntityHurtResolver {
    public static Core<?> resolveAsAttacker(LivingDamageEvent.Post event, Core<?> statistics) {
        if (!(statistics instanceof OffensiveWeaponCore<?> _statistics)) return statistics;

        float damage = Math.round(event.getOriginalDamage() * 2.0f) / 2.0f;
        _statistics = _statistics.incrementStatistic(StatisticType.DAMAGE_DEALT.getName(), damage);

        return _statistics;
    }
}
