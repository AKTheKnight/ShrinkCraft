package com.aktheknight.shrinkcraft.items;

import com.aktheknight.shrinkcraft.ShrinkCraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ShrinkShard extends Item {
	
	public String unlocalizedName = "shrinkShard";
	
	public ShrinkShard() {
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
		setTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
	}

}
