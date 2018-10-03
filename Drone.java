import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Drone extends EnemyEntity {
	
	private Image image;
	private int centX, centY, radius, health, type;
	private int initialCount;
	private LevelPanel level;
	private EnemyBulletManager manager;
	
	public Drone(int type, EnemyBulletManager manager, LevelPanel level, int centX, int centY, int radius, int health, int frameCount) {
		super(level, centX, centY, health, radius);
		this.type = type;
		this.manager = manager;
		this.level = level;
		this.initialCount = frameCount;
		this.radius = radius;
		this.centX = centX;
		this.centY = centY;
		this.health = health;
	}
	
	public void draw(Graphics g, int frameCount) {
		ImageIcon imageSrc = new ImageIcon("Ravager (7).png");
		image = imageSrc.getImage();
		g.drawImage(image, centX-32, centY-32, 64, 64, null);
		g.setColor(Color.RED);
		g.fillRect(centX-27, centY-46, health*10, 5);
		if(type == 1) {
			if(frameCount-initialCount < 20) {
				centY += 8;
			}
			if(frameCount-initialCount > 40 && (frameCount-initialCount)%250 < 100 ) {
				centX -= 2;
			}
			if(frameCount-initialCount > 40 && (frameCount-initialCount)%250 > 100 && (frameCount-initialCount)%250 < 200) {
				centX += 2;
			}
			if(frameCount-initialCount > 40 && (frameCount-initialCount)%250 > 200) {
				centY += 2;
			}
			if(frameCount%50==0) {
				manager.addEnemyBullet(0, 15, centX-6, centY+30);
			}
		}
		if (type == 2) {
			if(frameCount-initialCount < 20) {
				centY += 8;
			}
			if(frameCount-initialCount > 50 && (frameCount-initialCount)%200 < 100 ) {
				centX -= 2;
				centY += 2;
			}
			if(frameCount-initialCount > 50 && (frameCount-initialCount)%200 > 100) {
				centX += 2;
				centY += 2;
			}
			if(frameCount%30==0) {
				manager.addEnemyBullet(0, 15, centX-6, centY+30);
			}
		}
		if(level.getHeight()-centY < 50) {
			level.gameLost();
		}
	}
	
	public void takeDamage() {
		health--;
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