import java.awt.*;
import javax.swing.*;
public class TestBorderLayout extends JFrame {

	public TestBorderLayout(){        
		setLayout(new BorderLayout());
		
		add(new Button("North"), BorderLayout.NORTH);
		add(new Button("South"), BorderLayout.SOUTH);
		add(new Button("East"), BorderLayout.EAST);
		add(new Button("West"), BorderLayout.WEST);
		add(new Button("Center"), BorderLayout.CENTER);
		//add(new Button("another"), BorderLayout.CENTER);
		
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(()->{
			new TestBorderLayout();
		});
	}
}
