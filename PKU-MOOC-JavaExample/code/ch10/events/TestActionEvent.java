import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestActionEvent  {
    public static void main(String args[]) {
		JFrame f = new JFrame("Test");
		JButton btn = new JButton("Press Me!");
		f.add(btn);
		
		ActionListener al = new MyListener();
		btn.addActionListener(al);
		
		f.setSize(300, 120);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
    }
}

class MyListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
        System.out.println("a button has been pressed");    
    }
}

