import javax.swing.*;
import java.awt.*;

public class EpsilonMain {
	
	public static void main(String[] args) {
		JFrame test = new JFrame("Epsilon");
		
		LevelPanel level = new LevelPanel();
		
		test.setSize(720, 960);
		test.setLocation(0,0);
		test.setContentPane(level);
		test.setResizable(false);
		test.setVisible(true);
	}
}