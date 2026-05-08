package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.block_breaking_tools.BlockBreakingToolCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.OnBrokenBlockResolver;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.logging.Logger;

public class OnBrokenBlockHandler {
    @SubscribeEvent
    public static void listen(BlockEvent.BreakEvent event) {
        if (event.getLevel().isClientSide()) return;

        handle(event);
    }

    private static void handle(BlockEvent.BreakEvent event) {
        ItemStack mainHandItemStack = event.getPlayer().getMainHandItem();
        Core<?> statistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);
        if (!(statistics instanceof BlockBreakingToolCore)) return;

        Core<?> updatedStatistics = OnBrokenBlockResolver.resolve(event, statistics);
        if (updatedStatistics == null) return;

        EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, updatedStatistics);
        Logger.getGlobal().info("Statistics has been updated: " + updatedStatistics.toMap().toString());
    }
}
