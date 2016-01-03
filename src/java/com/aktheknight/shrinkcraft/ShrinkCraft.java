package com.aktheknight.shrinkcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=ShrinkCraft.MODID, name=ShrinkCraft.MODNAME, version=ShrinkCraft.VERSION)

public class ShrinkCraft {
	public static final String MODID = "ShrinkCraft";
	public static final String MODNAME = "ShrinkCraft";
	public static final String VERSION = "1.7.10-1.0.0";
	
	@Mod.Instance
	public static ShrinkCraft instance;
	
	public static Logger LOGGER = LogManager.getLogger(MODID);
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
	}
}
