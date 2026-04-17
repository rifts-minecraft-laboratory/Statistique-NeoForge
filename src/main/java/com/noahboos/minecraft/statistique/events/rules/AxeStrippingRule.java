package com.noahboos.minecraft.statistique.events.rules;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class AxeStrippingRule implements ActionRule<BlockEvent.BlockToolModificationEvent> {
    public static final List<Block> TARGETS = List.of(
        Blocks.ACACIA_LOG,
        Blocks.BIRCH_LOG,
        Blocks.CHERRY_LOG,
        Blocks.CRIMSON_STEM,
        Blocks.DARK_OAK_LOG,
        Blocks.JUNGLE_LOG,
        Blocks.MANGROVE_LOG,
        Blocks.OAK_LOG,
        Blocks.PALE_OAK_LOG,
        Blocks.SPRUCE_LOG,
        Blocks.WARPED_STEM
    );

    @Override
    public boolean matches(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        if (!(event.getHeldItemStack().getItem() instanceof AxeItem)) return false;
        if (!ItemAbilities.AXE_STRIP.equals(event.getItemAbility())) return false;
        if (!TARGETS.contains(event.getState().getBlock())) return false;
        return true;
    }

    @Override
    public Core apply(Core statistics) {
        return statistics
            .incrementStatistic(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), 1)
            .incrementStatistic(StatisticType.STRIPPED_LOGS.getName(), 1);
    }
}
