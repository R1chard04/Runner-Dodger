
public class player{
	public int level;
	public int health; 
	public int speed; 
	public String name; 
	
	player(String name){
		this(1, 100, 10, name);
	}
	player(int level, int health, int speed, String name){
		this.level = level;
		this.health = health;
		this.speed = speed;
		this.name = name;
	}
	
	public boolean isDead() {
		return (health <= 0) ? true : false;
		
	}
	
	
}
