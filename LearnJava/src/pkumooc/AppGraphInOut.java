package pkumooc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liuwenchen
 * @create 2020-06-30 23:46
 */

public class AppGraphInOut
{
    public static void main(String[] args)
    {
        new AppFrame();
    }
}

class AppFrame extends JFrame
{
    JTextField in = new JTextField(10);
    JButton btn = new JButton("求平方");
    JLabel out = new JLabel();

    public AppFrame()
    {
        setTitle("Java Graph Process");
        setLayout(new FlowLayout());
        getContentPane().add(in);
        getContentPane().add(btn);
        getContentPane().add(out);

        btn.addActionListener(new BtnActionAdepter());

        setSize(400,100);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    class BtnActionAdepter implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String s = in.getText();
            double d = Double.parseDouble(s);
            double sq = d * d;
            out.setText(d+"的平方是:"+sq);
        }
    }
}
