package com.aktheknight.shrinkcraft;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class Util {
	public static void error(EntityPlayer player, String msg) {
		player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + msg));
	}
	
	public static void notify(EntityPlayer player, String msg) {
		player.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + msg));
	}
	
	public static String getBlockName(Block block, int meta) {
        ItemStack stack = new ItemStack(block,1,meta);
        if (stack.getItem() == null) {
            return null;
        }
        return stack.getDisplayName();
    }
	
	public static NBTTagCompound getTags(ItemStack stack) {
        NBTTagCompound tagComp = stack.getTagCompound();
        if (tagComp == null){
            tagComp = new NBTTagCompound();
            stack.setTagCompound(tagComp);
        }
        return tagComp;
    }
}
