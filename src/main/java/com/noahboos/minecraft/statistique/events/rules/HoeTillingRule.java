package com.noahboos.minecraft.statistique.events.rules;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class HoeTillingRule implements ActionRule<BlockEvent.BlockToolModificationEvent> {
    public static final List<Block> TILLABLE_BLOCKS = List.of(
        Blocks.DIRT,
        Blocks.GRASS_BLOCK
    );

    @Override
    public boolean matches(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        if (!(event.getHeldItemStack().getItem() instanceof HoeItem)) return false;
        if (!ItemAbilities.HOE_TILL.equals(event.getItemAbility())) return false;
        if (!TILLABLE_BLOCKS.contains(event.getState().getBlock())) return false;
        return true;
    }

    @Override
    public Core apply(Core statistics) {
        return statistics
            .incrementStatistic(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), 1)
            .incrementStatistic(StatisticType.TILLED_BLOCKS.getName(), 1);
    }
}
