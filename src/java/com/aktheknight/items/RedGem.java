package com.aktheknight.items;

import com.aktheknight.shrinkcraft.ShrinkCraft;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RedGem extends Item {
	
	public String unlocalizedName = "redGem";
	
	public RedGem() {
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
		setTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
	}
	
	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote == false) {
        	Block above = world.getBlock(x, y+1, z);
            if (side == 1 && above == Blocks.air) {
/*            	if (world.canLightningStrikeAt(x, y+1, z) == true) {
            		EntityLightningBolt Lightning = new EntityLightningBolt(world, 1, 1, 1);
            		Lightning.setPosition(x, y+1, z);
            		world.spawnEntityInWorld(Lightning);
            	}
            	else {
            		world.createExplosion(null, x, y+1, z, 0, true);
            	} */
            	EntityLightningBolt Lightning = new EntityLightningBolt(world, x, y+1, z);
        		world.spawnEntityInWorld(Lightning);
            	world.setBlock(x, y+1, z, Blocks.fire);
            }
        }
        return false;
    }

}
