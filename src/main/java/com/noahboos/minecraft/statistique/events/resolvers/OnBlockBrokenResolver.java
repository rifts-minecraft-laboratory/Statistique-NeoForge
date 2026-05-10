package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.components.definitions.statistics.tools.block_breaking.BlockBreakingToolCore;
import net.neoforged.neoforge.event.level.BlockEvent;

public class OnBlockBrokenResolver {
    public static Core<?> resolve(BlockEvent.BreakEvent event, Core<?> statistics) {
        if (!(statistics instanceof BlockBreakingToolCore<?> _statistics)) return statistics;

        _statistics = _statistics.incrementStatistic(StatisticType.BLOCKS_BROKEN.getName(), 1);

        return _statistics;
    }
}
