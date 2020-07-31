package pkumooc;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author liuwenchen
 * @create 2020-07-12 17:33
 */
public class TestMultiListener {
    public static void main(String[] args) {
        Frame f = new Frame("Test");
        TextField msg = new TextField(20);

        Monitor1 m1 = new Monitor1(f);
        Monitor2 m2 = new Monitor2(f, msg);
        f.addWindowListener(m1);
        f.addMouseMotionListener(m2);

        f.add( msg, BorderLayout.SOUTH );
        f.setSize(300,300);
        f.setVisible(true);
    }
}

class Monitor1 implements WindowListener
{
    Monitor1( Frame f )
    {
        this.f = f;
    }

    private Frame f;

    @Override
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    @Override
    public void windowOpened(WindowEvent e){}

    @Override
    public void windowIconified(WindowEvent e){}

    @Override
    public void windowDeiconified(WindowEvent e){}

    @Override
    public void windowClosed(WindowEvent e){}

    @Override
    public void windowActivated(WindowEvent e){}

    @Override
    public void windowDeactivated(WindowEvent e){}
}

class Monitor2 implements MouseMotionListener
{
    Monitor2( Frame f, TextField msg ){
        this.msg = msg;
        this.f = f;
    }

    private TextField msg;
    private Frame f;
    private boolean bDragged = false;

    @Override
    public void mouseMoved(MouseEvent e )
    {
        msg.setText( "MouseMoved: "+ e.getX() + ", " + e.getY() );
        if ( bDragged){
            f.setCursor( new Cursor( Cursor.DEFAULT_CURSOR ) );
            bDragged = false;
        }
    }

    @Override
    public void mouseDragged( MouseEvent e )
    {
        msg.setText( "MouseDraged: "+ e.getX() + ", " + e.getY() );
        if( ! bDragged ) {
            f.setCursor( new Cursor( Cursor.CROSSHAIR_CURSOR ) );
            bDragged = true;
        }
        f.getGraphics().drawLine( e.getX(), e.getY(), e.getX(), e.getY());
    }
}