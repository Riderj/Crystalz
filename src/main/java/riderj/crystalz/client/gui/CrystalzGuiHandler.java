package riderj.crystalz.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CrystalzGuiHandler implements IGuiHandler {
	
	public static final int CRYSTAL_STATS_GUI = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID){
			case CRYSTAL_STATS_GUI:
				return new CrystalStatsGui();
		}
		return null;
	}

}
