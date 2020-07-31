import java.awt.*;
import javax.swing.*;
public class NestedContainer extends JFrame {
	JLabel lbl = new JLabel( "Display Area");
	JPanel pnl = new JPanel();
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	public NestedContainer(){
		super("Nested Container");
		
		pnl.setLayout(new GridLayout(2,2));
		pnl.add(b1); 		pnl.add(b2);
		pnl.add(b3);		pnl.add(b4);
		
		add(lbl, BorderLayout.NORTH);
		add(pnl, BorderLayout.CENTER);
		
		setSize(200, 120);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);  	
	}
	public static void main(String args[]) {
		SwingUtilities.invokeLater(()->{
			new NestedContainer();
		});  
	}
}
