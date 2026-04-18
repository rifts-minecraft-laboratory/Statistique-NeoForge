package com.noahboos.minecraft.statistique.events.handlers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import com.noahboos.minecraft.statistique.events.resolvers.ActionResolver;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.logging.Logger;

public class BlockEventHandler {
    @SubscribeEvent
    public static void onToolModifiedBlock(BlockEvent.BlockToolModificationEvent event) {
        if (event.getLevel().isClientSide()) return;
        if (!(event.getPlayer() instanceof Player player)) return;

        ItemStack mainHandItemStack = player.getMainHandItem();
        Core statistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);
        if (!(statistics instanceof ToolCore)) return;

        Core updatedStatistics = ActionResolver.resolve(event, statistics);
        if (updatedStatistics == null) return;

        EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, updatedStatistics);
        Logger.getGlobal().info("Statistics has been updated: " + updatedStatistics.toMap().toString());
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getLevel().isClientSide()) return;

        Player player = event.getEntity();
        ItemStack mainHandItemStack = player.getMainHandItem();
        Core statistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);
        if (!(statistics instanceof ToolCore)) return;

        Core updatedStatistics = ActionResolver.resolve(event, statistics);
        if (updatedStatistics == null) return;

        EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, updatedStatistics);
        Logger.getGlobal().info("Statistics has been updated: " + updatedStatistics.toMap().toString());
    }

    @SubscribeEvent
    public static void onBrokenBlock(BlockEvent.BreakEvent event) {
        if (event.getLevel().isClientSide()) return;

        ItemStack mainHandItemStack = event.getPlayer().getMainHandItem();
        Core statistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);
        if (!(statistics instanceof ToolCore)) return;

        Core updatedStatistics = ActionResolver.resolve(event, statistics);
        if (updatedStatistics == null) return;

        EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, updatedStatistics);
        Logger.getGlobal().info("Statistics has been updated: " + updatedStatistics.toMap().toString());
    }
}
