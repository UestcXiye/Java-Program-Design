import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawFlowers
{
	public static void main(String args[]) {
		SwingUtilities.invokeLater(()->{
			JFrame f = new JFrame("Draw");
			f.setLayout(new GridLayout(3,4));
			for(int i=0; i<16; i++ ){
				f.add( new FlowerPanel(i) );
			}
			f.setSize(400, 300);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		});
    }
}

class FlowerPanel extends JPanel
{
	int N = 16;
	public FlowerPanel(int N){
		this.N = N;
		this.setDoubleBuffered(true);
	}

	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		double x0 = getSize().width/2;
		double y0 = getSize().height/2;
		double  h = Math.min(x0, y0);
		if( h>10 ) h-=4;

		g.setColor( Color.blue );
		for( double th =0; th<10; th+=0.003){
			double r = Math.cos(N*th)*h;
			double x = r * Math.cos( th ) + x0;
			double y = r * Math.sin( th ) + y0;
			g.drawOval( (int)x-1, (int)y-1, 3, 3);
		}
		g.setColor( Color.yellow );
		for( double th =0; th<10; th+=0.003){
			double r = Math.cos(16*th)*h;
			double x = 0.5* r * Math.cos( th ) + x0;
			double y = 0.5*r * Math.sin( th ) + y0;
			g.drawOval( (int)x-1, (int)y-1, 3, 3);
		}
		g.setColor( Color.red );
		for( double th =0; th<10; th+=0.003){
			double r = Math.cos(16*th)*h;
			double x = 0.3*r * Math.cos( th ) + x0;
			double y = 0.3*r * Math.sin( th ) + y0;
			g.drawOval( (int)x-1, (int)y-1, 3, 3);
		}
	}
}