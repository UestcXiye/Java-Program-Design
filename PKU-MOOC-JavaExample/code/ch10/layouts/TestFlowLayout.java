import java.awt.*;
import javax.swing.*;
public class TestFlowLayout extends JFrame {
	JButton[] buttons = new JButton[8];
	public TestFlowLayout(){
		for( int i=0; i<buttons.length; i++)
			buttons[i] = new JButton( "Button"+(i+1) );
        
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5 ));
		
		for( int i=0; i<buttons.length; i++)
			add( buttons[i] );
		
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(()->{
			new TestFlowLayout();
		});
	}
}
