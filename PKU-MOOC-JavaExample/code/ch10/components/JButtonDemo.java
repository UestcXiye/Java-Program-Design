import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class JButtonDemo extends JFrame {
	JButton b1 = new JButton("JButton 1");
	JButton b2 = new JButton("JButton 2");
	JTextField t = new JTextField(20);
	public JButtonDemo() {

		b1.setToolTipText("Press Button will show msg");
		b1.setIcon( new ImageIcon( "cupHJbutton.gif") );

		getContentPane().setLayout( new FlowLayout() );
		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().add(t);

		setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String name = 
					((JButton)e.getSource()).getText();
				t.setText(name + " Pressed");
			}
		};
		b1.addActionListener(al);
		b2.addActionListener(al);
	}

	public static void main(String args[]) {
		new JButtonDemo().setVisible(true);
	}
}
