package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.events.rules.*;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class ActionResolver {
    private static final List<ActionRule<BlockEvent.BreakEvent>> BROKEN_BLOCK_RULES = List.of(
        new ShearsTripwireDisarmingRule()
    );

    private static final List<ActionRule<PlayerInteractEvent.EntityInteract>> ENTITY_INTERACT_RULES = List.of(
        new ShearsWolfRemovingArmorRule(),
        new ShearsSheepShearingRule()
    );

    private static final List<ActionRule<BlockEvent.BlockToolModificationEvent>> MODIFIED_BLOCK_RULES = List.of(
        new AxeCopperDewaxingRule(),
        new AxeCopperScrappingRule(),
        new AxeLogStrippingRule(),
        new HoeSoilTillingRule(),
        new ShovelCampfireDousingRule(),
        new ShovelFlatteningRule()
    );

    private static final List<ActionRule<PlayerInteractEvent.RightClickBlock>> RIGHT_CLICKED_BLOCK_RULES = List.of(
        new ShearsPumpkinCarvingRule(),
        new ShearsHarvestingRule(),
        new ShearsTrimmingRule()
    );

    public static Core resolve(BlockEvent.BreakEvent event, Core statistics) {
        return processResolve(event, statistics, BROKEN_BLOCK_RULES);
    }

    public static Core resolve(PlayerInteractEvent.EntityInteract event, Core statistics) {
        return processResolve(event, statistics, ENTITY_INTERACT_RULES);
    }

    public static Core resolve(BlockEvent.BlockToolModificationEvent event, Core statistics) {
        return processResolve(event, statistics, MODIFIED_BLOCK_RULES);
    }

    public static Core resolve(PlayerInteractEvent.RightClickBlock event, Core statistics) {
        return processResolve(event, statistics, RIGHT_CLICKED_BLOCK_RULES);
    }

    private static <Event> Core processResolve(Event event, Core statistics, List<ActionRule<Event>> rules) {
        Core updatedStatistics = statistics;
        boolean resolved = false;

        for (ActionRule<Event> rule : rules) {
            if (rule.matches(event, updatedStatistics)) {
                updatedStatistics = rule.apply(updatedStatistics);
                resolved = true;
            }
        }

        return resolved ? updatedStatistics : null;
    }
}
