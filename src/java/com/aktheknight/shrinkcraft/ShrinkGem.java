package com.aktheknight.shrinkcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ShrinkGem extends Item {
	
	public String unlocalizedName = "ShrinkGem";
	
	public ShrinkGem() {
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(unlocalizedName);
		setTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
	}

}
