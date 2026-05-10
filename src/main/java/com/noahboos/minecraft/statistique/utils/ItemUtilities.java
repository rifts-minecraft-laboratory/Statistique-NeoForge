package com.noahboos.minecraft.statistique.utils;

import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;

public class ItemUtilities {
    public static boolean isBowOrCrossbow(ItemStack itemStack) {
        return itemStack.getItem() instanceof BowItem || itemStack.getItem() instanceof CrossbowItem;
    }
}
