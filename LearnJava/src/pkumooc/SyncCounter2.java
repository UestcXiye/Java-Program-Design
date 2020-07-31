package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-10 15:09
 * 线程同步控制：synchronized
 */
public class SyncCounter2 {
    public static void main(String[] args) {
        Num num = new Num();
        Thread counter1 = new Count(num);
        Thread counter2 = new Count(num);
        for( int i=0;i<10;i++)
        {
            num.testEquals();
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){}
        }
    }
}

class Num
{
    private int x=0;
    private int y=0;

    /**
     * increase()和testEquals()不加关键字synchronized的结果：
     * 0,0 ：true
     * 37395456,37492214 ：false
     * 78706581,78675933 ：false
     * 120350045,120643476 ：false
     * 166146369,166401222 ：false
     * 213619210,214054925 ：false
     * 260725769,261372623 ：false
     * 309750606,310140542 ：false
     * 350753947,351368112 ：false
     * 394051591,394468896 ：false
     */

    synchronized void increase()
    {
        x++;
        y++;
    }

    synchronized void testEquals()
    {
        System.out.println( x + "," + y +" ：" + (x==y));
    }
}

class Count extends Thread
{
    private Num num;
    Count(Num num)
    {
        this.num=num;
        this.start();
    }

    @Override
    public void run(){
        while(true) {
            num.increase();
        }
    }
}