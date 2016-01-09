package com.aktheknight.shrinkcraft.items;

import com.aktheknight.shrinkcraft.ShrinkCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ShrinkGem extends Item {
	
	public String unlocalizedName = "shrinkGem";
	
	public ShrinkGem() {
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
		setTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
	}

}
