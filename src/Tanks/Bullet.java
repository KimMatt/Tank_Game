package Tanks;

public class Bullet {

	//The x and y positions
	double x;
	double y;
	//Velocity on the x and y axis
	double vx;
	double vy;
	//Time the bullet has been in air, for calculations
	double t;
	
/**
 * Constructor that creates a bullet with initial positions 
 * and speeds, time starts at 0
 * @param x
 *       	X coordinate
 * @param y
 * 		 	Y coordinate
 * @param vx
 * 			velocity on the x
 * @param vy
 * 			velocity on the y
 */
public Bullet(double x, double y, double vx, double vy){
	this.x = x;
	this.y = y;
	this.vx = vx;
	this.vy = vy;
	t = 0;
}

public double getX(){
	return x;
}

public double getY(){
	return y;
}

public double getXVelocity(){
	return vx;
}

public double getYVelocity(){
	return vy;
}

public double getTime(){
	return t;
}

/**
 * Updates all of the bullet's values
 * @param x
 * 			X-axis position
 * @param y
 * 			Y-axis position
 * @param vx
 * 			Bullet's x-axis velocity
 * @param vy
 * 			Bullet's y-axis velocity
 * @param t
 * 			Bullet's time 'alive'
 */
public void update(double x, double y, double vx, double vy,double t){
	this.x = x;
	this.y = y;
	this.vx = vx;
	this.vy = vy;
	this.t = t;
}

public void setX(double x){
	this.x = x;
}

public void setTime(double t){
	this.t = t;
}

public void setXVelocity(double vx){
	this.vx = vx;
}

public void setYVelocity(double vy){
	this.vy = vy;
}

public void setY(double y){
	this.y = y;
}

}
