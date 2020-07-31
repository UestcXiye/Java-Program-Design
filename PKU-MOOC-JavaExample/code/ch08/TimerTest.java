import java.util.*;
class TimerTest {
	public static void main(String[] args) {
		Timer timer = new Timer("display");
		TimerTask task = new MyTask();
		timer.schedule( task, 1000, 1000 );
	}
}
class MyTask extends TimerTask{
	int n = 0;
	public void run(){
		n++;
		System.out.print( new Date() );
		System.out.println( "---" + n );
	}
}
