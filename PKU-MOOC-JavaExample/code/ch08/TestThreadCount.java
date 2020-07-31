class TestThreadCount 
{
	public static int cnt=0;
	public static void main(String[] args) 
	{
		final int NUM=5000;
		Thread [] threads = new Thread[NUM];
		for(int i=0; i<NUM; i++){
			threads[i] = new Thread(){
				public void run(){ 
					cnt++;
					try{ Thread.sleep(1); } catch(InterruptedException ex){}
				}
			};
		}
		for(int i=0; i<NUM; i++) threads[i].start();

		try{ Thread.sleep(3000); } catch(InterruptedException ex){}
		System.out.printf("%d %b\n", cnt, cnt==NUM);
	}
}
