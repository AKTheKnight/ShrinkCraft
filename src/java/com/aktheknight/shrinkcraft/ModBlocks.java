package com.aktheknight.shrinkcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks {
	
	public static Block shrinkOre;
	public static Block shrinkBlock;

    public static final void init() {
    	GameRegistry.registerBlock(shrinkOre = new ShrinkOre(Material.rock, ModItems.shrinkGem), "shrinkOre");
    	GameRegistry.registerBlock(shrinkBlock = new ShrinkBlock(Material.rock), "shrinkBlock");
    	
    }

}
