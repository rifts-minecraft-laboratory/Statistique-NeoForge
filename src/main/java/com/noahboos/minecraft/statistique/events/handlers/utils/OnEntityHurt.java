package com.noahboos.minecraft.statistique.events.handlers.utils;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.defensive.DefensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.OnEntityHurtResolver;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.logging.Logger;

public class OnEntityHurt {
    public static void processAttacker(LivingDamageEvent.Post event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        ItemStack weapon = event.getSource().getWeaponItem();

        ItemStack mainHandItemStack = attacker.getMainHandItem();
        Core<?> mainHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);
        boolean isMainHandOffensiveWeapon = weapon != null && weapon.is(mainHandItemStack.getItem());

        if (isMainHandOffensiveWeapon && mainHandStatistics instanceof OffensiveWeaponCore<?>) {
            Core<?> _statistics = OnEntityHurtResolver.resolveAsAttacker(event, mainHandStatistics);
            if (_statistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, _statistics);

                Logger.getGlobal().info("Attacker's main hand statistics has been updated: " + _statistics.toMap().toString());
            }
        }

        ItemStack offHandItemStack = attacker.getOffhandItem();
        Core<?> offHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(offHandItemStack);
        boolean isOffHandOffensiveWeapon = weapon != null && weapon.is(offHandItemStack.getItem());

        if (isOffHandOffensiveWeapon && offHandStatistics instanceof OffensiveWeaponCore<?>) {
            Core<?> _statistics = OnEntityHurtResolver.resolveAsAttacker(event, offHandStatistics);
            if (_statistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(offHandItemStack, _statistics);

                Logger.getGlobal().info("Attacker's off hand statistics has been updated: " + _statistics.toMap().toString());
            }
        }
    }

    public static void processVictim(LivingDamageEvent.Post event) {
        LivingEntity victim = event.getEntity();

        ItemStack mainHandItemStack = victim.getMainHandItem();
        Core<?> mainHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);
        boolean isMainHandDefensiveWeapon = mainHandStatistics instanceof DefensiveWeaponCore<?>;

        if (isMainHandDefensiveWeapon) {
            Core<?> _statistics = OnEntityHurtResolver.resolveAsVictim(event, mainHandStatistics);
            if (_statistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, _statistics);

                Logger.getGlobal().info("Victim's main hand statistics has been updated: " + _statistics.toMap().toString());
            }
        }

        ItemStack offHandItemStack = victim.getOffhandItem();
        Core<?> offHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(offHandItemStack);
        boolean isOffHandDefensiveWeapon = offHandStatistics instanceof DefensiveWeaponCore<?>;

        if (!isMainHandDefensiveWeapon && isOffHandDefensiveWeapon) {
            Core<?> _statistics = OnEntityHurtResolver.resolveAsVictim(event, offHandStatistics);
            if (_statistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(offHandItemStack, _statistics);

                Logger.getGlobal().info("Victim's off hand statistics has been updated: " + _statistics.toMap().toString());
            }
        }
    }
}
