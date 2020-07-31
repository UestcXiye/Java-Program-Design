public class TestThread2 {
	public static void main(String args[]) {
		MyTask mytask = new MyTask(10);
		Thread thread = new Thread(mytask);
		thread.start();
		//thread.setDaemon(true);

		for(int i=0; i<6; i++) {	
			System.out.println("Main--" + i);
			try{
				Thread.sleep(500);
			}catch( InterruptedException e ){}
		}

	}
}

class MyTask implements Runnable {
	private int n;
	public MyTask(int n){
		this.n = n;
	}
	public void run() {
		for(int i=0; i<n; i++) {	
			System.out.println(" " + i);
			try{
				Thread.sleep(500);
			}catch( InterruptedException e ){}
		}
	}
}
