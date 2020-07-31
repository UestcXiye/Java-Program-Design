import java.awt.*;
import javax.swing.*;
public class TestGridLayout extends JFrame {
	JButton[] buttons = new JButton[20];
	public TestGridLayout(){
		for( int i=0; i<buttons.length; i++)
			buttons[i] = new JButton( ""+(i+1) );
        
		setLayout(new GridLayout(4,5));
		
		for( int i=0; i<buttons.length; i++)
			add( buttons[i] );
		
		setSize(300,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(()->{
			new TestGridLayout();
		});
	}
}
