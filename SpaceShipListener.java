  import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class SpaceShipListener implements KeyListener, ActionListener, FocusListener {
	
	private LevelPanel level;
	private Timer timer = new Timer(20, this);
	private SpaceShip ship;
	private int frameCount = 0;
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
	private boolean movingLeft;
	private boolean movingRight;
	private boolean shooting;
	
	public SpaceShipListener(LevelPanel level, SpaceShip ship) {
		this.level = level;
		this.ship = ship;
		level.addFocusListener(this);
		level.addKeyListener(this);
		level.addMouseListener( new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                level.requestFocus();
                level.repaint();
            }
        } );
	}
	
	public void focusGained(FocusEvent arg0) {
		timer.start();
		level.repaint();
	} 

	
	public void focusLost(FocusEvent arg0) {
		timer.stop();
		level.repaint();
	}

	public void actionPerformed(ActionEvent arg0) {
		frameCount++;
		if (this.movingLeft == true){
			ship.update(-9);
		}
		if (this.movingRight == true){
			ship.update(9);
		}
		if ((this.shooting == true) && (frameCount%8==0)) {
			bullets.add(new Bullet(level,ship));
		}
		level.repaint();
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case(KeyEvent.VK_LEFT): this.movingLeft = true; break;
		case(KeyEvent.VK_RIGHT): this.movingRight = true;  break;
		case(KeyEvent.VK_Z): this.shooting = true; break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int released = e.getKeyCode();
		switch (released) {
		case (KeyEvent.VK_LEFT): this.movingLeft = false; break;
		case(KeyEvent.VK_RIGHT): this.movingRight = false; break;
		case(KeyEvent.VK_Z): this.shooting = false; break;
		}
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	
	public int getFrameCount() {
		return frameCount;
	}
	
	public void stopTimer() {
		timer.stop();
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
}