package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.events.rules.secondary_action.*;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class SecondaryActionResolver {
    private static final List<SecondaryActionRule<BlockEvent.BlockToolModificationEvent>> MODIFIED_BLOCK_RULES = List.of(
        new AxeDewaxingRule(),
        new AxeScrappingRule(),
        new AxeStrippingRule(),
        new HoeTillingRule(),
        new ShovelPathingRule()
    );

    private static final List<SecondaryActionRule<PlayerInteractEvent.RightClickBlock>> RIGHT_CLICKED_BLOCK_RULES = List.of(
        new ShearsHarvestingRule()
    );

    public static Core resolve(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        return processResolve(event, statistics, MODIFIED_BLOCK_RULES);
    }

    public static Core resolve(PlayerInteractEvent.RightClickBlock event, Core statistics) {
        return processResolve(event, statistics, RIGHT_CLICKED_BLOCK_RULES);
    }

    private static <E> Core processResolve(E event, Core statistics, List<SecondaryActionRule<E>> rules) {
        Core updatedStatistics = statistics;
        boolean resolved = false;

        for (SecondaryActionRule<E> rule : rules) {
            if (rule.matches(event, updatedStatistics)) {
                updatedStatistics = rule.apply(updatedStatistics);
                resolved = true;
            }
        }

        return resolved ? updatedStatistics : null;
    }
}
