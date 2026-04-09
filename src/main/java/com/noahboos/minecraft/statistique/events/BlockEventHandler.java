package com.noahboos.minecraft.statistique.events;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.ToolCore;
import com.noahboos.minecraft.statistique.components.utils.statistics.EquipmentComponentMapper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;

public class BlockEventHandler {
    @SubscribeEvent
    public static void onBlockDropped(BlockDropsEvent event) {
        if (event.getLevel().isClientSide()) return;
        if (!(event.getBreaker() instanceof Player player)) return;

        ItemStack mainHandItemStack = player.getMainHandItem();
        Core statistics = EquipmentComponentMapper.getStatisticsFromItem(mainHandItemStack);

        if (!(statistics instanceof ToolCore)) return;

        Core updatedStatistics = statistics.incrementStatistic(StatisticType.MINED_BLOCKS.getName(), 1);
        EquipmentComponentMapper.setStatisticsToItem(mainHandItemStack, updatedStatistics);
    }
}
