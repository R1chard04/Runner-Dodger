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

	JLabel gameTitle;
	JButton btnStartGame;
	JTextField namefield;
	JLabel nameText;
	JLabel instructions;
	String instructionText = "<html>"
							 + "Instructions: <br/>"
							 + "1. Select a name for yourself. <br/>"  
							 + "2. As the player, you'll be controlling the red square. Your goal is to run and dodge EVERYTHING! (pun intended) <br/>"
							 + "3. You'll be starting automatically once you click \"Start the game\", so there's no going back... be ready! <br/>"
							 + "4. GOOD LUCK! "
							 + "</html>";
	String name;
	
	StartFrame(){
		
		this.setTitle("Runner Dodger");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1500, 1000);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.cyan);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		
		//Game title
		gameTitle = new JLabel("Runner Dodger");
		gameTitle.setFont(new Font("MV Boli", Font.BOLD, 125));
		gameTitle.setBounds(300, 200, 1200, 400);
		this.add(gameTitle);
		
		//text field for player's name
		namefield = new JTextField();
		namefield.setPreferredSize(new Dimension(250, 40));
		namefield.setBounds(600, 500, 300, 50);
		namefield.setForeground(Color.black);
		namefield.setBackground(Color.green);
		namefield.setText("Player");
		this.add(namefield);
		
		//start button
		btnStartGame = new JButton("Start the Game!");
		btnStartGame.setFont(new Font("MV Boli", Font.BOLD, 50));
		btnStartGame.setBounds(520, 600, 500, 100);
		btnStartGame.addActionListener(this);
		btnStartGame.setOpaque(true);
		btnStartGame.setForeground(Color.orange);
		btnStartGame.setBackground(Color.black);
		btnStartGame.setHorizontalAlignment(JButton.CENTER);
		btnStartGame.setVerticalAlignment(JButton.CENTER);
		btnStartGame.setFocusable(false);
		btnStartGame.setBorder(BorderFactory.createEtchedBorder());
		this.add(btnStartGame);
		
		//text field for instructions
		instructions = new JLabel();
		instructions.setText(instructionText);
		instructions.setFont(new Font("MV Boli", Font.PLAIN, 20));
		instructions.setBounds(250, 800, 1200, 150);
		this.add(instructions);
		
		//text field prompting user for name
		nameText = new JLabel();
		nameText.setText("Enter player name:");
		nameText.setFont(new Font("MV Boli", Font.PLAIN, 20));
		nameText.setForeground(Color.black);
		nameText.setBounds(400, 500, 200, 50);
		this.add(nameText);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnStartGame) {
			name = namefield.getText();
			System.out.println("Good luck, " + name + "!");
			new GameFrame();
			
			btnStartGame.setEnabled(false);
			namefield.setEditable(false);
			
		}
	}

}
