import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game implements KeyListener{
	
	JFrame game = new JFrame();
	JLabel label;
	
	Game(){
		
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setVisible(true);
		game.setSize(1500, 1000);
		game.setResizable(false);
		game.getContentPane().setBackground(Color.cyan);
		game.setLayout(null);
		
		
		label = new JLabel();
		label.setBounds(0, 0, 200, 100);
		label.setBackground(Color.red);
		label.setOpaque(true);
		game.add(label);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// keyTyped = Invoked when a key is typed. Uses KeyChar, char output
		switch(e.getKeyChar()) {
		case 'a': label.setLocation(label.getX()-10, label.getY());
			break;
		case 'w': label.setLocation(label.getX(), label.getY()+10);
		case 's': label.setLocation(label.getX(), label.getY()-10);
		case 'd': label.setLocation(label.getX()+10, label.getY());
		
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int output
		switch(e.getKeyCode()) {
		case 37: label.setLocation(label.getX()-10, label.getY());
			break;
		case 38: label.setLocation(label.getX(), label.getY()+10);
		case 39: label.setLocation(label.getX()+10, label.getY());
		case 40: label.setLocation(label.getX(), label.getY()-10);
		
		}
	}
	
	
	@Override
	public void keyReleased(KeyEvent e) {
		// keyReleased = called whenever a button is released
		
	}
	
	/**
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	*/
}
