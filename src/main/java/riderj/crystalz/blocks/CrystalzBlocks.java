package riderj.crystalz.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import riderj.crystalz.items.BloodCrystal;
import riderj.crystalz.items.ElementalCrystal;
import riderj.crystalz.items.EnergyCrystal;
import riderj.crystalz.items.IceCrystal;
import riderj.crystalz.utils.Reference;

public class CrystalzBlocks {
	public static void init(){
		registerBlocks();
	}
	
	public static void registerBlocks(){
	}
	
	public static void registerBlocks(Block block){
		
		GameRegistry.registerBlock(block, block.getRegistryName());
	}
	
	public static void registerRenders(){
	}
	
	public static void renderBlocks(Block block){
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MODID+":"+block.getRegistryName()));
	}
}
