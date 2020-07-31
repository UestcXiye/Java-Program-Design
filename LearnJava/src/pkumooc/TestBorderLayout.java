package pkumooc;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuwenchen
 * @create 2020-07-12 15:42
 */
public class TestBorderLayout extends JFrame {
    public static void main(String[] args) {
        new TestBorderLayout();
    }

    public TestBorderLayout()
    {
        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(new Button("North"),BorderLayout.NORTH);
        getContentPane().add(new Button("South"),BorderLayout.SOUTH);
        getContentPane().add(new Button("Center"),BorderLayout.CENTER);
        // add(new Button("Another"),BorderLayout.CENTER);
        getContentPane().add(new Button("East"),BorderLayout.EAST);
        getContentPane().add(new Button("West"),BorderLayout.WEST);

        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
