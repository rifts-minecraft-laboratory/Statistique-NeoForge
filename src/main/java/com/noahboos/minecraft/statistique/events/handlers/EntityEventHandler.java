package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.BlockBreakingToolCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.ActionResolver;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.logging.Logger;

public class EntityEventHandler {
    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.getEntity().level().isClientSide()) return;

        ItemStack mainHandItemStack = event.getEntity().getMainHandItem();
        Core statistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);

        if (!(statistics instanceof BlockBreakingToolCore)) return;

        Core updatedStatistics = ActionResolver.resolve(event, statistics);
        EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, updatedStatistics);
        Logger.getGlobal().info("Statistics has been updated: " + updatedStatistics.toMap().toString());
    }
}
