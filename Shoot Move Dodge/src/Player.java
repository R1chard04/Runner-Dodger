import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle{
	public int health = 100; 
	public String name = "Player"; 
	
	public int xVelocity;
	public int yVelocity;
	public int speed = 10; 
	
	Player(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	Player(int health, int speed, String name, int x, int y, int width, int height){
		super(x, y, width, height);
		this.health = health;
		this.speed = speed;
		this.name = name;
		
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
		return (health <= 0) ? true : false;
	}
	

	
}
