package pkumooc;

import javax.swing.*;

/**
 * @author liuwenchen
 * @create 2020-07-12 11:47
 */
public class TestJFrame extends JFrame{
    private JLabel jLabel;

    public static void main(String[] args) {
        new TestJFrame();
    }

    public TestJFrame()
    {
        super("Test JFrame");

        jLabel=new JLabel("Hello Swing");
        getContentPane().add(jLabel);
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
