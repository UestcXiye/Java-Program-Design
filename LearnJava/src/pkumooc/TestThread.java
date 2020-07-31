package pkumooc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liuwenchen
 * @create 2020-07-10 11:17
 */
public class TestThread {
    public static void main(String[] args) {
        Counter c1=new Counter(1);
        Thread t1=new Thread(c1);
        Thread t2=new Thread(c1);
        Thread t3=new Thread(c1);
        Counter c2=new Counter(2);
        Thread t4=new Thread(c2);
        Thread t5=new Thread(c2);
        Thread t6=new Thread(c2);
        TimeDisplay timer=new TimeDisplay();
        Thread t7=new Thread(timer);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
    }
}

class Counter implements Runnable
{
    int id;

    Counter(int id)
    {
        this.id=id;
    }

    @Override
    public void run()
    {
        int i=0;
        while(i++<=10)
        {
            System.out.println("ID: "+id+" NO."+i);
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){}
        }
    }
}

class TimeDisplay implements Runnable
{
    @Override
    public void run()
    {
        int i=0;
        while(i++<=3)
        {
            System.out.println(new SimpleDateFormat().format(new Date()));
            try {
                Thread.sleep(40);
            }catch (InterruptedException e){}
        }
    }
}