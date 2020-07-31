import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.net.URI;

public class DrawImageAnimator extends JPanel
{
	public DrawImageAnimator( ){
		try{
			final URI dir = getClass().getResource(".").toURI();
			System.out.println(dir);
			String [] files = new File(dir).list();
			int num = files.length<=10? files.length : 10;
			images = new java.util.ArrayList<Image>();
			for( int i=0; i<num; i++ ){
				if( files[i].toLowerCase().endsWith(".png")
					 || files[i].toLowerCase().endsWith(".jpg") 
					 || files[i].toLowerCase().endsWith(".gif") 
					){
					Image img = javax.imageio.ImageIO.read(
						new File(new File(dir), files[i]));
					images.add( img );
				}
			}
		}catch(Exception ex){ex.printStackTrace();}
		thread = new MyThread();
		thread.start();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(images==null) return;
		Image img = images.get(curImage);
		g.drawImage( img, 0, 0, this );
	}

	private java.util.List<Image> images;
	private volatile int curImage;
	private boolean bStop;
	private MyThread thread;
	class MyThread extends Thread 
	{
		public void run(){
			while( ! bStop  ){
				SwingUtilities.invokeLater(()->{
					System.out.println("==" + curImage);
					//invalidate();
					//revalidate();
					repaint();
				});
				
				try{ sleep(1000); } catch(InterruptedException e){}
				curImage ++; 
				if( curImage==images.size() ) curImage=0;
			}
		}
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(()->{
			JFrame f = new JFrame("Draw Images");
			f.setSize( 400, 300 );
			f.add(new DrawImageAnimator() );
			f.setVisible(true);
			f.addWindowListener( new WindowAdapter(){
				public void windowClosing(WindowEvent e ){
					boolean bStop = true; 
					System.exit(0);
				}
			});
		});
    }
}