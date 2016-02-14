package riderj.crystalz.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.KeyboardInputEvent;
import riderj.crystalz.Crystalz;
import riderj.crystalz.client.gui.CrystalzGuiHandler;
import riderj.crystalz.utils.tabs.CrystalzTabs;

public class BaseCrystal extends Item{
	int charge = 0, maxCharge = 100;
	public BaseCrystal(){
		this("basic_crystal");
	}
	
	public BaseCrystal(String name){
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(CrystalzTabs.crystals);
		setMaxStackSize(1);
		setFull3D();
	}
	
	public int getCharge(ItemStack stack){
		return stack.getTagCompound().getInteger("charge");
	}
	
	public void setCharge(ItemStack stack, int charge){
		stack.getTagCompound().setInteger("charge", charge);
	}
	
	public int getMaxCharge(ItemStack stack){
		return stack.getTagCompound().getInteger("maxCharge");
	}
	
	public void setMaxCharge(ItemStack stack, int maxCharge){
		stack.getTagCompound().setInteger("maxCharge", maxCharge);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn){
		
		NBTTagCompound stackTagCompound = stack.getTagCompound();
		if(stackTagCompound == null){
			stack.setTagCompound(new NBTTagCompound());
			stackTagCompound = stack.getTagCompound();
		}
		
		stackTagCompound.setInteger("maxCharge", maxCharge);
		stackTagCompound.setInteger("charge", charge);		
		
	}
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected){
			
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems){
		
		ItemStack stack = new ItemStack(itemIn, 1, 0);
		
		NBTTagCompound stackTagCompound = stack.getTagCompound();
		if(stackTagCompound == null){
			stack.setTagCompound(new NBTTagCompound());
			stackTagCompound = stack.getTagCompound();
			stackTagCompound.setInteger("maxCharge", maxCharge);
			stackTagCompound.setInteger("charge", charge);
		}
		
		subItems.add(stack);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn){
		/*if(!worldIn.isRemote){
			playerIn.addChatComponentMessage(new ChatComponentText(""+itemStackIn.getTagCompound().getInteger("charge")+"/"+itemStackIn.getTagCompound().getInteger("maxCharge")));
		}*/
		if(worldIn.isRemote)
		playerIn.openGui(Crystalz.instance, CrystalzGuiHandler.CRYSTAL_STATS_GUI, worldIn, (int)playerIn.posX, (int)playerIn.posY, (int)playerIn.posZ);
		
		return itemStackIn;
	}
}
