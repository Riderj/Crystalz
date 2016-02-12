package riderj.crystalz.utils.proxies;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import riderj.crystalz.client.items.CrystalzItems;
import riderj.crystalz.utils.events.LivingEventHandler;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		CrystalzItems.init();
	}
	
	
	public void init(FMLInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
	}
	
	
	public void postInit(FMLPostInitializationEvent event){

		
	}
}
