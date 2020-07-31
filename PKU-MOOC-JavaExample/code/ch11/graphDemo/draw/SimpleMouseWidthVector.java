import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class SimpleMouseWidthVector extends Applet
{
	private java.util.Vector points = new java.util.Vector();
	public void init(){
		addMouseListener( new MouseAdapter() {
			public void mousePressed( MouseEvent e ){
				points.add( new Point(e.getX(), e.getY() ) );
				repaint();
			}
		} );
	}
	public void update(Graphics g){
		paint(g);
	}
	public void paint(Graphics g){
		for( int i =0; i<points.size(); i++){
			Point p = (Point)points.elementAt(i);
			g.drawString("x", p.x, p.y);
		}
	}

	public static void main(String args[]) {
		Frame f = new Frame("MouseClick");
		SimpleMouseWidthVector p = new SimpleMouseWidthVector();
		p.init();
		p.start();
		f.add("Center", p);
		f.setSize(400, 300);
		f.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){ System.exit(0); }
		});
		f.show();
    }
}