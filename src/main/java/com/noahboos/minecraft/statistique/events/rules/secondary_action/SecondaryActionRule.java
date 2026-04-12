package com.noahboos.minecraft.statistique.events.rules.secondary_action;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;

public interface SecondaryActionRule<E> {
    boolean matches(E event, Core statistics);
    Core apply(Core statistics);
}
