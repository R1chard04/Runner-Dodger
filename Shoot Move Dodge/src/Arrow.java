import java.awt.*;

public class Arrow extends Rectangle implements Runnable{

	protected int ARROW_WIDTH = 3;
	protected int ARROW_HEIGHT = 3;
	protected double ARROW_SPEED = 5.0;
	private Color color = Color.gray;
	
	//double xPlayer, yPlayer, xSkeleton, ySkeleton;
	double xDist, yDist;
	
	
	Arrow(int x, int y, int height, int width) {
		super(x, y, height, width);
		
		move(2.0, 2.0);
	}
	
	public void move(double x, double y) {
		this.xDist = x;
		this.yDist = y;
		
		x += xDist;
		y += yDist;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, ARROW_WIDTH, ARROW_HEIGHT);
	}

	@Override
	public void run() {
		move(xDist, yDist);
		
	}

	
		
}
	



