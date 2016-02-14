package riderj.crystalz.utils.proxies;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import riderj.crystalz.Crystalz;
import riderj.crystalz.blocks.CrystalzBlocks;
import riderj.crystalz.client.gui.CrystalzGuiHandler;
import riderj.crystalz.items.CrystalzItems;
import riderj.crystalz.utils.events.LivingEventHandler;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event){
		CrystalzItems.init();
		CrystalzBlocks.init();
	}
	
	
	public void init(FMLInitializationEvent event){
		
		//Handling
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(Crystalz.instance, new CrystalzGuiHandler());
	}
	
	
	public void postInit(FMLPostInitializationEvent event){

		
	}
}
