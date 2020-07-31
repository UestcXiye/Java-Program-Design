import java.util.*;
public class ThreadJoin {
	public static void main(String args[]) {
		Runner r = new Runner();
		Thread thread = new Thread( r );
		thread.start();
		try{
			thread.join();
		}catch(InterruptedException e){}
		for( int i=0; i<10; i++ ){
			System.out.println("\t" + i );
			try{
				Thread.sleep(100);
			}catch( InterruptedException e ){}
		}
	}
}

class Runner implements Runnable {
	public void run() {
		for( int i=0; i<10; i++ ){
			System.out.println( i );
			try{
				Thread.sleep(100);
			}catch( InterruptedException e ){}
		}
	}
}
