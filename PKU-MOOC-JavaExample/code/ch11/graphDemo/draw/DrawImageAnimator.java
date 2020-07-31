import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.io.*;

public class DrawImageAnimator extends Frame
{
	public DrawImageAnimator( String s ){
		super(s);
		final String dir = "c:\\pic";
		String [] files = new File(dir).list();
		int num = files.length<=10? files.length : 10;
		images = new Image[num];
		for( int i=0; i<num; i++ )
			images[i] = Toolkit.getDefaultToolkit().createImage(
				dir +"\\"+ files[i]);
		setSize( 400, 700 );
		show();
		addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e ){
				bStop = true; 
				System.exit(0);
			}
		});
		thread = new MyThread();
		thread.start();
	}

	public void paint(Graphics g){
		g.drawImage( images[ curImage ], 0, 0, this );
	}

	private Image[] images;
	private int curImage;
	private boolean bStop;
	private MyThread thread;
	class MyThread extends Thread 
	{
		public void run(){
			while( ! bStop  ){
				repaint();
				try{ sleep(1000); } catch(InterruptedException e){}
				curImage ++; 
				if( curImage==images.length ) curImage=0;
			}
		}
	}

	public static void main(String args[]) {
		Object f = new DrawImageAnimator("DrawImageAnimator");
    }
}