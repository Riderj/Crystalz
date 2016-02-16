package riderj.crystalz.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class Utils {
	
	public static Item toItem(Block block){
		return Item.getItemFromBlock(block);
	}
	
	public static ToolMaterial addCrystalMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability){
		
		return EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
	}
}
