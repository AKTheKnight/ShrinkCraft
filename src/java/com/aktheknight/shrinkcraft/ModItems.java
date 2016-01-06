package com.aktheknight.shrinkcraft;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	
	public static Item shrinkGem;
	public static Item shrinkShard;
	
	public static final void init() {
		shrinkGem = new ShrinkGem();
		GameRegistry.registerItem(shrinkGem, "shrinkGem");
		shrinkShard = new ShrinkShard();
		GameRegistry.registerItem(shrinkShard, "shrinkShard");
	}
}
