package riderj.crystalz.items;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CrystalzItems {
	
	public static Item elementalCrystal,bloodCrystal,iceCrystal,energyCrystal;
	
	public static void init(){
		elementalCrystal = new ElementalCrystal();
		bloodCrystal = new BloodCrystal();
		iceCrystal = new IceCrystal();
		energyCrystal = new EnergyCrystal();
		registerItems();
	}
	
	public static void registerItems(){
		registerItems(elementalCrystal);
		registerItems(bloodCrystal);
		registerItems(iceCrystal);
		registerItems(energyCrystal);
	}
	
	public static void registerItems(Item item){
		
		GameRegistry.registerItem(item, item.getRegistryName());
	}
	
	public static void registerRenders(){
		renderItems(elementalCrystal);
		renderItems(bloodCrystal);
		renderItems(iceCrystal);
		renderItems(energyCrystal);
	}
	
	public static void renderItems(Item item){

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"+item.getRegistryName());
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(),"inventory"));
	}
	
	
}
