package com.aktheknight.shrinkcraft;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ShrinkOre extends Block {
	
	public String unlocalizedName = "shrinkOre";
	
	private Item drop;
	private int meta;
	
	protected ShrinkOre(Material mat, Item drop, int meta) {
		super(mat);
		this.drop = drop;
		this.meta = meta;
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(4);
	}
	
	protected ShrinkOre(Material mat, Item drop) {
		this(mat, drop, 0);
	}

	@Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		Item toolUsed = harvesters.get().getCurrentEquippedItem().getItem();
		int harvestLevel = toolUsed.getHarvestLevel(harvesters.get().getCurrentEquippedItem(), "pickaxe");
		if (harvestLevel > 1) {
			return this.drop;
		}
		else {
			return ModItems.shrinkShard;
		}
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

/*	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		if (this.least_quantity >= this.most_quantity) {
			return this.least_quantity;
		}
		return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	} */
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		int least, most;
		Item toolUsed = harvesters.get().getCurrentEquippedItem().getItem();
		int harvestLevel = toolUsed.getHarvestLevel(harvesters.get().getCurrentEquippedItem(), "pickaxe");
		switch(harvestLevel) {
		case 0:
			least = 1;
			most = 3;
			return least + random.nextInt(most - least + fortune);
		case 1:
			least = 2;
			most = 4;
			return least + random.nextInt(most - least + fortune + 1);
		case 2:
			least = 1;
			most = 3;
			return least + random.nextInt(most - least + fortune + 1);
		case 3:
			least = 2;
			most = 4;
			return least + random.nextInt(most - least + fortune + 1);
		default:
			least = 0;
			most = 2;
			return least + random.nextInt(most - least + fortune + 1);
		}
			
			
	}
}
