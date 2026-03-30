package com.noahboos.minecraft.statistique;

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
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}
