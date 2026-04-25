package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.weapons.offensive.OffensiveWeaponCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.ActionResolver;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import java.util.logging.Logger;

public class EntityEventHandler {
    @SubscribeEvent
    public static void onEntityHurt(LivingDamageEvent.Post event) {
        if (event.getEntity().level().isClientSide()) return;

        LivingEntity entity = event.getEntity();
        Entity attacker = event.getSource().getEntity();

        if (attacker instanceof Player player) {
            ItemStack mainHandItemStack = player.getMainHandItem();
            Core mainHandStatistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);

            if (mainHandStatistics instanceof OffensiveWeaponCore<?>) {
                Core updatedStatistics = ActionResolver.resolve(event, mainHandStatistics);
                if (updatedStatistics == null) return;

                EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, updatedStatistics);

                Logger.getGlobal().info("Main hand statistics has been updated: " + updatedStatistics.toMap().toString());
            }
        }
    }
}
