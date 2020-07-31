import java.awt.*;
import java.applet.*;

public class Circle99 extends Applet
{
	public void paint(Graphics g)
	{
		g.drawString("circle 99", 20, 20);
		
		int x0 = getSize().width /2;
		int y0 = getSize().height /2;
		
		for( int r=0 ; r<getSize().height/2; r+=1 )
		{
			g.setColor( getRandomColor() );
			g.drawOval( x0-r,y0-r, r*2, r*2 );
		} 
		
	}
	Color getRandomColor()
	{
		return new Color(
			(int)( Math.random() * 255 ),
			(int)( Math.random() * 255 ),
			(int)( Math.random() * 255 )
		);
	}
}	