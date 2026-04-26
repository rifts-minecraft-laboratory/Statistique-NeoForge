package com.noahboos.minecraft.statistique.events.handlers.utils;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.ActionResolver;
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
        boolean isMainHandWeapon = weapon != null && weapon.is(mainHandItemStack.getItem());

        if (isMainHandWeapon && mainHandStatistics instanceof OffensiveWeaponCore<?>) {
            Core<?> updatedStatistics = ActionResolver.resolve(event, mainHandStatistics);
            if (updatedStatistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, updatedStatistics);

                Logger.getGlobal().info("Attacker's main hand statistics has been updated: " + updatedStatistics.toMap().toString());
            }
        }

        ItemStack offHandItemStack = attacker.getOffhandItem();
        Core<?> offHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(offHandItemStack);
        boolean isOffHandWeapon = weapon != null && weapon.is(offHandItemStack.getItem());

        if (isOffHandWeapon && offHandStatistics instanceof OffensiveWeaponCore<?>) {
            Core<?> updatedStatistics = ActionResolver.resolve(event, offHandStatistics);
            if (updatedStatistics != null) {
                EquipmentComponentMapper.setStatisticsToItem(offHandItemStack, updatedStatistics);

                Logger.getGlobal().info("Attacker's off hand statistics has been updated: " + updatedStatistics.toMap().toString());
            }
        }
    }

    public static void processVictim(LivingDamageEvent.Post event) {
        // Victim processing will be implemented in this method, yet it is empty. :0
    }
}
