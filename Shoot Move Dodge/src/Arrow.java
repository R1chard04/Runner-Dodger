import java.awt.*;

public class Arrow extends Rectangle{

	public int ARROW_WIDTH = 10;
	public int ARROW_HEIGHT = 10;
	protected double ARROW_SPEED = 8.0;
	private Color color = Color.pink;
	
	double xSkeleton;
	double ySkeleton;
	double xPlayer;
	double yPlayer;

	
	Arrow(double x, double y, int height, int width, double xPlayer, double yPlayer) {
		super((int)x, (int)y, height, width);
		this.xPlayer = xPlayer;
		this.yPlayer = yPlayer;
		xSkeleton = x;
		ySkeleton = y;
	}
	
	public void move() {
		
		//TODO: fix the bug: likely due to the update in x,y of arrow (change it to original skeleton x,y)
		double xDiff = xSkeleton - xPlayer;
		double yDiff = ySkeleton - yPlayer;
		double totalHypotenuse = Math.sqrt((Math.pow(xDiff, 2)) + (Math.pow(yDiff, 2)));
		
		if(xDiff != 0 && yDiff != 0) {
			double xDist = (Math.abs(xDiff) / totalHypotenuse) * ARROW_SPEED;
			double yDist = (Math.abs(yDiff) / totalHypotenuse) * ARROW_SPEED;
			
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
		else if(xDiff == 0) {
			this.y -= (yDiff/Math.abs(yDiff)) * ARROW_SPEED;
		}
		else {
			this.x -= (xDiff/Math.abs(xDiff)) * ARROW_SPEED;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, ARROW_WIDTH, ARROW_HEIGHT);
	}

	
		
}
	



