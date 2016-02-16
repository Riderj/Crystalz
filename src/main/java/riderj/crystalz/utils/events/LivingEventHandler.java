package riderj.crystalz.utils.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import riderj.crystalz.items.BloodCrystal;

public class LivingEventHandler {
	int collectiveCharge = 0;
	int crystals = 0;
	double health = -1;
	
	
	
	@SubscribeEvent
	public void onLivingEntityHurt(LivingHurtEvent event){
		
	}
	
	

	
	@SubscribeEvent
	public void onLivingEntityDie(LivingDeathEvent event){
		World world = event.entity.worldObj;
					
			if(event.source.getSourceOfDamage() instanceof EntityPlayerMP){
				NBTTagCompound tagCompound = new NBTTagCompound();
				event.entity.writeToNBT(tagCompound); // Printing just the tagCompound gives the list of what the entity has.
				NBTTagList tagList = tagCompound.getTagList("Attributes", Constants.NBT.TAG_COMPOUND); //Since what we need is in attributes, and it's stored as an array, we need a tag list
				tagCompound = tagList.getCompoundTagAt(0); //The attribute set we need is at index 0
				health = tagCompound.getDouble("Base");

				
				
				
				EntityPlayer player =  (EntityPlayer) event.source.getSourceOfDamage();
				InventoryPlayer inv = player.inventory;
				
				for(ItemStack items: inv.mainInventory){
					if(items != null && items.getItem() instanceof BloodCrystal) crystals++;
				}
				for(ItemStack items:inv.mainInventory){
					if(items == null) continue;
					if(items.getItem() instanceof BloodCrystal){
						items.getTagCompound().setInteger("blood", (int)(items.getTagCompound().getInteger("blood")+(int)(health)/(int)(1+Math.random()*50)));
						
					}
				}
				crystals = 0;
			}
	}
	
	
	
}
