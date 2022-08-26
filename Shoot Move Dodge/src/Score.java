import java.awt.*;

public class Score extends Rectangle{
	
	public static int GAME_WIDTH;
	public static int GAME_HEIGHT;
	public int score = -1;
	public int health = 100;
	
	
	Score(int GAME_WIDTH, int GAME_HEIGHT){
		this.GAME_WIDTH = GAME_WIDTH;
		this.GAME_HEIGHT = GAME_HEIGHT;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("MV Boli", Font.BOLD, 60));
		
		g.drawString("Score: " + String.valueOf(score), GAME_WIDTH/2-150, 50);
		g.drawString("Health: " + String.valueOf(health), GAME_WIDTH-420, 50);
			
	}

}
