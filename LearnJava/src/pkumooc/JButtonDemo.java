package pkumooc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author liuwenchen
 * @create 2020-07-12 11:54
 */

public class JButtonDemo extends JFrame {
    JButton b1=new JButton("JButton 1");
    JButton b2=new JButton("JButton 2");
    JTextField t=new JTextField(20);

    public static void main(String[] args) {
        new JButtonDemo();
    }

    public JButtonDemo()
    {
        String filename="C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\cupHJbutton.gif";
        ImageIcon imageIcon=new ImageIcon(filename);
        b1.setToolTipText("Press Button will show msg");
        b1.setIcon(imageIcon);

        getContentPane().setLayout(new FlowLayout());
        getContentPane().add(b1);
        getContentPane().add(b2);
        getContentPane().add(t);

        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        ActionListener actionListener= e -> {
            String string=((JButton)e.getSource()).getText();
            t.setText(string + " Pressed");
        };

        b1.addActionListener(actionListener);
        b2.addActionListener(actionListener);
    }
}
