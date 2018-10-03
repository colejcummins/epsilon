import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class SpaceShip {
	
	private int centerX, centerY, impulse;
	private LevelPanel panel;
	private int health;
	private String name;
	private Image image;
	
	public SpaceShip(LevelPanel panel) {
		health = 3;
		this.panel = panel;
		centerX = 360;
		centerY = 820;
	}
	
	public void draw(Graphics g) {
		ImageIcon epsilonSrc = new ImageIcon("Epsilon (5).png");
		image = epsilonSrc.getImage();
		g.drawImage(image, centerX-24, centerY-24, 48, 48, null); 
		if(health==0) {
			panel.gameLost();
		}
	}
	
	public void update(int impulse) {
		this.impulse = impulse;
		centerX += impulse;
		if(centerX <= 24) 
			centerX =24;
		if(centerX >= 696) 
			centerX = 696;
	}
	
	public int getHealth() {
		return health;
	}

	public void takeDamage() {
		health--;
	}

	public int getCenterX() {
		return centerX;
	}
	
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}
	
	public int getCenterY() {
		return centerY;
	}
	
	public int getImpulse() {
		return impulse;
	}
	
	public void setImpulse(int impulse) {
		this.impulse = impulse;
	}
	
}