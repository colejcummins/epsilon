import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BackgroundStars {
	
	private ArrayList<Star> stars;
	private LevelPanel level;
	private Color color;
	private int speed;
	
	public BackgroundStars(LevelPanel level, Color color, int speed) {
		this.level = level;
		this.color = color;
		this.speed = speed;
		stars = new ArrayList<Star>();
	}
	
	public void draw(Graphics g, int frameCount) {
		if((int)(Math.random()*(frameCount%8))==0) {
			stars.add(new Star((int)(Math.random()*level.getWidth()),-10,color));
		}
		for(int i = 0; i<stars.size(); i++) {
			stars.get(i).draw(g);
			if(stars.get(i).getY()>level.getHeight()) {
				stars.remove(i);
			}
		}
	}
	
	public ArrayList<Star> getStars() {
		return stars;
	}

	private class Star {
		private int x,y;
		private Color color;
		
		public Star(int x, int y, Color color) {
			this.x = x;
			this.y = y;
			this.color = color;
		}
		
		public void draw(Graphics g) {
			y += speed;
			g.setColor(color);
			g.fillRect(x-2, y-2, 4, 4);
		}
		
		public int getY() {
			return y;
		}
	}
	
}