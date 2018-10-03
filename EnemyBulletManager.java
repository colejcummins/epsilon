import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyBulletManager {
	
	private ArrayList<EnemyBullet> eBullets = new ArrayList<EnemyBullet>();
	private SpaceShip ship;
	private LevelPanel level;
	
	public EnemyBulletManager(SpaceShip ship, LevelPanel level) {
		this.ship = ship;
		this.level = level;
	}
	
	public void addEnemyBullet( int Vx, int Vy, int x, int y) {
		eBullets.add(new EnemyBullet(ship, level, Vx, Vy, x, y));
	}
	
	public void draw(Graphics g) {
		for(int i = 0; i<eBullets.size(); i++) {
			if(eBullets.get(i).getNullify()) {
				eBullets.remove(i);
			} else {
				eBullets.get(i).draw(g);
			}
		}
	}
}