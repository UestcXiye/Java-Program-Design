package pkumooc;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author liuwenchen
 * @create 2020-07-10 17:27
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer timer= new Timer("display");
        TimerTask timerTask=new MyTask();
        timer.schedule(timerTask,1000,1000);
    }
}
class MyTask extends TimerTask
{
    int n=0;

    @Override
    public void run()
    {
        n++;
        System.out.println(new Date()+"---"+n);
    }
}