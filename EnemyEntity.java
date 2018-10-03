import java.awt.Graphics;
import java.awt.Image;

public class EnemyEntity {
	
	private int centX,centY,radius,health;
	private String name;
	private LevelPanel panel;
	
	public EnemyEntity(LevelPanel panel, int centX, int centY, int health, int radius) {
		this.panel = panel;
		this.name = name;
		this.centX = centX;
		this.centY = centY;
		this.radius = radius;
		this.health = health;
	}
	
	public void draw(Graphics g, int frameCount) {
	}
	
	public void shoot() {
	}

	public void takeDamage() {
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getCentX() {
		return centX;
	}
	
	public int getCentY() {
		return centY;
	}
}