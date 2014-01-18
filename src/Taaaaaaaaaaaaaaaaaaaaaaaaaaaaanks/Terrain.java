package Taaaaaaaaaaaaaaaaaaaaaaaaaaaaanks;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Terrain{

	private int[] xpoints = new int[1083];
	private int[] ypoints = new int[1083];
	
	public Terrain(){
		for(int i = 1;i<=1080;i++){
			xpoints[i-1] = i;
		}
		for(int j = 1;j<=1080;j++){
			ypoints[j-1] = (int) (400-(8*(Math.sin(j * .01)*9))); 
		}
		xpoints[1080]=1920;
		ypoints[1080]=1080;
		xpoints[1081]=0;
		ypoints[1081]=1080;
	}
	
	public int[] getXPoints(){
		return xpoints;
	}
	public int[] getYPoints(){
		return ypoints;
	}
	public int getYPoint(int i)
	{
		if(i == -2)
			return 0;
		return ypoints[i];
	}
	public int getXPoint(int i){
		return xpoints[i];
	}
	
	public void setY(int i, int a){
		ypoints[i] = a;
	}

}
