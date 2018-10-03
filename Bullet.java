import java.awt.*;
import java.util.ArrayList;

public class Bullet {
	
	private int pointX, pointY, damage;
	private boolean nullify;
	private LevelPanel level;
	private SpaceShip ship;
	private int explodingFrames;
	
	public Bullet(LevelPanel level, SpaceShip ship) {
		this.level = level;
		this.ship = ship;
		this.pointX = ship.getCenterX();
		this.pointY = ship.getCenterY()-30;
		nullify = false;
	}
	
	private boolean checkHit(double checkX, double checkY, int radius) {
		if(Math.sqrt(((checkY-pointY-6)*(checkY-pointY-6))+((checkX-pointX-2)*(checkX-pointX-2))) < radius) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g, ArrayList<EnemyEntity> enemies) {
		g.setColor(new Color(6,188,252));
		g.fillRect(pointX-2, pointY-6, 2, 16);
		pointY -= 30;
		if(pointY < 0) {
			nullify = true;
		}
		for(int e = 0; e<enemies.size(); e++) {
			double checkX = enemies.get(e).getCentX();
			double checkY = enemies.get(e).getCentY();
			int radius = enemies.get(e).getRadius();
			if(checkHit(checkX, checkY,radius)) {
				enemies.get(e).takeDamage();
				nullify = true;
			}
		}
	}
	
	public boolean getNullify() {
		return nullify;
	}

	public int getPointY() {
		return pointY;
	}
}