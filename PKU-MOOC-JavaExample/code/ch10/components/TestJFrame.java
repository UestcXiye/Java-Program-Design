import javax.swing.*;
import java.awt.*;

public class TestJFrame extends JFrame
{
    private JLabel lbl;

    public TestJFrame()
    {
        super("Test JFrame");

        lbl = new JLabel("Hello Swing");
        //add(lbl);
        getContentPane().add(lbl);

        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new TestJFrame().setVisible(true);
    }
}