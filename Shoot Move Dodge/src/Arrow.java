import java.awt.*;

public class Arrow extends Rectangle{

	protected int ARROW_WIDTH = 3;
	protected int ARROW_HEIGHT = 3;
	protected double ARROW_SPEED = 3.0;
	private Color color = Color.gray;
	
	
	Arrow(int x, int y, int height, int width) {
		super(x, y, height, width);

	}
	
	public void move(double xPlayer, double yPlayer, double xSkeleton, double ySkeleton) {

		double xDiff = xSkeleton - xPlayer;
		double yDiff = ySkeleton - yPlayer;
		
		double totalDistance = Math.sqrt((xDiff*xDiff) + (yDiff + yDiff));
		double xDist = (Math.abs(xDiff) / totalDistance) * ARROW_SPEED;
		double yDist = (Math.abs(yDiff) / totalDistance) * ARROW_SPEED;


	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, ARROW_WIDTH, ARROW_HEIGHT);
	}

	
		
	}
	



