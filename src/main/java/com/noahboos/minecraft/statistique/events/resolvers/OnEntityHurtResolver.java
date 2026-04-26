package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.armors.ArmorCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.DefensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.items.ShieldStatistics;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public class OnEntityHurtResolver {
    public static Core<?> resolveAttackerHand(LivingDamageEvent.Post event, Core<?> statistics) {
        if (!(statistics instanceof OffensiveWeaponCore<?> _statistics)) return statistics;

        float damage = Math.round(event.getOriginalDamage() * 2.0f) / 2.0f;
        _statistics = _statistics.incrementStatistic(StatisticType.DAMAGE_DEALT.getName(), damage);

        return _statistics;
    }

    public static Core<?> resolveVictimHand(LivingDamageEvent.Post event, Core<?> statistics) {
        if (!(statistics instanceof DefensiveWeaponCore<?> _statistics)) return statistics;

        if (_statistics instanceof ShieldStatistics) {
            float blockedDamage = Math.round(event.getBlockedDamage() * 2.0f) / 2.0f;
            _statistics = _statistics.incrementStatistic(StatisticType.DAMAGE_BLOCKED.getName(), Math.abs(blockedDamage));
        }

        return _statistics;
    }

    public static Core<?> resolveVictimArmor(LivingDamageEvent.Post event, Core<?> statistics) {
        if (!(statistics instanceof ArmorCore<?> _statistics)) return statistics;

        float damageTaken = Math.round((event.getOriginalDamage() - event.getNewDamage()) * 2.0f) / 2.0f;
        _statistics = _statistics.incrementStatistic(StatisticType.DAMAGE_TAKEN.getName(), Math.abs(damageTaken));

        return _statistics;
    }
}
