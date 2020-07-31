import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class Draw_r_cos2th extends Applet
{
	public void paint(Graphics g){
		double w = getSize().width/2;
		double h = getSize().height/2;
		g.setColor( Color.blue );
		for( double th =0; th<10; th+=0.003){
			double r = Math.cos(16*th)*h;
			double x = r * Math.cos( th ) + w;
			double y = r * Math.sin( th ) + h;
			g.drawOval( (int)x-1, (int)y-1, 3, 3);
		}
		g.setColor( Color.yellow );
		for( double th =0; th<10; th+=0.003){
			double r = Math.cos(16*th)*h;
			double x = 0.5* r * Math.cos( th ) + w;
			double y = 0.5*r * Math.sin( th ) + h;
			g.drawOval( (int)x-1, (int)y-1, 3, 3);
		}
		g.setColor( Color.red );
		for( double th =0; th<10; th+=0.003){
			double r = Math.cos(16*th)*h;
			double x = 0.3*r * Math.cos( th ) + w;
			double y = 0.3*r * Math.sin( th ) + h;
			g.drawOval( (int)x-1, (int)y-1, 3, 3);
		}

	}

	public static void main(String args[]) {
		Frame f = new Frame("Draw");
		Draw_r_cos2th p = new Draw_r_cos2th();
		p.init();
		p.start();
		f.add(p);
		f.setSize(400, 300);
		f.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){ System.exit(0);}
		});
		f.show();
    }
}