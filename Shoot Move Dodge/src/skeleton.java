
public class skeleton extends mobileEntities{
	int health;
	String color;
	
	skeleton(){
		this(10, "white");
	}
	skeleton(int health, String color){
		this.health = health;
		this.color = color;
	}
	
	boolean isDead() {
		return (health >= 0) ? true : false;
	}
}
