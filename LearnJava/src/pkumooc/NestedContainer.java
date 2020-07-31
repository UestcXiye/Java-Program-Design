package pkumooc;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuwenchen
 * @create 2020-07-12 16:10
 */
public class NestedContainer extends JFrame {
    JButton[] jButtons=new JButton[4];
    JLabel b0 = new JLabel( "Display Area");
    Panel p = new Panel();

    public static void main(String[] args) {
        new NestedContainer();
    }

     public NestedContainer()
     {
         super("Nested Container");

         for(int i=0;i<jButtons.length;i++)
         {
             jButtons[i]=new JButton("" + (i+1));
         }
         p.setLayout(new GridLayout(2,2));
         for(JButton jButton:jButtons)
         {
             p.add(jButton);
         }

         getContentPane().add(b0, BorderLayout.NORTH);
         getContentPane().add(p, BorderLayout.CENTER);

         setSize(200,120);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         setVisible(true);
     }
}
