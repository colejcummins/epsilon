import javax.swing.*;

public class MenuLayout extends JPanel {
	
	private MenuListener listener = new MenuListener(this);
	
	public MenuLayout() {
		this.addKeyListener(listener);
		this.addMouseListener(listener);
		
		
	}
}