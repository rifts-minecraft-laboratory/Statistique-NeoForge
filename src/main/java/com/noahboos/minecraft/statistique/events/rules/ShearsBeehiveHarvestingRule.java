package com.noahboos.minecraft.statistique.events.rules;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;

public class ShearsBeehiveHarvestingRule implements ActionRule<PlayerInteractEvent.RightClickBlock> {
    public static final List<Block> TARGETS = List.of(
        Blocks.BEEHIVE,
        Blocks.BEE_NEST
    );

    @Override
    public boolean matches(PlayerInteractEvent.RightClickBlock event, Core statistics) {
        ItemStack mainHandItemStack = event.getEntity().getMainHandItem();
        BlockPos blockPosition = event.getPos();
        BlockState blockState = event.getLevel().getBlockState(blockPosition);

        if (!(mainHandItemStack.getItem() instanceof ShearsItem)) return false;
        if (!mainHandItemStack.canPerformAction(ItemAbilities.SHEARS_HARVEST)) return false;
        if (!TARGETS.contains(blockState.getBlock())) return false;
        if (blockState.getValue(BeehiveBlock.HONEY_LEVEL) == 0) return false;
        return true;
    }

    @Override
    public Core apply(Core statistics) {
        return statistics
            .incrementStatistic(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), 1)
            .incrementStatistic(StatisticType.HARVESTED_BEEHIVES.getName(), 1);
    }
}