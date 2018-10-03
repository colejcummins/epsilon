 import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Harbinger extends EnemyEntity {
	
	private Image image;
	private int centX, centY, radius, health, type;
	private int initialCount;
	private LevelPanel level;
	private EnemyBulletManager manager;
	
	public Harbinger(int type, EnemyBulletManager manager, LevelPanel level, int centX, int centY, int radius, int health, int frameCount) {
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
		ImageIcon imageSrc = new ImageIcon("Harbinger (3).png");
		image = imageSrc.getImage();
		g.drawImage(image, centX-80, centY-80, 160, 160, null);
		if(type == 1) {
			if(frameCount-initialCount < 50) {
				centY += 4;
			}
			if(frameCount-initialCount > 70 && (frameCount-initialCount)%300 < 150 ) {
				centX -= 1;
			}
			if(frameCount-initialCount > 70 && (frameCount-initialCount)%300 > 150) {
				centX += 1;
			}
			if(frameCount%40==0) {
				manager.addEnemyBullet(0, 15, centX-6, centY+70);
				manager.addEnemyBullet(3, 14, centX-6, centY+70);
				manager.addEnemyBullet(-3, 14, centX-6, centY+70);
			}
		}
		if(type == 2) {
			if(frameCount-initialCount < 50) {
				centY += 4;
			}
			if(frameCount-initialCount > 70 && (frameCount-initialCount)%300 < 150 ) {
				centX -= 1;
				centY += 1;
			}
			if(frameCount-initialCount > 70 && (frameCount-initialCount)%300 > 150) {
				centX += 1;
				centY += 1;
			}
			if(frameCount%40==0) {
				manager.addEnemyBullet(0, 15, centX-6, centY+70);
				manager.addEnemyBullet(-5, 13, centX-6, centY+70);
				manager.addEnemyBullet(5, 13, centX-6, centY+70);
				manager.addEnemyBullet(3, 14, centX-6, centY+70);
				manager.addEnemyBullet(-3, 14, centX-6, centY+70);
			}
		}
		if(level.getHeight()-centY < 80) {
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