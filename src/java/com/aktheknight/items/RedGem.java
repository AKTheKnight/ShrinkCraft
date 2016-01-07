package com.aktheknight.items;

import com.aktheknight.shrinkcraft.ShrinkCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RedGem extends Item {
	
	public String unlocalizedName = "redGem";
	
	public RedGem() {
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
		setTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
	}

}
