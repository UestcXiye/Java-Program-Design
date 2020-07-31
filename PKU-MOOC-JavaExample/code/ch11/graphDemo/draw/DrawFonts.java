import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class DrawFonts extends Applet
{
	public void paint(Graphics g){
		g.setColor( Color.blue );
		GraphicsEnvironment ge = GraphicsEnvironment.
			getLocalGraphicsEnvironment();
		Font[] fonts = ge.getAllFonts();
		for( int i=0;i< fonts.length; i++ ){
			String name = fonts[i].getName();
			g.setFont( new Font( name, Font.PLAIN, 12 ) );
			g.drawString( name, 10, 15*i );
		}
	}

	public static void main(String args[]) {
		Frame f = new Frame("Draw");
		DrawFonts p = new DrawFonts();
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