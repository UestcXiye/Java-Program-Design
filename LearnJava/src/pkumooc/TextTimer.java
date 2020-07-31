package pkumooc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author liuwenchen
 * @create 2020-07-10 18:00
 */

public class TextTimer
{
    public static void main(String[] args)
    {
        JFrame jframe=new JFrame("计时器");
        JPanel jpanel1=new JPanel();
        JButton jbutton1=new JButton("开始");
        JProgressBar jprogressBar1=new JProgressBar();

        class myactionlistener implements ActionListener
        {
            Timer timer1=new Timer(50,this);
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==jbutton1)
                {
                    timer1.start();
                }
                int value=jprogressBar1.getValue();

                if(value<100)
                {
                    jprogressBar1.setValue(++value);
                }
                else
                {
                    timer1.stop();
                }
            }
        }
        jbutton1.addActionListener(new myactionlistener());
        jframe.setSize(250,150);

        jpanel1.add(jbutton1);
        jpanel1.add(jprogressBar1);
        jframe.add(jpanel1);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }
}