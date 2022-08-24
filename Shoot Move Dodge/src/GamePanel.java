import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable{
	
	private boolean running = false;
	
	static final int GAME_WIDTH = 1500;
	static final int GAME_HEIGHT = 1000;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int PLAYER_WIDTH = 50;
	static final int PLAYER_HEIGHT = 50;
	
	
	Thread gameThread;
	Thread arrowThread;
	Image image;
	Graphics graphics;
	Random random;
	Player player;
	Zombie zombie;
	Skeleton skeleton;
	Arrow arrow;
	
	GamePanel(){
		newPlayer();
		newZombie();
		newSkeleton();
		this.setFocusable(true);
		this.addKeyListener(new AL());
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newPlayer() {
		player = new Player(0, 0, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	public void newZombie() {
		random = new Random();
		zombie = new Zombie(random.nextInt(1500), random.nextInt(1000), 20, 20);
	}
	
	public void newSkeleton() {
		random = new Random();
		skeleton = new Skeleton(random.nextInt(1500), random.nextInt(1000), 20, 20);
	}
	
	public void newArrow() {
		arrow = new Arrow(skeleton.x, skeleton.y, 2, 2);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		player.draw(g);
		zombie.draw(g);
		skeleton.draw(g);
		
	}
	
	public void move() {
		player.move();
		zombie.move(player.x, player.y);
		skeleton.move(player.x, player.y);
		if(skeleton.withinRange == true) {
			arrow.move(player.x, player.y, skeleton.x, skeleton.y);
		}
	}
	
	public void checkContact() {
		if ((zombie.x >= player.x && zombie.x <= player.x + PLAYER_WIDTH) && (zombie.y >= player.y && zombie.y <= player.y + PLAYER_HEIGHT)) {
			newPlayer();
			newZombie();
			newSkeleton();
			player.health -= 10;
		} else if((arrow.x >= player.x && arrow.x <= player.x + PLAYER_WIDTH) && (arrow.y >= player.y && arrow.y <= player.y + PLAYER_HEIGHT)) {
			newPlayer();
			newZombie();
			newSkeleton();
			player.health -=5;
		}
	}
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				checkContact();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
			}
	}

}
