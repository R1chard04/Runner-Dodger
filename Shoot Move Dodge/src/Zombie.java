import java.awt.*;
import java.util.*;

public class Zombie extends Rectangle implements Runnable{
	
	private int ZOMBIE_HEALTH = 20;
	private Color ZOMBIE_COLOR = Color.green;
	public double ZOMBIE_SPEED = 2.0;
	
	Random random = new Random();
	public double xVelocity;
	public double yVelocity;
	
	Thread zombieThread;

	Zombie(int x, int y, int width, int height){
		super(x, y, width, height);
		
		zombieThread = new Thread();
		zombieThread.start();
	}

	public void move(int x, int y) {
		double xDiff = this.x - (double)x;
		double yDiff = this.y - (double)y;
		
		double totalDistance = Math.sqrt((xDiff*xDiff) + (yDiff + yDiff));
		double xDist = (Math.abs(xDiff) / totalDistance) * ZOMBIE_SPEED;
		double yDist = (Math.abs(yDiff) / totalDistance) * ZOMBIE_SPEED;
		
		
		//TODO: zombie tracking on the x- and y-axes
		if (xDiff > 0 && yDiff > 0) { //2nd quadrant (i.e. player is TOP LEFT)
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
	

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				zombieThread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void draw(Graphics g) {
		g.setColor(ZOMBIE_COLOR);
		g.fillOval(x, y, height, width);
	}
	
	boolean isDead() {
		return (ZOMBIE_HEALTH <= 0) ? true : false;
	}
	
}
