package com.noahboos.minecraft.statistique.events.rules;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;

public interface ActionRule<E> {
    boolean matches(E event, Core statistics);
    Core apply(Core statistics);
}
