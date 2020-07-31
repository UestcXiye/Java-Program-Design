package pkumooc;

import javax.swing.*;
import java.awt.*;

/**
 * @author liuwenchen
 * @create 2020-07-01 0:18
 */

public class AppletInOut extends JApplet
{
    JTextField in = new JTextField(10);
    JButton btn = new JButton("求平方根");
    JLabel out = new JLabel();

    public void init()
    {
        setLayout(new FlowLayout());
        add(in);
        add(btn);
        add(out);
        btn.addActionListener( e->{
            String s = in.getText();
            double d =Double.parseDouble(s);
            double sq = Math.sqrt(d);
            out.setText(d + "的平方根是"+sq);
        });
    }
}
