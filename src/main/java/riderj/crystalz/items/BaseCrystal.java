package riderj.crystalz.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
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
			if(isSelected && worldIn.getTotalWorldTime() % 20 == 0 && !worldIn.isRemote){
				System.out.println("hi");
			}
	}
	
	@Override
	public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems){
		
		ItemStack stack = new ItemStack(itemIn, 1, 0);
		
		NBTTagCompound stackTagCompound = stack.getTagCompound();
		if(stackTagCompound == null){
			stack.setTagCompound(new NBTTagCompound());
			stackTagCompound = stack.getTagCompound();
			stackTagCompound.setInteger("blood", 0);
			stackTagCompound.setInteger("fire", 0);
			stackTagCompound.setInteger("water", 0);
			stackTagCompound.setInteger("nature", 0);
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
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		int blood, fire, water, nature;
		
		
		if(stack.getTagCompound() != null){
			fire = stack.getTagCompound().getInteger("fire");
			water = stack.getTagCompound().getInteger("water");
			nature = stack.getTagCompound().getInteger("nature");
			
			tooltip.add(EnumChatFormatting.RED+"Fire: "+fire);
			tooltip.add(EnumChatFormatting.BLUE+"Water: "+water);
			tooltip.add(EnumChatFormatting.GREEN+"Nature: "+nature);
		}
	}
}
