import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import buildings.Cannon;
import mobilesEntities.Skeleton;
import mobilesEntities.Zombie;
import projectiles.Arrow;
import projectiles.Bullet;


public class GamePanel extends JPanel implements Runnable{
	
	private boolean running = false;
	
	
	static final int GAME_WIDTH = 1500;
	static final int GAME_HEIGHT = 1000;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
	static final int PLAYER_WIDTH = 50;
	static final int PLAYER_HEIGHT = 50;
	
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	Score scoreboard;
	Player player;
	Zombie zombie;
	Skeleton skeleton;
	Cannon topLeftCannon, topRightCannon, bottomLeftCannon, bottomRightCannon;
	Arrow arrow1, arrow2, arrow3; 
	Bullet cannonTL, cannonTR, cannonBL, cannonBR;

	public int counter = 1;
	
	GamePanel(){
		newPlayer();
		newZombie();
		newSkeleton();
		newArrow();
		newCannon();
		newBullet();
		scoreboard = new Score(GAME_WIDTH, GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		
		gameThread = new Thread(this);
		gameThread.start();

	}
	
	public void newPlayer() {
		player = new Player(GAME_WIDTH/2, GAME_HEIGHT/2, PLAYER_WIDTH, PLAYER_HEIGHT);
	}
	
	public void newZombie() {
		random = new Random();
		boolean tooCloseToPlayer = true;
		int x = 0, y = 0;
		while(tooCloseToPlayer) {
			x = random.nextInt(1500);
			y = random.nextInt(1000);
			if ((x < player.x - 200 || x > player.x + 200) && (y < player.y - 200 || y > player.y + 200))
				tooCloseToPlayer = false;
		}
		zombie = new Zombie(x, y, 20, 20);
	}
	
	public void newSkeleton() {
		random = new Random();
		boolean tooCloseToPlayer = true;
		int x = 0, y = 0;
		while(tooCloseToPlayer) {
			x = random.nextInt(1500);
			y = random.nextInt(1000);
			if ((x < player.x - 200 || x > player.x + 200) && (y < player.y - 200 || y > player.y + 200))
				tooCloseToPlayer = false;
		}
		skeleton = new Skeleton(x, y, 20, 20);
	}
	
	public void newArrow() {
		//skeleton arrows
		arrow1 = new Arrow(skeleton.x, skeleton.y, 10, 10, player.x, player.y);
		arrow2 = new Arrow(skeleton.x, skeleton.y, 10, 10, player.x, player.y);
		arrow3 = new Arrow(skeleton.x, skeleton.y, 10, 10, player.x, player.y);
		
	}
	
	public void newBullet() {
		cannonTL = new Bullet(0, 0, 10, 10, 1480, 950);
		cannonTR = new Bullet(1480, 0, 10, 10, 0, 950);
		cannonBL = new Bullet(0, 950, 10, 10, 1480, 0);
		cannonBR = new Bullet(1480, 950, 10, 10, 0, 0);
	}
	
	public void newCannon() {
		topLeftCannon = new Cannon(0, 0, 20, 20);
		topRightCannon = new Cannon(1480, 0, 20, 20);
		bottomLeftCannon = new Cannon(0, 950, 20, 20);
		bottomRightCannon = new Cannon(1480, 950, 20, 20);
	}
	
	public void paint(Graphics g) {
		image = createImage(getWidth(),getHeight());
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image, 0, 0, this);
	}
	
	public void draw(Graphics g) {
		scoreboard.draw(g);
		
		player.draw(g);
		
		zombie.draw(g);
		skeleton.draw(g);
		
		arrow1.draw(g);
		arrow2.draw(g);
		arrow3.draw(g);
		
		topLeftCannon.draw(g);
		topRightCannon.draw(g);
		bottomRightCannon.draw(g);
		bottomLeftCannon.draw(g);
		
		cannonTL.draw(g);
		cannonTR.draw(g);
		cannonBL.draw(g);
		cannonBR.draw(g);
	}
	
	public void move() {
		player.move();
		zombie.move(player.x, player.y);
		skeleton.move(player.x, player.y);
		
		//skeleton arrows
		if (counter % 150 <= 49 && (arrow1.x <= 1499 && arrow1.x >= 1 && arrow1.y <= 999 && arrow1.y >= 1)) {
			arrow1.move();
			arrow2 = new Arrow(skeleton.x, skeleton.y, 10, 10, player.x, player.y);
			arrow2.move();
			arrow3.move();
		}
		else if(counter % 150 <= 99 && counter % 100 > 49 && (arrow1.x <= 1499 && arrow1.x >= 1 && arrow1.y <= 999 && arrow1.y >= 1)) {
			arrow1.move();
			arrow2.move();
			arrow3 = new Arrow(skeleton.x, skeleton.y, 10, 10, player.x, player.y);
			arrow3.move();
			
		}
		else if (counter % 150 <= 149){
			arrow1 = new Arrow(skeleton.x, skeleton.y, 10, 10, player.x, player.y);
			arrow1.move();
			arrow2.move();
			arrow3.move();
		}
		
		//Cannon bullets
		if(counter % 300 <= 74) {
			cannonTL = new Bullet(0, 0, 10, 10, 1480, 950);
			cannonTL.move();
			cannonTR.move();
			cannonBL.move();
			cannonBR.move();
		}
		else if(counter % 300 <= 154) {
			cannonTL.move();
			cannonTR = new Bullet(1480, 0, 10, 10, 0, 950);
			cannonTR.move();
			cannonBL.move();
			cannonBR.move();
		}
		else if(counter % 300 <= 214) {
			cannonTL.move();
			cannonTR.move();
			cannonBL = new Bullet(0, 950, 10, 10, 1480, 0);
			cannonBL.move();
			cannonBR.move();
		}
		else {
			cannonTL.move();
			cannonTR.move();
			cannonBL.move();
			cannonBR = new Bullet(1480, 950, 10, 10, 0, 0);
			cannonBR.move();
		}

	}
	
	public void checkContact() {
		if ((zombie.x >= player.x && zombie.x <= player.x + PLAYER_WIDTH) && (zombie.y >= player.y && zombie.y <= player.y + PLAYER_HEIGHT)) {
			player.PLAYER_HEALTH -= 2;
			scoreboard.health -= 2;
			return;
		} 
		else if((arrow1.x >= player.x && arrow1.x <= player.x + PLAYER_WIDTH && arrow1.y >= player.y && arrow1.y <= player.y + PLAYER_HEIGHT)
				|| (arrow2.x >= player.x && arrow2.x <= player.x + PLAYER_WIDTH && arrow2.y >= player.y && arrow2.y <= player.y + PLAYER_HEIGHT)
				|| (arrow3.x >= player.x && arrow3.x <= player.x + PLAYER_WIDTH && arrow3.y >= player.y && arrow3.y <= player.y + PLAYER_HEIGHT)){
			player.PLAYER_HEALTH -= 1;
			scoreboard.health -= 1;
			return;
		}
		else if((cannonTL.x >= player.x && cannonTL.x <= player.x + PLAYER_WIDTH && cannonTL.y >= player.y && cannonTL.y <= player.y + PLAYER_HEIGHT)
				|| (cannonTR.x >= player.x && cannonTR.x <= player.x + PLAYER_WIDTH && cannonTR.y >= player.y && cannonTR.y <= player.y + PLAYER_HEIGHT)
				|| (cannonBL.x >= player.x && cannonBL.x <= player.x + PLAYER_WIDTH && cannonBL.y >= player.y && cannonBL.y <= player.y + PLAYER_HEIGHT)
				|| (cannonBR.x >= player.x && cannonBR.x <= player.x + PLAYER_WIDTH && cannonBR.y >= player.y && cannonBR.y <= player.y + PLAYER_HEIGHT)){
			player.PLAYER_HEALTH -= 1;
			scoreboard.health -=1;
			return;
		}
	}
	
	public void checkHealth() throws InterruptedException {
		if (player.isDead() == true) {
			System.out.println("You died. You'll be revived soon...");
			newPlayer();
			newZombie();
			newSkeleton();
			scoreboard = new Score(GAME_WIDTH, GAME_HEIGHT);
			Thread.sleep(1000);
			
		}
		return;
	}
	

	public void addScore() {
		if(counter % 50 == 0) {
			scoreboard.score++;
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
				try {
					checkHealth();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				addScore();
				repaint();
				counter++;
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
