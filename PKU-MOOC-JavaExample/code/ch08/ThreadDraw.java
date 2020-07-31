import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ThreadDraw extends Applet
{
	MovingShape [] shapes;
	
	public void init()
	{
		//{{INIT_CONTROLS
		setLayout(null);
		setSize(426,266);
		//}}
		
		shapes = new MovingShape[ 10 ];
		for( int i=0; i<shapes.length; i++ )
		    shapes[i] = new MovingShape(this);
		
	}
	
	public void start()
	{
		for( int i=0; i<shapes.length; i++ );
		    //shapes[i].start(); // it started when it's constructed
		super.start();
	}
	
	public void stop()
	{
		for( int i=0; i<shapes.length; i++ )
		    shapes[i].suspend();  //deprecated
		super.stop();
	}
	public void destroy()
	{
		for( int i=0; i<shapes.length; i++ )
		    shapes[i].stop();  //deprecated
		super.destroy();
	}

	public static void main(String [] args) //加入main,使之能当Application应用
	{
		Frame f = new Frame();
		f.setSize(450,300 );
		ThreadDraw p = new ThreadDraw();
		f.add ( p );
		f.setVisible( true );
		p.init();
		p.start();
		f.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){ System.exit(0); }
		});
	}
	//{{DECLARE_CONTROLS
	//}}
}


class MovingShape extends Thread
{
    
    boolean bContinue = false;
    private int size=100;
    private int speed=10;
    private Color color;
    private int type;
    private int x,y,w,h,dx,dy;
    protected java.awt.Component app;
    
    MovingShape( java.awt.Component app )
    {
        this.app = app;
        x = (int)(Math.random() * app.getSize().width);
        y = (int)(Math.random() * app.getSize().height);
        w = (int)(Math.random() * size );
        h = (int)(Math.random() * size );
        dx = (int)(Math.random() * speed );
        dy = (int)(Math.random() * speed );
        color = new Color ( 
            (int)(Math.random()*128+128), 
            (int)(Math.random()*128+128),
            (int)(Math.random()*128+128) );
        type = (int)(Math.random() * 3 );
        bContinue = true;
        this.start();  // 注意,线程刚构造出来,这里就立即进行启动
    }
    
    public void run()
    {
        while( true ){
            x += dx;
            y += dy;
            if( x<0 || x+w>app.getSize().width ) dx = -dx;
            if( y<0 || y+h>app.getSize().height) dy = -dy;
            Graphics g = app.getGraphics();
            
            switch( type ){
           
                case 0:
                    g.setColor(color);
                    g.fillRect( x,y,w,h ); 
                    g.setColor( Color.black );
                    g.drawRect( x,y,w,h );
                    break;
                case 1: 
                    g.setColor(color);
                    g.fillOval( x,y,w,h ); 
                    g.setColor( Color.black );
                    g.drawOval( x,y,w,h );
                    break;
                case 2: 
                    g.setColor(color);
                    g.fillRoundRect( x,y,w,h,w/5,h/5); 
                    g.setColor( Color.black );
                    g.drawRoundRect( x,y,w,h,w/5,h/5 );
                    break;
            }
            //System.out.println(x+","+y+","+w+","+h+":"+type+","+dx+","+dy);
            try{ Thread.sleep(130); } catch( InterruptedException e ){}
        }
    }

    
}