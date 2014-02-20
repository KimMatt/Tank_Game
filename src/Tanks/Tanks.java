package Tanks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Tanks extends JPanel{
int turn = 0;
Tank t1 = new Tank(900,380);
Tank t2 = new Tank(10,380);
ArrayList<Bullet> bulletList = new ArrayList();
int bullets;
Terrain land = new Terrain();
Image tank1;
Image tank2;
Image turret1;
Image turret2;
Image background;
Image bullet;
int t2health;
int t1health;
double wd;
int power;

public Tanks(){
	t1.setTankRotation((-1)*Math.atan(this.getSlope(t1)));
	t2.setTankRotation((-1)*Math.atan(this.getSlope(t2)));
	bullets = 0;
	t2health = 30;
	t1health = 30;
	wd = 0;
	power = 1;
}

public void setPower(int p){
	power = p;
}

public int getPower(){
	return power;
}

public void setTurn(int a){
	turn = a;
}

public int getTurn(){
	return turn;
}

public void paint(Graphics g2){
	Graphics2D g = (Graphics2D)g2;
	if(wd > 0){
		g.drawString("Right", 10, 10);
	}
	if(wd < 0){
		g.drawString("Left", 10, 10);
	}
	if(wd == 0){
		g.drawString("No Wind", 10, 10);
	}
		g.drawString("Power: " + power, 10, 40);
	if(t1health >= 0){
	    g.drawString("Tank 1: " + t1health, 10, 20);
	}
	else{
	    g.drawString("Tank 1: Dead", 10, 20);
	}
	if(t2health >=0){
		g.drawString("Tank 2: " + t2health, 10, 30);
	}
	else{
		g.drawString("Tank 2: Dead", 10, 30);}
	g.drawImage(background,0,0,null);
	g.setColor(Color.green);
	g.fillPolygon(land.getXPoints(),land.getYPoints(),1083);
	g.setColor(Color.gray);
	g.fillRect(1,0,4,1080);
	g.fillRect(1052,0,4,1080);
	try {
		tank1 = ImageIO.read(new File("BlueTank.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		tank2 = ImageIO.read(new File("RedTank.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		turret1 = ImageIO.read(new File("BlueCannon.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		turret2 = ImageIO.read(new File("RedCannon.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		bullet = ImageIO.read(new File("Bullet.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	for(int i = 0;i<bulletList.size();i++){
		g.drawImage(bullet, (int)((Bullet)bulletList.get(i)).getX(),(int)((Bullet)bulletList.get(i)).getY(),null);
	}
	
	g.setColor(Color.black);
	t1.setY(land.getYPoint(t1.getX()+25)-25);
	t2.setY(land.getYPoint(t2.getX()+25)-25);
	
	if(t1health >=0){
	//Tank1 
	g.rotate(t1.getTankRotation(),t1.getX(),t1.getY());
	g.rotate(t1.getTurretRotation(),t1.getX()+27,t1.getY());
	g.drawImage(turret1,t1.getX()+27,t1.getY()-3,null);
	g.rotate(-1*(t1.getTurretRotation()),t1.getX()+27,t1.getY());
	g.drawImage(tank1,t1.getX(),t1.getY(),null);
	g.rotate((-1)*t1.getTankRotation(),t1.getX(),t1.getY());
	}
	if(t2health >=0){
	//Tank2
	g.rotate(t2.getTankRotation(),t2.getX(),t2.getY());
	g.rotate(t2.getTurretRotation(),t2.getX()+25,t2.getY());
	g.drawImage(turret2,t2.getX()+25,t2.getY()-3,null);
	g.rotate(-1*(t2.getTurretRotation()),t2.getX()+25,t2.getY());
	g.drawImage(tank2,t2.getX(),t2.getY(),null);
	g.rotate((-1)*t2.getTankRotation(),t2.getX(),t2.getY());
	}
}

//ImageIO.read(new File());

public double getSlope(Tank a){
	double slope = ((double)(land.getYPoint(a.getX() -10)) - (double)(land.getYPoint(a.getX()+ 10)))/(20.0);
	return slope;
}

public ArrayList getBulletList(){
	return bulletList;
}

public void addBullet(Bullet a){
	bulletList.add(a);
	bullets++;
}

public void removeBullet(int i){
	if(bulletList.get(i) == null){
		return;
	}
	bulletList.remove(i);
	randomWind();
	if(turn == 0){
		turn = 1;
	}
	else{
		turn = 0;
	}
	bullets--;
}

public Tank getTank(int a){
	if(a == 1){
		return t1;
	}
	if(a == 2){
		return t2;
	}
	return null;
}

public Terrain getTerrain(){
	return land;
}

public void randomWind(){
	Random rn = new Random();
	int i = rn.nextInt() % 100;
	if(i <=33){
		wd = -.00008;
	}
	else if(i>66){
		wd = .00008;
	}
	else{
		wd = 0;
	}
}

public void update(){
	for(int i = 0; i<bulletList.size();i++){
		int sx =(int) bulletList.get(i).getX();
		int py =(int) bulletList.get(i).getY();
		int sy =land.getYPoint((int)(sx));
		double dx = (bulletList.get(i)).getX() +(bulletList.get(i)).getXVelocity() + wd;
		double dy = (bulletList.get(i)).getY() +(bulletList.get(i)).getYVelocity() + (( bulletList.get(i)).getTime()*.000000000078);
		if(dx < 10 || dx> 1070 || dy>1080){
			removeBullet(i);
		}
		
		//Tank hit
		
		else if((Math.abs(py- t2.getY()) <=4) && Math.abs(sx-t2.getX())<=4){
			System.out.println("Hit");
			t2health-=30;
			removeBullet(i);
		}
		
		else if((Math.abs(py- t1.getY()) <=4) && Math.abs(sx-t1.getX())<=4){
			System.out.println("Hit");
			t1health-=30;
			removeBullet(i);
		}
		
		//Explosion
		else if((Math.abs( sy - bulletList.get(i).getY())<=.5)  || (bulletList.get(i).getY() > sy)){
			removeBullet(i);
			double c = 1;
			for(int j = -29;j<0;j++){
				land.setY( sx+ j, (int)(land.getYPoint(sx + j) +c ));
				c++;
			}
			
			for(int j = 0;j<30;j++){
				c--;
				land.setY(sx + j, (int)(land.getYPoint(sx + j) +c));
			}
		}
		
		
		else{
	(bulletList.get(i)).setX(dx);
	(bulletList.get(i)).setY(dy);
	(bulletList.get(i)).setTime((bulletList.get(i)).getTime()+1);
	}
	}
	return;
}

public int getBullets(){
	return bullets;
}

}
