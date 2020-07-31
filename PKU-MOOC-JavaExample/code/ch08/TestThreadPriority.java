public class TestThreadPriority {
	public static void main(String args[]) {
		Thread t1 = new Thread( new Runner(1) );
		Thread t2 = new Thread( new Runner(2) );
		Thread t3 = new Thread( new Runner(3) );
		//t1.setPriority( Thread.MIN_PRIORITY );
		//t2.setPriority( Thread.NORM_PRIORITY );
		//t3.setPriority( Thread.MAX_PRIORITY );
		t1.start();
		t2.start();
		t3.start();
	}
}

class Runner implements Runnable {
	int id;
	Runner(int id){
		this.id = id;
	}
	public void run() {
		for(int i=0; i<100; i++ ){
			Thread.currentThread().yield();
			System.out.print(id);
		}
	}
}
