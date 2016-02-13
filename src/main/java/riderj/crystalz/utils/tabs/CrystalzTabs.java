package riderj.crystalz.utils.tabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import riderj.crystalz.items.CrystalzItems;
import riderj.crystalz.utils.Utils;

public class CrystalzTabs extends CreativeTabs {
	
	private Item icon; //We will do what divine rpg does and use one of our item icons
	private String name;
	
	public static CrystalzTabs crystals = new CrystalzTabs("Crystals","Basic Crystals"); //Label is the description of the tab

	public CrystalzTabs(String name, String label) {
		super(getNextID(), label);
		this.name = name;
	}
	
	public CrystalzTabs(String label) {
		this(label, label);
	}
	
	public void setIcon(Item icon){
		this.icon = icon;
	}
	
	public void setIcon(Block block){
		this.icon = Utils.toItem(block);
	}

	@Override
	public Item getTabIconItem() {
		return icon;
	}
	
	public String getName(){
		return name;
	}
	
	public static void init(){
		crystals.setIcon(CrystalzItems.elementalCrystal);
	}

}
