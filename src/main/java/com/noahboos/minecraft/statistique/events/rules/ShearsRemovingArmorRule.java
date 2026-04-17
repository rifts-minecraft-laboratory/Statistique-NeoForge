package com.noahboos.minecraft.statistique.events.rules;

import com.noahboos.minecraft.statistique.components.definitions.statistics.Core;
import com.noahboos.minecraft.statistique.components.definitions.statistics.StatisticType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.wolf.Wolf;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.List;

public class ShearsRemovingArmorRule implements ActionRule<PlayerInteractEvent.EntityInteract> {
    public static final List<EntityType<?>> TARGETS = List.of(
        EntityType.WOLF
    );

    @Override
    public boolean matches(PlayerInteractEvent.EntityInteract event, Core statistics) {
        ItemStack mainHandItemStack = event.getEntity().getMainHandItem();
        EntityType<?> entityType = event.getTarget().getType();

        if (!(mainHandItemStack.getItem() instanceof ShearsItem)) return false;
        if (!mainHandItemStack.canPerformAction(ItemAbilities.SHEARS_REMOVE_ARMOR)) return false;
        if (!TARGETS.contains(entityType)) return false;
        if (event.getTarget() instanceof Wolf wolf && wolf.getBodyArmorItem().isEmpty()) return false;
        return true;
    }

    @Override
    public Core apply(Core statistics) {
        return statistics
            .incrementStatistic(StatisticType.REALIZED_SECONDARY_ACTIONS.getName(), 1)
            .incrementStatistic(StatisticType.REMOVED_ARMOR.getName(), 1);
    }
}