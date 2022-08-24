import java.awt.*;
import java.util.*;

public class Skeleton extends Rectangle{
	
	private int SKELETON_HEALTH = 10;
	private Color SKELETON_COLOR = Color.white;
	private double SKELETON_ATTACK_RANGE = 100;
	private int SKELETON_SPEED = 1;
	
	public double xPlayer;
	public double yPlayer;
	public boolean withinRange = false;
	
	Skeleton(int x, int y, int height, int width){
		super(x, y, height, width);

	}
	
	public void move(int xPlayer, int yPlayer) {
		this.xPlayer = xPlayer;
		this.yPlayer = yPlayer;
		double xDiff = this.x - (double)xPlayer;
		double yDiff = this.y - (double)yPlayer;
			
		double totalHypotenuse = Math.sqrt((Math.pow(xDiff, 2)) * (Math.pow(yDiff, 2)));
		double xMoveDist = (Math.abs(xDiff) / totalHypotenuse) * SKELETON_SPEED;
		double yMoveDist = (Math.abs(yDiff) / totalHypotenuse) * SKELETON_SPEED;
		
		if(totalHypotenuse - SKELETON_SPEED >= SKELETON_ATTACK_RANGE) {
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
			withinRange = true;
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
