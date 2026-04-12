package com.noahboos.minecraft.statistique.events.rules.secondary_action;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class ShovelPathingRule implements SecondaryActionRule<BlockEvent.BlockToolModificationEvent> {
    public static final List<Block> PATHABLE_BLOCKS = List.of(
        Blocks.DIRT,
        Blocks.GRASS_BLOCK,
        Blocks.PODZOL,
        Blocks.COARSE_DIRT,
        Blocks.MYCELIUM,
        Blocks.ROOTED_DIRT
    );

    @Override
    public boolean matches(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        if (!(event.getHeldItemStack().getItem() instanceof ShovelItem)) return false;
        if (!ItemAbilities.SHOVEL_FLATTEN.equals(event.getItemAbility())) return false;
        if (!PATHABLE_BLOCKS.contains(event.getState().getBlock())) return false;
        return true;
    }

    @Override
    public Core apply(Core statistics) {
        return statistics
            .incrementStatistic(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), 1)
            .incrementStatistic(StatisticType.PATHED_BLOCKS.getName(), 1);
    }
}
