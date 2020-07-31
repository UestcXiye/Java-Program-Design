import java.awt.*;
public class TestLayoutNull {
    public static void main(String args[]) {
	    Frame f = new Frame("Flow Layout");

		Button[] buttons = new Button[8];
		for( int i=0; i<buttons.length; i++){
			buttons[i] = new Button( "button"+(i+1) );
			buttons[i].setLocation( 120*i, 100 );
			buttons[i].setSize(100,20);
		}
        
		f.setLayout(null);
        
		for( int i=0; i<buttons.length; i++)
			f.add( buttons[i] );
        
		f.setSize(400,200);
        f.setVisible(true);
    }
}
