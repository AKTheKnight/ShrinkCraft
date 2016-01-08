//TEMP NAME OBVIOUSLY
package com.aktheknight.items;

import com.aktheknight.shrinkcraft.ShrinkCraft;
import com.aktheknight.shrinkcraft.Util;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BasicShrinker extends Item {
	
	public String unlocalizedName = "basicShrinker";
	
	public BasicShrinker() {
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
		setTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
	}
	
	private boolean hasBlock(NBTTagCompound comp) {
		if (comp != null && comp.hasKey("block")) {
			return true;
		}
		return false;
	}
	
	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (world.isRemote == false) {
            NBTTagCompound comp = stack.getTagCompound();
            if (hasBlock(comp)) {
                placeBlock(stack, player, world, x, y, z, side);
            }
            else {
                pickupBlock(stack, player, world, x, y, z);
            }
            return true;
        }
        return false;
    }
	
	private void placeBlock(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side) {
        int xPlace = x + ForgeDirection.getOrientation(side).offsetX;
        int yPlace = y + ForgeDirection.getOrientation(side).offsetY;
        int zPlace = z + ForgeDirection.getOrientation(side).offsetZ;
        NBTTagCompound tagComp = stack.getTagCompound();
        int blockID = tagComp.getInteger("block");
        Block block = (Block) Block.blockRegistry.getObjectById(blockID);
        int meta = tagComp.getInteger("meta");

        world.setBlock(xPlace, yPlace, zPlace, block, meta, 3);
        world.setBlockMetadataWithNotify(xPlace, yPlace, zPlace, meta, 3);
        if (tagComp.hasKey("tedata")) {
            NBTTagCompound tagCompBlock = (NBTTagCompound) tagComp.getTag("tedata");
            TileEntity tileEntity = world.getTileEntity(xPlace, yPlace, zPlace);
            if (tileEntity != null) {
            	tagCompBlock.setInteger("x", xPlace);
            	tagCompBlock.setInteger("y", yPlace);
            	tagCompBlock.setInteger("z", zPlace);
                tileEntity.readFromNBT(tagCompBlock);
                tileEntity.markDirty();
                world.markBlockForUpdate(xPlace, yPlace, zPlace); 
            }
        }

        tagComp.removeTag("block");
        tagComp.removeTag("tiledata");
        tagComp.removeTag("meta");
        stack.setTagCompound(tagComp);
    }

    private void pickupBlock(ItemStack stack, EntityPlayer player, World world, int x, int y, int z) {
    	TileEntity tileEntity = world.getTileEntity(x, y, z);
    	if (tileEntity != null) {
    		Util.error(player, "Sorry you can't pick that up with a Basic Shrinker :(");
    		return;
    	}
    	Block block = world.getBlock(x, y, z);
    	int meta = world.getBlockMetadata(x, y, z);
        NBTTagCompound tagCompound = Util.getTags(stack);
        String blockName = Util.getBlockName(block, meta);
        if (blockName != null) {
        	int id = Block.blockRegistry.getIDForObject(block);
            tagCompound.setInteger("block", id);
            tagCompound.setInteger("meta", meta);
            world.setBlockToAir(x, y, z);

            Util.notify(player, "Picked up: " + blockName);
        } 
        else {
        	Util.error(player, "You cannot select this block!");
        }
    }
	
}
