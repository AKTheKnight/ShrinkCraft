package com.aktheknight.init;

import com.aktheknight.items.RedGem;
import com.aktheknight.items.ShrinkGem;
import com.aktheknight.items.ShrinkShard;
import com.aktheknight.items.AdvancedShrinker;
import com.aktheknight.items.BasicShrinker;
import com.aktheknight.items.TestingStick;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	
	public static Item shrinkGem;
	public static Item shrinkShard;
	public static Item redGem;
	public static Item basicShrinker;
	public static Item advancedShrinker;
	
	public static Item testingStick;
	
	public static final void init() {
		shrinkGem = new ShrinkGem();
		GameRegistry.registerItem(shrinkGem, "shrinkGem");
		shrinkShard = new ShrinkShard();
		GameRegistry.registerItem(shrinkShard, "shrinkShard");
		redGem = new RedGem();
		GameRegistry.registerItem(redGem, "redGem");
		basicShrinker = new BasicShrinker();
		GameRegistry.registerItem(basicShrinker, "basicShrinker");
		advancedShrinker = new AdvancedShrinker();
		GameRegistry.registerItem(advancedShrinker, "advancedShrinker");
		
		testingStick = new TestingStick();
		GameRegistry.registerItem(testingStick, "testingStick");
	}
}
