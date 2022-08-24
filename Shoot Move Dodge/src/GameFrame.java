import java.awt.Color;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameFrame extends JFrame{
	
	GamePanel panel;
	
	//JLabel label = new JLabel();
	
	GameFrame(){
		
		panel = new GamePanel();
		this.add(panel);
		this.setTitle("Shooter Dodger");
		this.setSize(1500, 1000);
		this.setResizable(false);
		this.setBackground(Color.black);
		
		//game.addKeyListener(this);
		
		//label for player's character
		//label.setBounds(0, 0, 50, 50);
		//label.setBackground(Color.red);
		//label.setOpaque(true);
		//game.add(label);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	/**
	@Override
	public void keyTyped(KeyEvent e) {
		// keyTyped = Invoked when a key is typed. Uses KeyChar, char output
		switch(e.getKeyChar()) {
		case 'a': 
			if(label.getX()-50 >= 0) {
				label.setLocation(label.getX()-50, label.getY());
			}
			break;
		case 'w': 
			if(label.getY()-50 >= 0) {
				label.setLocation(label.getX(), label.getY()-50);
			}
			break;
		case 's': 
			if(label.getY()+50 <= 950) {
				label.setLocation(label.getX(), label.getY()+50);
			}
			break;
		case 'd': 
			if(label.getX()+50 <= 1450) {
				label.setLocation(label.getX()+50, label.getY());
			}
			break;
		
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
		switch(e.getKeyCode()) {
		case 37: 
			if(label.getX()-50 >= 0) {
			label.setLocation(label.getX()-50, label.getY());
			}
			break;
		case 38: 
			if(label.getY()-50 >= 0) {
			label.setLocation(label.getX(), label.getY()-50);
			}
			break;
		case 39: 
			if(label.getX()+50 <= 1450) {
			label.setLocation(label.getX()+50, label.getY());
			}
			break;
		case 40: 
			if(label.getY()+50 <= 950) {
			label.setLocation(label.getX(), label.getY()+50);
			}
			break;
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// keyReleased = called whenever a button is released
		
	}
	 */
	
	/**
	@Override
	public void mouseClicked(MouseEvent e) {
		// Invoked when the mouse button has been clicked (pressed and released) on a component
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Invoked when a mouse button has been pressed on a component
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// INvoked when a mouse button has been released on a component
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Invoked when the mouse enters a component
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Invoked when the mouse exits a component
		
	}
	*/
}
