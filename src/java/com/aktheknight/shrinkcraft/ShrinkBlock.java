package com.aktheknight.shrinkcraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ShrinkBlock extends Block {
	
	public String unlocalizedName = "shrinkBlock";
	
	private int meta;
	
	protected ShrinkBlock(Material mat, int meta) {
		super(mat);
		this.meta = meta;
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(4);
	}
	
	protected ShrinkBlock(Material mat) {
		this(mat, 0);
	}
}
