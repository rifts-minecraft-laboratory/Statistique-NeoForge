package com.noahboos.minecraft.statistique.events.rules;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class AxeDewaxingRule implements ActionRule<BlockEvent.BlockToolModificationEvent> {
    public static final List<Block> TARGETS = List.of(
        Blocks.WAXED_COPPER_BLOCK,
        Blocks.WAXED_EXPOSED_COPPER,
        Blocks.WAXED_WEATHERED_COPPER,
        Blocks.WAXED_OXIDIZED_COPPER,

        Blocks.WAXED_CUT_COPPER,
        Blocks.WAXED_EXPOSED_CUT_COPPER,
        Blocks.WAXED_WEATHERED_CUT_COPPER,
        Blocks.WAXED_OXIDIZED_CUT_COPPER,

        Blocks.WAXED_CUT_COPPER_STAIRS,
        Blocks.WAXED_EXPOSED_CUT_COPPER_STAIRS,
        Blocks.WAXED_WEATHERED_CUT_COPPER_STAIRS,
        Blocks.WAXED_OXIDIZED_CUT_COPPER_STAIRS,

        Blocks.WAXED_CUT_COPPER_SLAB,
        Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB,
        Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB,
        Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB,

        Blocks.WAXED_CHISELED_COPPER,
        Blocks.WAXED_EXPOSED_CHISELED_COPPER,
        Blocks.WAXED_WEATHERED_CHISELED_COPPER,
        Blocks.WAXED_OXIDIZED_CHISELED_COPPER,

        Blocks.WAXED_COPPER_DOOR,
        Blocks.WAXED_EXPOSED_COPPER_DOOR,
        Blocks.WAXED_WEATHERED_COPPER_DOOR,
        Blocks.WAXED_OXIDIZED_COPPER_DOOR,

        Blocks.WAXED_COPPER_TRAPDOOR,
        Blocks.WAXED_EXPOSED_COPPER_TRAPDOOR,
        Blocks.WAXED_WEATHERED_COPPER_TRAPDOOR,
        Blocks.WAXED_OXIDIZED_COPPER_TRAPDOOR,

        Blocks.WAXED_COPPER_GRATE,
        Blocks.WAXED_EXPOSED_COPPER_GRATE,
        Blocks.WAXED_WEATHERED_COPPER_GRATE,
        Blocks.WAXED_OXIDIZED_COPPER_GRATE,

        Blocks.WAXED_COPPER_BULB,
        Blocks.WAXED_EXPOSED_COPPER_BULB,
        Blocks.WAXED_WEATHERED_COPPER_BULB,
        Blocks.WAXED_OXIDIZED_COPPER_BULB
    );

    @Override
    public boolean matches(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        if (!(event.getHeldItemStack().getItem() instanceof AxeItem)) return false;
        if (!ItemAbilities.AXE_WAX_OFF.equals(event.getItemAbility())) return false;
        if (!TARGETS.contains(event.getState().getBlock())) return false;
        return true;
    }

    @Override
    public Core apply(Core statistics) {
        return statistics
            .incrementStatistic(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), 1)
            .incrementStatistic(StatisticType.DEWAXED_BLOCKS.getName(), 1);
    }
}
