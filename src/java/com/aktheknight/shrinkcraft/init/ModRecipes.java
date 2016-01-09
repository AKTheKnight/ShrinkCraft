package com.aktheknight.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
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
		GameRegistry.addRecipe(new ItemStack(ModItems.redGem), "###", "#$#", "###", '#', Items.redstone, '$', ModBlocks.shrinkBlock);
		GameRegistry.addRecipe(new ItemStack(ModItems.basicShrinker), "#", "$", "$", '#', ModItems.redGem, '$', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ModItems.advancedShrinker), "###", "#$#", "###", '#', ModBlocks.shrinkBlock, '$', ModItems.basicShrinker);
		//Blocks
		GameRegistry.addRecipe(new ItemStack(ModBlocks.shrinkBlock), "###", "###", "###", '#', ModItems.shrinkGem);
	}
}
