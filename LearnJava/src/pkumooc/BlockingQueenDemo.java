package pkumooc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author liuwenchen
 * @create 2020-07-10 16:20
 */

public class BlockingQueenDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(3);
        new Thread(new Producers(queue)).start();
        new Thread(new Consumers(queue)).start();
    }
}

class Producers implements Runnable
{
    private BlockingQueue<Integer> queue;

    public Producers(BlockingQueue<Integer> queue)
    {
        this.queue=queue;
    }

    @Override
    public void run()
    {
        for(int i=0;i<=10;i++)
        {
            try {
                Thread.sleep((int) (Math.random()*10));
                queue.put(i);
                System.out.println("Produce "+i+".");
            }catch(InterruptedException e){}
        }
    }
}

class Consumers implements Runnable
{
    private BlockingQueue<Integer> queue;

    public Consumers(BlockingQueue<Integer> queue)
    {
        this.queue=queue;
    }

    @Override
    public void run()
    {
        for(int i=0;i<=10;i++)
        {
            try {
                Thread.sleep((int) (Math.random()*20));
                Integer product=queue.take();
                System.out.println("Consume "+product+".");
            }catch(InterruptedException e){}
        }
    }
}