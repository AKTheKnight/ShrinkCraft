//TEMP NAME OBVIOUSLY
package com.aktheknight.shrinkcraft.items;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aktheknight.shrinkcraft.ShrinkCraft;
import com.aktheknight.shrinkcraft.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class MobShrinker extends Item {
	
	public String unlocalizedName = "mobShrinker";
	
	public static Logger LOGGER = LogManager.getLogger(ShrinkCraft.MODID);
	
	public MobShrinker() {
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(unlocalizedName);
		setTextureName(ShrinkCraft.MODID + ":" + unlocalizedName);
	}
	
	private boolean hasEntity(NBTTagCompound comp) {
		if (comp != null) {
			LOGGER.log(Level.INFO, comp.toString());
		}
		else if (comp == null) {
			LOGGER.log(Level.INFO, "Comp is null");
		}
		
		if (comp != null && comp.getBoolean("hasEntity") == true) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target){
		if (Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode == true) {
			Util.error(player, "Sorry this can't be used in creative mode :P");
			return false;
		}
		if(!target.worldObj.isRemote){
			LOGGER.log(Level.INFO, "Ran itemInteractionForEntity");
			if (target instanceof EntityLivingBase) {
				NBTTagCompound comp = stack.getTagCompound();
				LOGGER.log(Level.INFO, "Interacted with: " + target.getEntityId());
				if (!hasEntity(comp)) {
					LOGGER.log(Level.INFO, "Gonna pickup some entity");
					pickupEntity(stack, target, player);
					comp = stack.getTagCompound();
					comp.setBoolean("hasEntity", true);
					stack.setTagCompound(comp);
					LOGGER.log(Level.INFO, stack.getTagCompound().toString());
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (Minecraft.getMinecraft().thePlayer.capabilities.isCreativeMode == true) {
			Util.error(player, "Sorry this can't be used in creative mode :P");
			return false;
		}
		if (!world.isRemote) {
			LOGGER.log(Level.INFO, "Ran onItemUseFirst");
			NBTTagCompound comp = stack.getTagCompound();
			if (comp == null) {
				return false;
			}
			if (hasEntity(comp) == true) {
				placeEntity(stack, player, world, x, y ,z, side);
				comp.setBoolean("hasEntity", false);
				return true; 
			}
		}
		return false; 
    } 
	
	private void pickupEntity(ItemStack stack, EntityLivingBase entity, EntityPlayer player) {
		NBTTagCompound comp = Util.getTags(stack);
		entity.writeToNBT(comp);
		comp.setString("id", EntityList.getEntityString(entity));
		LOGGER.log(Level.INFO, comp.toString());
		entity.setDead();
		LOGGER.log(Level.INFO, "Picked up entity: " + entity.getEntityId());
		stack.setTagCompound(comp);
		LOGGER.log(Level.INFO, stack.getTagCompound().toString());
		return;
	}
	
	private void placeEntity(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side) {
		Entity entity = EntityList.createEntityFromNBT(stack.getTagCompound(), world);
		int id = entity.getEntityId();
		LOGGER.log(Level.INFO, "Attempting to spawn entity: " + id + ". At: [" + x + ", " + y + ", " + z + "] side: " + side);
		switch (side) {
		case 0:
			entity.setPosition(x, y-2, z);
			break;
		case 1:
			entity.setPosition(x, y+1, z);
			break;
		case 2:
			entity.setPosition(x, y, z-1);
			break;
		case 3:
			entity.setPosition(x, y, z+2);
			break;
		case 4:
			entity.setPosition(x-1, y, z);
			break;
		case 5:
			entity.setPosition(x+2, y, z);
			break;
		}
		world.spawnEntityInWorld(entity);
    }	
	
}
