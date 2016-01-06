package com.aktheknight.shrinkcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class ModRecipes {
	
	public static void init() {
		shapeless();
		shaped();
	}
	
	private static void shapeless() {
		
	}
	
	private static void shaped() {
		//Items
		GameRegistry.addRecipe(new ItemStack(ModItems.shrinkGem), "##", "##", '#', ModItems.shrinkShard);
		//Blocks
		GameRegistry.addRecipe(new ItemStack(ModBlocks.shrinkBlock), "###", "###", "###", '#', ModItems.shrinkGem);
	}
}
