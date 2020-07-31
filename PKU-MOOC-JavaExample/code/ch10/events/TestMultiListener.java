import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TestMultiListener {
    public static void main(String args[]) {
		JFrame f = new JFrame("Test");
		JTextField msg = new JTextField(20);
		
		Listener1 m1 = new Listener1(f);
		Listener2 m2 = new Listener2(f, msg);
		f.addWindowListener(m1);       
		f.addMouseMotionListener(m2);

		f.add( msg, BorderLayout.SOUTH );
		f.setSize(200,160);        		
		f.setVisible(true);
    }
}

class Listener1 implements WindowListener {
	Listener1( JFrame f ){ 
		this.f = f; 
	}
	private JFrame f;
	public void windowClosing(WindowEvent e){System.exit(0);}
	public void windowOpened(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowActivated(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
}

class Listener10 extends WindowAdapter{
	public void windowClosing(WindowEvent e){System.exit(0);}
}


class Listener2 implements MouseMotionListener {
	Listener2( JFrame f, JTextField msg ){
		this.msg = msg;
		this.f = f;
	}
	private JTextField msg;
	private JFrame f;
	private boolean bDragged = false;
	public void mouseMoved( MouseEvent e ){
		msg.setText( "MouseMoved: "+ e.getX() + ", " + e.getY() );
		if ( bDragged){
			f.setCursor( new Cursor( Cursor.DEFAULT_CURSOR ) );
			bDragged = false;
		}
	}
	public void mouseDragged( MouseEvent e ){
		msg.setText( "MouseDraged: "+ e.getX() + ", " + e.getY() );
		if( ! bDragged ) {
			f.setCursor( new Cursor( Cursor.CROSSHAIR_CURSOR ) );
			bDragged = true;
		}
		f.getGraphics().drawLine( e.getX(), e.getY(), e.getX(), e.getY());
	}
}
