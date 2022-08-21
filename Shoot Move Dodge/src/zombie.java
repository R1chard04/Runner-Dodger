
public class zombie extends mobileEntities{
	
	int health;
	int color;
	
	zombie(int health, int color){
		this.health = health;
		this.color = color;
	}
	
	boolean isDead() {
		return (health <= 0) ? true : false;
	}
}
