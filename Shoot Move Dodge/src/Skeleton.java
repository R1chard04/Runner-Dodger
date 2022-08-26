import java.awt.*;
import java.util.*;

public class Skeleton extends Rectangle{
	
	private int SKELETON_HEALTH = 10;
	private Color SKELETON_COLOR = Color.white;
	private double SKELETON_ATTACK_RANGE = 200;
	private double SKELETON_SPEED = 3;
	
	public double xPlayer;
	public double yPlayer;
	public boolean withinRange = false;
	
	Arrow arrow;
	
	Thread thread;
	
	Skeleton(double x, double y, int height, int width){
		super((int)x, (int)y, height, width);

	}
	
	public void move(int xPlayer, int yPlayer) {
		this.xPlayer = xPlayer;
		this.yPlayer = yPlayer;
		double xDiff = this.x - (double)xPlayer;
		double yDiff = this.y - (double)yPlayer;
		double totalHypotenuse = Math.sqrt((Math.pow(xDiff, 2)) + (Math.pow(yDiff, 2)));
		withinRange = (totalHypotenuse - SKELETON_SPEED) <= SKELETON_ATTACK_RANGE;
			
		if (xDiff != 0 && yDiff != 0) {
			double xMoveDist = (Math.abs(xDiff) / totalHypotenuse) * SKELETON_SPEED;
			double yMoveDist = (Math.abs(yDiff) / totalHypotenuse) * SKELETON_SPEED;
			
			if(withinRange == false) {
				if (xDiff > 0 && yDiff > 0) { //2nd quadrant
					this.x -= xMoveDist;
					this.y -= yMoveDist;
				} else if (xDiff > 0 && yDiff < 0){ //3rd quadrant
					this.x -= xMoveDist;
					this.y += yMoveDist;
				} else if (xDiff < 0 && yDiff > 0){ //1st quadrant
					this.x += xMoveDist;
					this.y -= yMoveDist;
				} else { //4th quadrant
					this.x += xMoveDist;
					this.y += yMoveDist;
				}
			} 
			/**
			else {
				if (xDiff > 0 && yDiff > 0) { //2nd quadrant
					arrow = new Arrow(this.x, this.y, 2, 2, -xMoveDist, -yMoveDist);
				} else if (xDiff > 0 && yDiff < 0){ //3rd quadrant
					arrow = new Arrow(this.x, this.y, 2, 2, -xMoveDist, yMoveDist);
				} else if (xDiff < 0 && yDiff > 0){ //1st quadrant
					arrow = new Arrow(this.x, this.y, 2, 2, xMoveDist, -yMoveDist);
				} else { //4th quadrant
					arrow = new Arrow(this.x, this.y, 2, 2, xMoveDist, yMoveDist);
				}
			}
			*/
		}
		
		else if(xDiff == 0) {
			if(withinRange == false) {
				this.y -= (yDiff/Math.abs(yDiff)) * SKELETON_SPEED;
			} 
			/**
			else if(withinRange == true) {
				arrow = new Arrow(this.x, this.y, 2, 2, 0, yDiff/Math.abs(yDiff));
			}
			*/
		}
		else if (yDiff == 0){
			if (withinRange == false) {
				this.x -= (xDiff/Math.abs(xDiff)) * SKELETON_SPEED;
			} 
			/**
			else if(withinRange == true) {
				arrow = new Arrow(this.x, this.y, 2, 2, xDiff/Math.abs(xDiff), 0);
			}
			*/
		}
		
	}

	public void draw(Graphics g) {
		g.setColor(SKELETON_COLOR);
		g.fillOval(x, y, height, width);
	}

	boolean isDead() {
		return (SKELETON_HEALTH >= 0) ? true : false;
	}
}
