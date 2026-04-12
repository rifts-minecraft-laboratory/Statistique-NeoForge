package com.noahboos.minecraft.statistique.events.rules.secondary_action;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import net.neoforged.neoforge.event.level.BlockEvent;

public interface SecondaryActionRule {
    boolean matches(BlockEvent.BlockToolModificationEvent event, Core statistics);
    Core apply(Core statistics);
}
