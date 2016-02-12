package riderj.crystalz.utils.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import riderj.crystalz.items.BloodCrystal;

public class LivingEventHandler {
	int collectiveCharge = 0;
	int crystals = 0;
	
	
	@SubscribeEvent
	public void onLivingEntityHurt(LivingHurtEvent event){
		World world = event.entity.worldObj;
		crystals = 0;
		if(!world.isRemote){
			if(event.source.getSourceOfDamage() instanceof EntityPlayerMP){
				
				EntityPlayer player =  (EntityPlayer) event.source.getSourceOfDamage();
				InventoryPlayer inv = player.inventory;
				for(ItemStack items: inv.mainInventory){
					if(items != null && items.getItem() instanceof BloodCrystal) crystals++;
				}
				System.out.println(event.ammount/crystals);
				for(ItemStack items:inv.mainInventory){
					if(items == null) continue;
					if(items.getItem() instanceof BloodCrystal){
						items.getTagCompound().setInteger("charge", (int)(items.getTagCompound().getInteger("charge")+(event.ammount)/crystals));
					}
				}
			}
			
		}
	}
	
	@SubscribeEvent
	public void onLivingEntityDie(LivingDeathEvent event){
		
		
	}
}
