package com.aktheknight.shrinkcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;

public final class ModBlocks {
	
	public static Block ShrinkOre;

    public static final void init() {
    	GameRegistry.registerBlock(ShrinkOre = new ShrinkOre(Material.rock, ModItems.ShrinkShard, 2, 4), "testingOre");
    	
    }

}
