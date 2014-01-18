package Taaaaaaaaaaaaaaaaaaaaaaaaaaaaanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tank extends JPanel{
	private int x;
	private int y;
	private double tankrotation;
	private double turretrotation;
	
	public Tank(int x,int y){
		this.x = x;
		this.y = y;
		turretrotation= Math.PI;
		tankrotation = 0;
	}
	
	public void update(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int a){
		x=a;
	}
	
	public void setY(int a){
		y=a;
	}
	
	public void setTankRotation(double a){
		tankrotation=a;
	}
	
	public void addTankRotation(double a){
		tankrotation+=a;
	}
	
	public void setTurretRotation(double a){
		turretrotation=a;
	}
	
	public void addTurretRotation(double d){
		turretrotation+=d;
	}
	
	public double getTankRotation(){
		return tankrotation;
	}
	
	public double getTurretRotation(){
		return turretrotation;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
}
