package riderj.crystalz.utils.material;

import java.util.Scanner;

import net.minecraft.item.Item.ToolMaterial;
import riderj.crystalz.utils.Utils;
import scala.reflect.internal.pickling.UnPickler.Scan;

public class CrystalzMaterials {
	/*
	 * Harvest Levels:
	 * 
	 * 0 - wood
	 * 1 - stone
	 * 2 - iron
	 * 3 - diamond
	 * 4 - unharvestable (Will be set in the tool file, by default 4 harvests everything due to >= in Item class)
	 */
	public static ToolMaterial basicCrystal = Utils.addCrystalMaterial("basicCrystal", 4, 1, 0.0F, 4.0F, 0);
}
