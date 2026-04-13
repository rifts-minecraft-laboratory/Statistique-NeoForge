package com.noahboos.minecraft.statistique.events.rules.secondary_action;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class ShovelDousingRule implements SecondaryActionRule<BlockEvent.BlockToolModificationEvent> {
    public static final List<Block> DOUSEABLE_BLOCKS = List.of(
        Blocks.CAMPFIRE,
        Blocks.SOUL_CAMPFIRE
    );

    @Override
    public boolean matches(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        if (!(event.getHeldItemStack().getItem() instanceof ShovelItem)) return false;
        if (!ItemAbilities.SHOVEL_DOUSE.equals(event.getItemAbility())) return false;
        if (!DOUSEABLE_BLOCKS.contains(event.getState().getBlock())) return false;
        if (!event.getState().getValue(BlockStateProperties.LIT)) return false;
        return true;
    }

    @Override
    public Core apply(Core statistics) {
        return statistics
            .incrementStatistic(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), 1)
            .incrementStatistic(StatisticType.DOUSED_FIRES.getName(), 1);
    }
}
