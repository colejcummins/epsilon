import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

public class LevelPanel extends JPanel {
	
	private SpaceShip spaceShip;
	private ArrayList<Bullet> bullets;
	private SpaceShipListener listener;
	private BackgroundStars stars, starsBack;
	private EnemyManager enemies;
	private EnemyBulletManager enemyBullets;
	private boolean gameOver;
	private boolean victory;
	
	public LevelPanel() {
		this.setBackground(Color.BLACK);
		this.requestFocusInWindow();
		gameOver = false;
		victory = false;
		spaceShip = new SpaceShip(this);
		listener = new SpaceShipListener(this,spaceShip);
		stars = new BackgroundStars(this,Color.LIGHT_GRAY,6);
		starsBack = new BackgroundStars(this, Color.DARK_GRAY, 4);
		enemyBullets = new EnemyBulletManager(spaceShip, this);
		enemies = new EnemyManager(this, enemyBullets);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon victorySrc = new ImageIcon("Victory (2).png");
		Image victoryImage = victorySrc.getImage();
		
		ImageIcon gameOverSrc = new ImageIcon("Game Over.png");
		Image gameOverImage = gameOverSrc.getImage();
		if(!victory && !gameOver) {
			starsBack.draw(g, listener.getFrameCount());
			stars.draw(g, listener.getFrameCount());
			enemies.draw(g, listener.getFrameCount());
			spaceShip.draw(g);
			enemyBullets.draw(g);
			bullets = listener.getBullets();
		
			for (int i = 0; i<bullets.size(); i++) {
				if (bullets.get(i).getNullify()) {
					bullets.remove(i);
				} else {
					bullets.get(i).draw(g, enemies.getEnemies());
				}
			}
			ImageIcon hpSrc = new ImageIcon("HP.png");
			Image hp = hpSrc.getImage();
			g.drawImage(hp, 32, 4, 32, 32, null);
		
			ImageIcon fullHPSrc = new ImageIcon("Full Health.png");
			Image fullHP = fullHPSrc.getImage();
		
			ImageIcon twothirdHPSrc = new ImageIcon("2-3 Health.png");
			Image twothirdHP = twothirdHPSrc.getImage();
		
			ImageIcon onethirdHPSrc = new ImageIcon("1-3 Health.png");
			Image onethirdHP = onethirdHPSrc.getImage();
			
			ImageIcon bossSrc = new ImageIcon("-Boss-.png");
			Image boss = bossSrc.getImage();
			
			if(spaceShip.getHealth() == 3) {
				g.drawImage(fullHP, 70, 4, 160, 32, null);
			}
			if(spaceShip.getHealth() == 2) {
				g.drawImage(twothirdHP, 70, 4, 160, 32, null);
			}
			if(spaceShip.getHealth() == 1) {
				g.drawImage(onethirdHP, 70, 4, 160, 32, null);
			}
			if(listener.getFrameCount()>100) {
				g.drawImage(boss, 360, 4, 66, 32, null);
				if(listener.getFrameCount()>200) {
					g.setColor(Color.RED);
					g.fillRect(440, 10, enemies.getEnemies().get(0).getHealth()*2, 22);
				}
			}
		}
		if(gameOver == true) {
			g.drawImage(gameOverImage, 105, 300, 510, 96, null);
			listener.stopTimer();
		}
		if(victory == true) {
			g.drawImage(victoryImage, 153, 300, 414, 96, null);
			listener.stopTimer();
		}
	}
	
	public void gameLost() {
		gameOver = true;
	}
	
	public void gameWon() {
		victory = true;
	}
}