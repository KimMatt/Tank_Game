package Tanks;

public class Bullet {

	double x;
	double y;
	double vx;
	double vy;
	double t;
	
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
