package riderj.crystalz.utils;

public class ColorHelper {
	public static int getColorInt(int a,int r, int g, int b){
		int sum = (a<<24) + (r << 16) + (g << 8) + b;
		System.out.println("YUS: "+sum);
		
		return sum;
	}
}
