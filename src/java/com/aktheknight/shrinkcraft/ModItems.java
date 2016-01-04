package com.aktheknight.shrinkcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	
	public static Item ShrinkGem;
	
	public static final void init() {
		ShrinkGem = new ShrinkGem();
		GameRegistry.registerItem(ShrinkGem, "ShrinkGem");
	}
}
