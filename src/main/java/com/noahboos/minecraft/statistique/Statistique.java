package com.noahboos.minecraft.statistique;

import com.noahboos.minecraft.statistique.components.DataComponents;
import com.noahboos.minecraft.statistique.events.handlers.BlockEventHandler;
import com.noahboos.minecraft.statistique.events.handlers.EntityEventHandler;
import com.noahboos.minecraft.statistique.events.handlers.ItemEventHandler;
import com.noahboos.minecraft.statistique.events.handlers.TooltipEventHandler;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;

@Mod(Statistique.MOD_ID)
public class Statistique {
    public static final String MOD_ID = "statistique";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Statistique(IEventBus modEventBus, ModContainer modContainer) {
        DataComponents.COMPONENTS.register(modEventBus);
        NeoForge.EVENT_BUS.register(BlockEventHandler.class);
        NeoForge.EVENT_BUS.register(EntityEventHandler.class);
        NeoForge.EVENT_BUS.register(ItemEventHandler.class);
        NeoForge.EVENT_BUS.register(TooltipEventHandler.class);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
