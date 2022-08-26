import java.awt.*;

public class Cannon extends Rectangle{
	
	private Color color = Color.LIGHT_GRAY;
	private int CANNON_HEIGHT = 20;
	private int CANNON_WIDTH = 20;
	
	Cannon(double x, double y, int width, int height){
		super ((int)x, (int)y, width, height);
	}
	
	public void move(){
		
	}
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, CANNON_WIDTH, CANNON_HEIGHT);
	}
}
