import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StartFrame extends JFrame implements ActionListener{

	JButton btnStartGame = new JButton("Start the Game!");
	JTextField namefield = new JTextField();
	String name;
	
	StartFrame(){
		
		this.setTitle("Shoot and Move");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 1000);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.cyan);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//Game title settings
		JLabel gameTitle = new JLabel("Shooter Dodger");
		gameTitle.setFont(new Font("MV Boli", Font.BOLD, 100));
		gameTitle.setBounds(250, 200, 1200, 400);
		this.add(gameTitle);
		
		//text field settings for player's name
		namefield.setPreferredSize(new Dimension(250, 40));
		namefield.setBounds(600, 500, 200, 50);
		namefield.setForeground(Color.black);
		namefield.setBackground(Color.green);
		namefield.setText("Player");
		this.add(namefield);
		
		//start button settings
		btnStartGame.setFont(new Font("MV Boli", Font.BOLD, 50));
		btnStartGame.setBounds(520, 600, 500, 100);
		btnStartGame.addActionListener(this);
		btnStartGame.setOpaque(true);
		btnStartGame.setForeground(Color.orange);
		btnStartGame.setBackground(Color.MAGENTA);
		btnStartGame.setHorizontalAlignment(JButton.CENTER);
		btnStartGame.setVerticalAlignment(JButton.CENTER);
		btnStartGame.setFocusable(false);
		btnStartGame.setBorder(BorderFactory.createEtchedBorder());
		this.add(btnStartGame);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnStartGame) {
			name = namefield.getText();
			System.out.println("Good luck, " + name + "!");
			GameFrame game = new GameFrame();
			
			btnStartGame.setEnabled(false);
			namefield.setEditable(false);
			
		}
	}

}
