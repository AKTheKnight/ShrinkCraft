package com.aktheknight.shrinkcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ShrinkShard extends Item {
	
	public String unlocalizedName = "ShrinkShard";
	
	public ShrinkShard() {
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(unlocalizedName);
		setTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
	}

}
