import java.util.*;
public class ThreadTerminateByFlag {
	public static void main(String args[]) {
		Timer timer = new Timer();
		Thread thread = new Thread( timer );
		thread.setName( "Timer" );
		thread.start();
		for( int i=0; i<100; i++ ){
			System.out.print("\r" + i );
			try{
				Thread.sleep(100);
			}catch( InterruptedException e ){}
		}
		timer.stopRun();
	}
}

class Timer implements Runnable {
	boolean flg = true;
	public void run() {
		while(flg){
			System.out.print( "\r\t" + new Date() + "..." );
			try{
				Thread.sleep(1000);
			}catch( InterruptedException e ){}
		}
		System.out.println( "\n" + Thread.currentThread().getName() + " Stop" );
	}
	public void stopRun(){
		flg = false;
	}
}
