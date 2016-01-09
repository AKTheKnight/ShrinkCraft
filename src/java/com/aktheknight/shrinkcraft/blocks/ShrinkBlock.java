package com.aktheknight.shrinkcraft.blocks;

import com.aktheknight.shrinkcraft.ShrinkCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ShrinkBlock extends Block {
	
	public String unlocalizedName = "shrinkBlock";
	
	private int meta;
	
	public ShrinkBlock(Material mat, int meta) {
		super(mat);
		this.meta = meta;
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(4);
	}
	
	public ShrinkBlock(Material mat) {
		this(mat, 0);
	}
}
