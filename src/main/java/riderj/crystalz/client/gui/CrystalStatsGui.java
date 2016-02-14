package riderj.crystalz.client.gui;

import org.lwjgl.opengl.GL11;

import javafx.scene.paint.Color;
import net.minecraft.client.gui.GuiScreen;
import riderj.crystalz.utils.ColorHelper;

public class CrystalStatsGui extends GuiScreen {
	int xSize = 100;
	int ySize = 100;
	int xOffset = 0;
	int yOffset = 0;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);	
		this.drawRect((width/2)-(xSize+xOffset),(height/2)-(ySize+yOffset),(width/2)+(xSize+xOffset),(height/2)+(ySize+yOffset),0xFFFF0000);
		
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void initGui(){
	}
}
