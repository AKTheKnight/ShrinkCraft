package com.aktheknight.shrinkcraft.init;

import com.aktheknight.shrinkcraft.items.AdvancedShrinker;
import com.aktheknight.shrinkcraft.items.BasicShrinker;
import com.aktheknight.shrinkcraft.items.MobShrinker;
import com.aktheknight.shrinkcraft.items.RedGem;
import com.aktheknight.shrinkcraft.items.ShrinkGem;
import com.aktheknight.shrinkcraft.items.ShrinkShard;
import com.aktheknight.shrinkcraft.items.TestingStick;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
	
	public static Item shrinkGem;
	public static Item shrinkShard;
	public static Item redGem;
	public static Item basicShrinker;
	public static Item advancedShrinker;
	public static Item mobShrinker;
	
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
		mobShrinker = new MobShrinker();
		GameRegistry.registerItem(mobShrinker, "mobShrinker");
		
		testingStick = new TestingStick();
		GameRegistry.registerItem(testingStick, "testingStick");
	}
}
