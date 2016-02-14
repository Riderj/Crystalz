package riderj.crystalz.utils.proxies;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import riderj.crystalz.blocks.CrystalzBlocks;
import riderj.crystalz.items.CrystalzItems;
import riderj.crystalz.utils.tabs.CrystalzTabs;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event){
		super.preInit(event);
		CrystalzTabs.init();
		CrystalzItems.registerRenders();
		CrystalzBlocks.registerRenders();
	}
	
	@Override
	public void init(FMLInitializationEvent event){
		super.init(event);
		
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event){
		super.postInit(event);
	}
}
