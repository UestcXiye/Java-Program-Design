import java.util.concurrent.atomic.AtomicInteger ;
class AtomicIntegerDemo
{
	static int n = 0;
	static AtomicInteger cnt = new AtomicInteger(0);
	public static void main(String[] args) 
	{
		final int NUM=1000;
		Thread [] threads = new Thread[NUM];
		for(int i=0; i<NUM; i++){
			threads[i] = new Thread(){
				public void run(){ 
					n ++;
					cnt.getAndIncrement(); 
				}
			};
		}
		for(int i=0; i<NUM; i++) threads[i].start();
		try{ Thread.sleep(3000); } 
		catch(InterruptedException ex){}
		System.out.printf("%d %b\n", n, n==NUM);
		System.out.printf("%d %b\n", cnt.get(), cnt.get()==NUM);
	}
}