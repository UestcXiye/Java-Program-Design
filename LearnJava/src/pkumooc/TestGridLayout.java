package pkumooc;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuwenchen
 * @create 2020-07-12 15:52
 */
public class TestGridLayout extends JFrame{
    JButton[] jButtons=new JButton[20];

    public static void main(String[] args) {
        new TestGridLayout();
    }

    public TestGridLayout()
    {
        for(int i=0;i<jButtons.length;i++)
        {
            jButtons[i]=new JButton("" + (i+1));
            jButtons[i].setToolTipText("Button" + (i+1));
            jButtons[i].setFont(new Font("黑体",Font.BOLD,20));
        }
        getContentPane().setLayout(new GridLayout(4,5));
        for(JButton jButton:jButtons)
        {
            getContentPane().add(jButton);
        }

        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
