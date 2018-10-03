import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyManager {
	
	private int frameCount, enemyDestroyed;
	private ArrayList<EnemyEntity> enemies;
	private LevelPanel level;
	private EnemyBulletManager manager;
	
	public EnemyManager(LevelPanel level, EnemyBulletManager manager) {
		this.level = level;
		this.manager = manager;
		enemies = new ArrayList<EnemyEntity>();
		
	}
	
	public void draw(Graphics g, int frameCount) {
		this.frameCount = frameCount;
		if (frameCount == 100) {
			//enemies.add(new Drone(1,manager,level,360,-50,20,5,100));
		}
		if (frameCount == 400) {
			//enemies.add(new Drone(1,manager,level,360,-50,20,5,400));
		}
		if (frameCount == 700) {
			//enemies.add(new Drone(2,manager,level,360,-50,20,5,700));
		}
		if(frameCount == 1000) {
			//enemies.add(new Drone(1,manager,level,240,-50,20,5,1000));
			//enemies.add(new Drone(1,manager,level,480,-50,20,5,1000));
		}
		if(frameCount == 1300) {
			//enemies.add(new Drone(1,manager,level,240,-50,20,5,1300));
			//enemies.add(new Drone(1,manager,level,480,-50,20,5,1300));
		}
		if(frameCount == 1600) {
			//enemies.add(new Drone(2,manager,level,240,-50,20,5,1600));
			//enemies.add(new Drone(2,manager,level,480,-50,20,5,1600));
		}
		if(frameCount == 1900) {
			//enemies.add(new Drone(1,manager,level,200,-50,20,5,1900));
			//enemies.add(new Drone(1,manager,level,360,-50,20,5,1900));
			//enemies.add(new Drone(1,manager,level,520,-50,20,5,1900));
		}
		if(frameCount == 2300) {
			//enemies.add(new Drone(2,manager,level,200,-50,20,5,2300));
			//enemies.add(new Drone(1,manager,level,360,-50,20,5,2300));
			//enemies.add(new Drone(2,manager,level,520,-50,20,5,2300));
		}
		if(frameCount == 2700) {
			//enemies.add(new Drone(2,manager,level,200,-50,20,5,2700));
			//enemies.add(new Drone(2,manager,level,480,-50,20,5,2700));
		}
		if(frameCount == 2900) {
			enemies.add(new Drone(2,manager,level,200,-50,20,5,2900));
			enemies.add(new Drone(2,manager,level,480,-50,20,5,2900));
		}
		if(frameCount == 3300) {
			enemies.add(new Harbinger(1,manager,level,360,-100,70,20,3300));
		}
		if(frameCount == 3700) {
			enemies.add(new Harbinger(2,manager,level,360,-100,70,20,3700));
		}
		if(frameCount == 4100) {
			enemies.add(new Harbinger(1,manager,level,360,-100,70,20,4100));
			enemies.add(new Drone(1,manager,level,240,-50,20,5,4100));
			enemies.add(new Drone(1,manager,level,480,-50,20,5,4100));
		}
		if(frameCount == 4600) {
			enemies.add(new Harbinger(1,manager,level,240,-100,70,20,4600));
			enemies.add(new Harbinger(1,manager,level,480,-100,70,20,4600));
		}
		if (frameCount == 5100) {
			enemies.add(new Harbinger(2,manager,level,240,-100,70,20,5100));
			enemies.add(new Drone(2,manager,level,360,-50,20,5,5100));
			enemies.add(new Harbinger(2,manager,level,480,-100,70,20,5100));
		}
		if (frameCount == 5400) {
			enemies.add(new Harbinger(2,manager,level,240,-100,70,20,5400));
			enemies.add(new Harbinger(2,manager,level,480,-100,70,20,5400));
		}	
		if(frameCount == 100) {
			enemies.add(new Boss(manager,level,360,-200,180,120,100));
		}
		for(int i = 0; i<enemies.size(); i++) {
			enemies.get(i).draw(g, frameCount);
			if(enemies.get(i).getHealth() <= 0) {
				enemies.remove(i);
			}
		}
	}
	
	public ArrayList<EnemyEntity> getEnemies() {
		return enemies;
	}
}