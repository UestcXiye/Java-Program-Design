package pkumooc;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuwenchen
 * @create 2020-07-12 14:58
 */
public class TestFlowLayout extends JFrame{
    JButton[] jButtons=new JButton[8];

    public static void main(String[] args) {
        new TestFlowLayout();
    }

    public TestFlowLayout()
    {
        for(int i=0;i<jButtons.length;i++)
        {
            jButtons[i]=new JButton("Button" + (i+1));
            jButtons[i].setToolTipText("Button" + (i+1));
        }
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
        for(JButton jButton:jButtons)
        {
            getContentPane().add(jButton);
        }

        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
