package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-10 15:26
 */

public class ProducerConsumerStack {
    public static void main(String[] args) {
        CubbyHole c = new CubbyHole();
        Producer p1 = new Producer(c,1);
        Consumer c1 = new Consumer(c,1);
        p1.start();
        c1.start();
    }
}

class Producer extends Thread
{
    private CubbyHole cubbyhole;
    private int number;

    public Producer(CubbyHole c, int number)
    {
        cubbyhole=c;
        this.number=number;
    }

    @Override
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            cubbyhole.put(i);
            //System.out.println("Producer #" + this.number + " put: " + i);
            //try {
            //	sleep((int)(Math.random() * 100));
            //} catch (InterruptedException e) {
            //}
        }
    }
}

class Consumer extends Thread
{
    private CubbyHole cubbyhole;
    private int number;

    public Consumer(CubbyHole c,int number)
    {
        cubbyhole = c;
        this.number = number;
    }

    @Override
    public void run()
    {
        int value=0;
        for (int i=0;i<10;i++)
        {
            value=cubbyhole.get();
            //System.out.println("Consumer #" + this.number + " got: " + value);
        }
    }
}

class CubbyHole1
{
    private int seq;

    public synchronized int get()
    {
        return seq;
    }

    public synchronized void put(int value)
    {
        seq = value;
    }
}

class CubbyHole2
{
    private int seq;
    private boolean available = false;

    public synchronized int get()
    {
        while(available == false) ;
        return seq;
    }
    public synchronized void put(int value)
    {
        while(available == true) ;
        seq=value;
        available=true;
    }
}

class CubbyHole3
{
    private int seq;
    private boolean available=false;

    public synchronized int get()
    {
        while (available == false)
        {
            try {
                wait(); // waits for notify() call from Producer
            }catch(InterruptedException e){}
        }
        available=false;
        notify();
        return seq;
    }

    public synchronized void put(int value) {
        while(available == true)
        {
            try {
                wait(); // waits for notify() call from consumer
            }catch(InterruptedException e){}
        }
        seq=value;
        available=true;
        notify();
    }
}


class CubbyHole
{
    private int data[]=new int[3];
    private int index=0;

    public synchronized int get()
    {
        while(index<=0)
        {
            try {
                wait(); // waits for notify() call from Producer
            }catch(InterruptedException e){}
        }
        notify();
        index--;
        System.out.println("Consumer " +  " got: " + data[index]);
        return data[index];
    }

    public synchronized void put(int value)
    {
        while(index>=data.length)
        {
            try {
                wait(); // waits for notify() call from consumer
            }catch(InterruptedException e){}
        }
        notify();
        data[index]=value;
        System.out.println("Producer " + " put: " + data[index]);
        index++;
    }
}