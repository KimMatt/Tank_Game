package Tanks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Canvas implements KeyListener{

//Creates the frame and data of tanks
Tanks ts = new Tanks();
JFrame frame = new JFrame();
//An int to represent the game's status
int s;
//Distance moved on a turn
int moved;

/**
 * Constructor for Canvas that creates the game frame,
 * sets the size to 1080x1920 pixels, close operation,
 * updates the screen, adds keyListener and the tanks JPanel
 * to the frame. 
 */
public Canvas(){
	s = 0;
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(1080,1920);
	frame.setVisible(true);
	frame.add(ts);
	frame.repaint();
	frame.addKeyListener(this);
	ts.setFocusable(true);
}

public void paint(){
	frame.repaint();
}

public Tanks getTanks(){
	return ts;
}

@Override
/**
 * Takes in all key inputs, if they are one of the control's it performs
 * appropriate data changes and visual changes are called from the frame's
 * repaint method.
 */
public void keyPressed(KeyEvent e){
	if(e.getKeyCode() == 37){
		if(moved <=40 && ts.getTurn() == 1){
		if(ts.getTank(1).getX() >=11){
			ts.getTank(1).setX(ts.getTank(1).getX() -2);
			ts.getTank(1).setTankRotation((-1)*Math.atan(ts.getSlope(ts.getTank(1))));
			frame.repaint();
			moved++;
		}
		}
		else{
			return;
		}
	}
	if(e.getKeyCode() == 39){
		if(moved <=40 && ts.getTurn() == 1){
		if(ts.getTank(1).getX() <=1000){
			ts.getTank(1).setX(ts.getTank(1).getX() +2);
			ts.getTank(1).setTankRotation((-1)*Math.atan(ts.getSlope(ts.getTank(1))));
			frame.repaint();
			moved++;
		}
		}
		else{
				return;
		}
	}
	if(e.getKeyCode() == 65){
		if(moved <=40 && ts.getTurn() == 0){
		if(ts.getTank(2).getX() >=11){
			ts.getTank(2).setX(ts.getTank(2).getX() -2);
			ts.getTank(2).setTankRotation((-1)*Math.atan(ts.getSlope(ts.getTank(2))));
			frame.repaint();
			moved++;
		}
		}
	}
	if(e.getKeyCode() == 68){
		if(moved <=40 && ts.getTurn() == 0){
		if(ts.getTank(2).getX() <=1000){
			ts.getTank(2).setX(ts.getTank(2).getX() +2);
			ts.getTank(2).setTankRotation((-1)*Math.atan(ts.getSlope(ts.getTank(2))));
			frame.repaint();
			moved++;
		}
		}
	}
	//w
	if(e.getKeyCode() == 87){
		if(ts.getTank(2).getTurretRotation()>=(Math.PI/2)){
			ts.getTank(2).addTurretRotation((-1)*Math.PI/32);
			frame.repaint();
		}
	}
	//s
	if(e.getKeyCode() == 83){
		if(ts.getTank(2).getTurretRotation()<=((Math.PI/2) + Math.PI)){
			ts.getTank(2).addTurretRotation(Math.PI/32);
			frame.repaint();
		}
		}
	//down
	if(e.getKeyCode() == 40){
		if(ts.getTank(1).getTurretRotation()>=(Math.PI/2)){
			ts.getTank(1).addTurretRotation((-1)*Math.PI/32);
			frame.repaint();
		}
	}
	//up
	if(e.getKeyCode() == 38){
		if(ts.getTank(1).getTurretRotation()<=((Math.PI/2) + Math.PI)){
			ts.getTank(1).addTurretRotation(Math.PI/32);
			frame.repaint();
		}
	}
	if(e.getKeyCode() == 32){
		if(ts.getBullets()==0){
		if(ts.getTurn() == 0){
			double totalAngle =ts.getTank(2).getTurretRotation() - ((3*Math.PI)/(2)) + (ts.getTank(2).getTankRotation() + (Math.PI));
			Bullet b = new Bullet(ts.getTank(2).getX() + 21.5 - (Math.cos(totalAngle)*5),(ts.getTank(2).getY() - Math.sin(totalAngle)*25),((.00005*(ts.getPower())) * Math.cos(totalAngle)*(-1)),(.00025 * Math.sin(totalAngle))*(-1));
			ts.addBullet(b);
			moved = 0;
		}
		else{
			double totalAngle =ts.getTank(1).getTurretRotation() - ((3*Math.PI)/(2)) + (ts.getTank(1).getTankRotation() + (Math.PI));
			Bullet b = new Bullet(ts.getTank(1).getX() + 21.5 - (Math.cos(totalAngle)*5),(ts.getTank(1).getY() - Math.sin(totalAngle)*25),((.00005*(ts.getPower())) * Math.cos(totalAngle)*(-1)),(.00025 * Math.sin(totalAngle))*(-1));
			ts.addBullet(b);
			moved =0;
		}
		frame.repaint();
	}
	}
	//e
	if(e.getKeyCode() == 69){
		if(ts.getPower()<10){
			ts.setPower(ts.getPower()+1);
		}
	}
	//q
	if(e.getKeyCode() == 81){
		if(ts.getPower()>1){
			ts.setPower(ts.getPower()-1);
		}
	}
}

@Override
public void keyReleased(KeyEvent e) {
	System.out.println(e.getKeyCode());
}

@Override
public void keyTyped(KeyEvent e) {
	System.out.println(e.getKeyCode());
}

public int gameStatus(){
	return s;
}
}
