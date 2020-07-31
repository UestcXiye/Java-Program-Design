package pkumooc;

import java.util.Date;

/**
 * @author liuwenchen
 * @create 2020-07-10 13:12
 * 9.2.4 Daemon线程
 * 	线程有两种，一类是Daemon线程，一类是非Daemon线程。在Java程序中，若还有非Demon线程，则整个程序就不会结束；而Daemon线程，可以在整个程序结束后继续运行，所以Demon线程可以用于后台服务程序。
 * 	通过调用isDaemon()，可检查一个线程是不是一个Daemon；用setDaemon (boolean flg)方法可以将一个线程设为Daemon线程。在一个Daemon线程中创建的子线程，也自动是Daemon线程。
 */

public class TestThreadDaemon {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.setDaemon(true);
        t.start();

        System.out.println("Main--" + new Date());
        try {
            Thread.sleep(500);
        }catch(InterruptedException e){}
        System.out.println("Main End");
    }
}

class MyThread extends Thread {
    @Override
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println(i+"--"+new Date());
            try {
                Thread.sleep(100);
            }catch(InterruptedException e){}
        }
    }
}