import java.util.concurrent.*;

class ThreadPoolDemo 
{
	public static void main(String[] args) 
	{
		ExecutorService pool = Executors.newCachedThreadPool();
		MyTask t1 = new MyTask(5);
		MyTask t2 = new MyTask(7);
		MyTask t3 = new MyTask(8);
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.shutdown();
	}
}
class MyTask implements Runnable
{
	int n=10;
	public MyTask(int n){ this.n=n;}
	public void run(){
		for(int i=0;i<n; i++)System.out.print(i);
	}
}
