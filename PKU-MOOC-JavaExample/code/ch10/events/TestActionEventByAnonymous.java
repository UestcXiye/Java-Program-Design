import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestActionEventByAnonymous  {
	static void test(){
		final JFrame f = new JFrame("Test");
		JButton b = new JButton("Press Me!");
		f.add(b);
		
		b.addActionListener( new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				((JButton)e.getSource()).setText(""+new java.util.Date());
			}
		});
		
		f.setSize(300, 120);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	public static void main(String args[]) {
		SwingUtilities.invokeLater(()->{
			test();
		});
	}
}

