import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestAnonymous extends JFrame{
	JTextField text = new JTextField(30);
	
	public TestAnonymous(){
		super("Test listener whith anonymous class");
		add(new JLabel("Please move mouse"), BorderLayout.NORTH);
		add(text, BorderLayout.SOUTH);
		
		getContentPane().addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e) { 
			}
			public void mouseMoved(MouseEvent e) {
			    String s = "mouse position£¨" + e.getX() + "," + e.getY() + ")";
			    text.setText(s);
			}
		});
		addWindowListener( new WindowAdapter() {
			public void windowClosing( WindowEvent e ){
				System.exit(0);
			}
		});
		setSize(300, 200);	    	
		setVisible(true);
	}
	public static void main(String args[]) { 
		SwingUtilities.invokeLater(()->{
			new TestAnonymous();
		});
	}
}