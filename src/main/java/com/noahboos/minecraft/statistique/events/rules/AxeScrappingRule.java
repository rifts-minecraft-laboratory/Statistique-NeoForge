package com.noahboos.minecraft.statistique.events.rules;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class AxeScrappingRule implements ActionRule<BlockEvent.BlockToolModificationEvent> {
    public static final List<Block> SCRAPPABLE_BLOCKS = List.of(
        Blocks.EXPOSED_COPPER,
        Blocks.WEATHERED_COPPER,
        Blocks.OXIDIZED_COPPER,

        Blocks.EXPOSED_CUT_COPPER,
        Blocks.WEATHERED_CUT_COPPER,
        Blocks.OXIDIZED_CUT_COPPER,

        Blocks.EXPOSED_CUT_COPPER_STAIRS,
        Blocks.WEATHERED_CUT_COPPER_STAIRS,
        Blocks.OXIDIZED_CUT_COPPER_STAIRS,

        Blocks.EXPOSED_CUT_COPPER_SLAB,
        Blocks.WEATHERED_CUT_COPPER_SLAB,
        Blocks.OXIDIZED_CUT_COPPER_SLAB,

        Blocks.EXPOSED_CHISELED_COPPER,
        Blocks.WEATHERED_CHISELED_COPPER,
        Blocks.OXIDIZED_CHISELED_COPPER,

        Blocks.EXPOSED_COPPER_DOOR,
        Blocks.WEATHERED_COPPER_DOOR,
        Blocks.OXIDIZED_COPPER_DOOR,

        Blocks.EXPOSED_COPPER_TRAPDOOR,
        Blocks.WEATHERED_COPPER_TRAPDOOR,
        Blocks.OXIDIZED_COPPER_TRAPDOOR,

        Blocks.EXPOSED_COPPER_GRATE,
        Blocks.WEATHERED_COPPER_GRATE,
        Blocks.OXIDIZED_COPPER_GRATE,

        Blocks.EXPOSED_COPPER_BULB,
        Blocks.WEATHERED_COPPER_BULB,
        Blocks.OXIDIZED_COPPER_BULB
    );

    @Override
    public boolean matches(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        if (!(event.getHeldItemStack().getItem() instanceof AxeItem)) return false;
        if (!ItemAbilities.AXE_SCRAPE.equals(event.getItemAbility())) return false;
        if (!SCRAPPABLE_BLOCKS.contains(event.getState().getBlock())) return false;
        return true;
    }

    @Override
    public Core apply(Core statistics) {
        return statistics
            .incrementStatistic(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), 1)
            .incrementStatistic(StatisticType.SCRAPPED_BLOCKS.getName(), 1);
    }
}
