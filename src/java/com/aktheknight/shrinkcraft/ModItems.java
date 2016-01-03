package com.aktheknight.shrinkcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	
	public static Item ShrinkShard;
	
	public static final void init() {
		ShrinkShard = new ShrinkShard();
		GameRegistry.registerItem(ShrinkShard, "ShrinkShard");
	}
}
