import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle{
	public int PLAYER_HEALTH = 100; 
	public String PLAYER_NAME = "Player"; 
	
	public int xVelocity;
	public int yVelocity;
	public int speed = 10; 
	
	Player(double x, double y, int width, int height){
		super((int)x, (int)y, width, height);
	}
	Player(int health, int speed, String name, double x, double y, int width, int height){
		super((int)x, (int)y, width, height);
		this.PLAYER_HEALTH = health;
		this.speed = speed;
		this.PLAYER_NAME = name;
		
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) {
			setYDirection(-speed);
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			setYDirection(speed);
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			setXDirection(-speed);
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			setXDirection(speed);
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) {
			setYDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_S) {
			setYDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_A) {
			setXDirection(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_D) {
			setXDirection(0);
		}
	}
	
	public void setXDirection(int xDirection) {
		xVelocity = xDirection;
	}
	
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		if (x + xVelocity <= 1450 && x + xVelocity >= 0) {
			x += xVelocity;
		}
		if (y + yVelocity <= 950 && y + yVelocity >= 0) {
			y += yVelocity;
		}
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
	
	
	public boolean isDead() {
		return (PLAYER_HEALTH <= 0) ? true : false;
	}
	

	
}
