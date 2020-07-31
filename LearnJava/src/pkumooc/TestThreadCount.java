package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-10 14:33
 */
public class TestThreadCount {
    public static void main(String[] args) {
        final int[] cnt = {0};
        final int NUM=10000;
        Thread[] threads=new Thread[NUM];
        for(int i=0;i<NUM;i++)
        {
            threads[i]= new Thread(() -> {
                cnt[0]++;
                try {
                    Thread.sleep(1);
                }catch(InterruptedException e){}
            });
        }
        for(int i=0;i<NUM;i++) threads[i].start();

        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){}
        boolean judge= cnt[0] ==NUM;
        System.out.println(cnt[0] +" "+judge);
    }
}