package com.aktheknight.shrinkcraft.init;

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
		GameRegistry.addRecipe(new ItemStack(ModItems.redGem), "###", "#$#", "###", '#', Items.redstone, '$', ModItems.shrinkGem);
		GameRegistry.addRecipe(new ItemStack(ModItems.basicShrinker), "# #", " $ ", " I ", '#', ModBlocks.shrinkBlock, '$', Items.diamond, 'I', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ModItems.advancedShrinker), "#%#", " & ", " D ", '#', ModBlocks.shrinkBlock, '%', ModItems.basicShrinker, '&', Items.nether_star, 'D', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ModItems.mobShrinker), "#$#", " % ", " & ", '#', Items.leather, '$', ModItems.basicShrinker, '%', Items.egg, '&', Items.iron_ingot);
		//Blocks
		GameRegistry.addRecipe(new ItemStack(ModBlocks.shrinkBlock), "###", "###", "###", '#', ModItems.shrinkGem);
	}
}
