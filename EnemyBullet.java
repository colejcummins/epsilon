import java.awt.Color;
import java.awt.Graphics;

public class EnemyBullet {
	
	private int x,y,Vx,Vy;
	private boolean nullify;
	private SpaceShip ship;
	private LevelPanel level;
	
	public EnemyBullet(SpaceShip ship, LevelPanel level, int Vx, int Vy, int x, int y) {
		this.ship = ship;
		this.level = level;
		this.Vx = Vx;
		this.Vy = Vy;
		this.x = x;
		this.y = y;
		nullify = false;
	}
	
	private boolean checkHitShip(double checkX, double checkY) {
		if(Math.sqrt(((checkY-y-6)*(checkY-y-6))+((checkX-x-6)*(checkX-x-6))) < 18) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 8, 8);
		if(y>level.getHeight() || x<0 || x>level.getWidth()) {
			nullify = true;
		}
		x += Vx;
		y += Vy;
		double checkX = ship.getCenterX();
		double checkY = ship.getCenterY();
		if(checkHitShip(checkX,checkY)) {
			nullify = true;
			ship.takeDamage();
		}
	}
	
	public boolean getNullify() {
		return nullify;
	}
}