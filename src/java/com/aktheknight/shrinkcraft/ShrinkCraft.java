package com.aktheknight.shrinkcraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aktheknight.init.ModBlocks;
import com.aktheknight.init.ModItems;
import com.aktheknight.init.ModRecipes;
import com.aktheknight.init.ModWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=ShrinkCraft.MODID, name=ShrinkCraft.MODNAME, version=ShrinkCraft.VERSION)

public class ShrinkCraft {
	public static final String MODID = "ShrinkCraft";
	public static final String MODNAME = "ShrinkCraft";
	public static final String VERSION = "1.7.10-1.0.1";
	
	@Mod.Instance
	public static ShrinkCraft instance;
	
	public static Logger LOGGER = LogManager.getLogger(MODID);
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent e) {
	    GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
	    ModRecipes.init();
//		MinecraftForge.addGrassSeed(new ItemStack(ModItems.shrinkShard), 4);
	}
}
