import java.awt.*;
import javax.swing.*;

public class CayleyTree extends JFrame
{
	public static void main( String []args ){
		CayleyTree frm = new CayleyTree("CayleyTree");
		frm.setVisible( true );
		SwingUtilities.invokeLater(()->{
			frm.init();
			frm.drawTree( 10, 200, 400, 100, -Math.PI/2 );
		});
	}
	private Frame frm;
	private Graphics graphics;
	private int width;
	private int height;
	private final double PI = Math.PI;
	private final double th1 = 30 * PI / 180;
	private final double th2 = 20 * PI / 180;
	private final double per1 = 0.6;
	private final double per2 = 0.7;

	public CayleyTree(String title){
		super(title);
		setSize( 400, 440 );
		setBackground( Color.lightGray );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void init(){
		width = getSize().width;
		height = getSize().height;
		graphics = this.getGraphics();
	}



	void drawTree(int n, 
			double x0, double y0, double leng, double th)
	{
		if( n==0 ) return;

		double x1 = x0 + leng * Math.cos(th);
		double y1 = y0 + leng * Math.sin(th);
		
		drawLine(x0, y0, x1, y1);
		
		drawTree( n - 1, x1, y1, per1 * leng, th + th1 );
		drawTree( n - 1, x1, y1, per2 * leng, th - th2 );
	}
	void drawLine( double x0, double y0, double x1, double y1 ){
		graphics.drawLine( (int)x0, (int)y0, (int)x1, (int)y1 );
	}

}
