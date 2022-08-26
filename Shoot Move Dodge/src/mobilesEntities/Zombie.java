package mobilesEntities;
import java.awt.*;
import java.util.*;

public class Zombie extends Rectangle implements MobileEntities{
	
	private int ZOMBIE_HEALTH = 20;
	private Color ZOMBIE_COLOR = Color.green;
	public double ZOMBIE_SPEED = 5.0;

	public Zombie(double x, double y, int width, int height){
		super((int)x, (int)y, width, height);

	}
	
	@Override
	public void move(int xPlayer, int yPlayer) {
		double xDiff = this.x - (double)xPlayer;
		double yDiff = this.y - (double)yPlayer;
		
		if(xDiff != 0 && yDiff != 0) {
			double totalDistance = Math.sqrt((xDiff*xDiff) + (yDiff * yDiff));
			double xDist = (Math.abs(xDiff) / totalDistance) * ZOMBIE_SPEED;
			double yDist = (Math.abs(yDiff) / totalDistance) * ZOMBIE_SPEED;
			
			if (xDiff > 0 && yDiff > 0) { //2nd quadrant (about location of mob)
				this.x -= xDist;
				this.y -= yDist;
			} else if (xDiff > 0 && yDiff < 0){ //3rd quadrant
				this.x -= xDist;
				this.y += yDist;
			} else if (xDiff < 0 && yDiff > 0){ //1st quadrant
				this.x += xDist;
				this.y -= yDist;
			} else { //4th quadrant
				this.x += xDist;
				this.y += yDist;
			}
		}
		else if(xDiff == 0) {
			this.y -= (yDiff/Math.abs(yDiff)) * ZOMBIE_SPEED;
		}
		else {
			this.x -= (xDiff/Math.abs(xDiff)) * ZOMBIE_SPEED;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(ZOMBIE_COLOR);
		g.fillOval(x, y, height, width);
	}
	
	@Override
	public boolean isDead() {
		return (ZOMBIE_HEALTH <= 0) ? true : false;
	}
	
}
