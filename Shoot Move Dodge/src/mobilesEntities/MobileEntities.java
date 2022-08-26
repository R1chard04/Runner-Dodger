package mobilesEntities;

import java.awt.*;

public interface MobileEntities{
	
	Color color = null;
	
	void move(int x, int y);
	void draw(Graphics g);
	boolean isDead();
}