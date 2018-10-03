import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Boss extends EnemyEntity {
	
	private Image image;
	private int centX, centY, radius, health;
	private int initialCount;
	private LevelPanel level;
	private EnemyBulletManager manager;
	
	public Boss( EnemyBulletManager manager, LevelPanel level, int centX, int centY, int radius, int health, int frameCount) {
		super(level, centX, centY, health, radius);
		this.manager = manager;
		this.level = level;
		this.initialCount = frameCount;
		this.radius = radius;
		this.centX = centX;
		this.centY = centY;
		this.health = health;
	}
	
	public void draw(Graphics g, int frameCount) {
		ImageIcon imageSrc = new ImageIcon("Boss.png");
		image = imageSrc.getImage();
		g.drawImage(image, centX-200, centY-200, 400, 400, null);
		if(frameCount-initialCount < 220) {
			centY +=2;
		}
		if(frameCount-initialCount > 240 && (frameCount-initialCount)%800 < 400) {
			if((frameCount-initialCount)%20 == 0) {
				manager.addEnemyBullet(12, 9, centX-160, centY+180);
				manager.addEnemyBullet(11, 11, centX-160, centY+180);
				manager.addEnemyBullet(9, 12, centX-160, centY+180);
				manager.addEnemyBullet(7, 13, centX-160, centY+180);
				
				manager.addEnemyBullet(-12, 9, centX+160, centY+180);
				manager.addEnemyBullet(-11, 11, centX+160, centY+180);
				manager.addEnemyBullet(-9, 12, centX+160, centY+180);
				manager.addEnemyBullet(-7, 13, centX+160, centY+180);	
			}
		}
		if(frameCount-initialCount > 240 && (frameCount-initialCount)%800 > 420 && (frameCount-initialCount)%800 <540) {
			if((frameCount-initialCount)%15 == 0) {
				manager.addEnemyBullet(-6,12,centX+20,centY+180);
				manager.addEnemyBullet(0,15,centX+20,centY+180);
				manager.addEnemyBullet(2,14,centX+20,centY+180);
				manager.addEnemyBullet(-2,14,centX+20,centY+180);
				manager.addEnemyBullet(4,13,centX+20,centY+180);
				manager.addEnemyBullet(-3,13,centX+20,centY+180);
				manager.addEnemyBullet(-4,13,centX+20,centY+180);
				manager.addEnemyBullet(6,12,centX+20,centY+180);
			}
			if((frameCount-initialCount)%15 == 0) {
				manager.addEnemyBullet(-6,12,centX-20,centY+180);
				manager.addEnemyBullet(0,15,centX-20,centY+180);
				manager.addEnemyBullet(2,14,centX-20,centY+180);
				manager.addEnemyBullet(-2,14,centX-20,centY+180);
				manager.addEnemyBullet(4,13,centX-20,centY+180);
				manager.addEnemyBullet(3,13,centX-20,centY+180);
				manager.addEnemyBullet(-4,13,centX-20,centY+180);
				manager.addEnemyBullet(6,12,centX-20,centY+180);
			}
		}
		if(frameCount-initialCount > 240 && (frameCount-initialCount)%800 > 580 && (frameCount-initialCount)%800 < 760) {
			if((frameCount-initialCount)%15 == 0) {
				manager.addEnemyBullet(0,15,centX+20,centY+180);
				manager.addEnemyBullet(2,14,centX+20,centY+180);
				manager.addEnemyBullet(-2,14,centX+20,centY+180);
				manager.addEnemyBullet(4,13,centX+20,centY+180);
				manager.addEnemyBullet(-4,13,centX+20,centY+180);
			}
			if((frameCount-initialCount)%15 == 0) {
				manager.addEnemyBullet(0,15,centX-20,centY+180);
				manager.addEnemyBullet(2,14,centX-20,centY+180);
				manager.addEnemyBullet(-2,14,centX-20,centY+180);
				manager.addEnemyBullet(4,13,centX-20,centY+180);
				manager.addEnemyBullet(-4,13,centX-20,centY+180);
			}
		}
		if(health == 0) {
			level.gameWon();
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