package riderj.crystalz.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class BloodCrystal extends BaseCrystal {
	public BloodCrystal(){
		super("blood_crystal");
	}
	
	/*
	 * Crystal functionality is also in the LivingEventHandler, the increment is based on entities dying.
	 */
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		if(stack.hasTagCompound()){
			tooltip.add(EnumChatFormatting.DARK_RED+"Blood: "+stack.getTagCompound().getInteger("blood"));
		}
	}
	
}
