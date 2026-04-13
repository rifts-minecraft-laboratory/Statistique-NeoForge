package com.noahboos.minecraft.statistique.events.rules;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;

public interface ActionRule<Event> {
    boolean matches(Event event, Core statistics);
    Core apply(Core statistics);
}
