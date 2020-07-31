import java.util.*;
public class TestThreadDaemon {
	public static void main(String args[]) {
		Thread t = new MyThread();
		t.setDaemon(true);
		t.start();

		System.out.println( "Main--" + new Date());
		try{ Thread.sleep(500); } 
		catch(InterruptedException ex){}
		System.out.println("Main End");
	}
}

class MyThread extends Thread {
	public void run() {
		for(int i=0; i<10; i++ ){
			System.out.println(  i + "--" + new Date());
			try{ Thread.sleep(100); } 
			catch(InterruptedException ex){}
		}
	}
}
