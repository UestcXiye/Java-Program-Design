package pkumooc;

import javax.swing.*;
import java.util.Date;

/**
 * @author liuwenchen
 * @create 2020-07-10 17:36
 */
public class TimerSwing extends JFrame {
    Timer timer;
    public void init()
    {
        setLayout(null);
        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        timer=new Timer(1000,(e)->{
            setTitle(new Date().toString());
        });
        timer.start();
    }

    public static void main(String[] args) {
        TimerSwing timerSwing=new TimerSwing();
        timerSwing.init();
    }
}