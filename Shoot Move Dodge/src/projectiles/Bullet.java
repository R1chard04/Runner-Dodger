package projectiles;
import java.awt.*;

public class Bullet extends Rectangle implements Projectiles{
	
	public int BULLET_WIDTH = 10;
	public int BULLET_HEIGHT = 10;
	protected double BULLET_SPEED = 10.0;
	private Color color = Color.pink;
	
	double xTarget, yTarget;
	
	public Bullet(double x, double y, int width, int height,  double xTarget, double yTarget){
		super ((int)x, (int)y, width, height);

		this.xTarget = xTarget;
		this.yTarget = yTarget;
	}
	
	public void move() {
		double xDiff = this.x - xTarget;
		double yDiff = this.y - yTarget;
		double totalHypotenuse = Math.sqrt((Math.pow(xDiff, 2)) + (Math.pow(yDiff, 2)));
		
		double xDist = (Math.abs(xDiff) / totalHypotenuse) * BULLET_SPEED;
		double yDist = (Math.abs(yDiff) / totalHypotenuse) * BULLET_SPEED;
		
		if (xDiff > 0 && yDiff > 0) { //2nd quadrant
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
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, BULLET_WIDTH, BULLET_HEIGHT);
	}
}
