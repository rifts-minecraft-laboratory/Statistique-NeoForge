package com.noahboos.minecraft.statistique.events.resolvers;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import com.noahboos.minecraft.statistique.events.rules.*;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.List;

public class ActionResolver {
    private static final List<ActionRule<BlockEvent.BreakEvent>> BROKEN_BLOCK_RULES = List.of(
        // Rules here.
    );

    private static final List<ActionRule<LivingDamageEvent.Post>> DAMAGED_ENTITY_RULES = List.of(
        // Rules here.
    );

    public static Core<?> resolve(BlockEvent.BreakEvent event, Core<?> statistics) {
        return processResolve(event, statistics, BROKEN_BLOCK_RULES);
    }

    public static Core<?> resolve(LivingDamageEvent.Post event, Core<?> statistics) {
        return processResolve(event, statistics, DAMAGED_ENTITY_RULES);
    }

    private static <Event> Core<?> processResolve(Event event, Core<?> statistics, List<ActionRule<Event>> rules) {
        Core<?> updatedStatistics = statistics;

        if (event instanceof BlockEvent.BreakEvent) {
            updatedStatistics = updatedStatistics.incrementStatistic(StatisticType.BROKEN_BLOCKS.getName(), 1);
        }
        if (event instanceof LivingDamageEvent.Post) {
            float damage = Math.round(((LivingDamageEvent.Post) event).getOriginalDamage() * 2.0f) / 2.0f;
            updatedStatistics = updatedStatistics.incrementStatistic(StatisticType.DAMAGE_DEALT.getName(), damage);
        }

        for (ActionRule<Event> rule : rules) {
            if (rule.matches(event, updatedStatistics)) {
                updatedStatistics = rule.apply(updatedStatistics);
            }
        }

        return updatedStatistics;
    }
}
