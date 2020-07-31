package pkumooc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuwenchen
 * @create 2020-07-10 16:03
 */
public class AtomicIntegerDemo {
    static int n=0;
    static AtomicInteger cnt=new AtomicInteger(0);

    public static void main(String[] args) {
        final int NUM=1000;
        Thread[] threads=new Thread[NUM];
        for(int i=0;i<NUM;i++)
        {
            threads[i]=new Thread(()->{
                n++;
                cnt.getAndIncrement();
            });
        }
        for(int i=0;i<NUM;i++) {
            threads[i].start();
        }
        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){}
        boolean judge1 = n==NUM;
        boolean judge2 = cnt.get()==NUM;
        System.out.println(n+" "+judge1);
        System.out.println(cnt.get()+" "+judge2);
    }
}