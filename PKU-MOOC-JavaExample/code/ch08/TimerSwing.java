import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

class TimerSwing extends JFrame
{
	Timer timer;
	public void init()
	{
		setLayout(null);
		setSize(400,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		timer = new Timer(1000, (e)->{
			setTitle( new java.util.Date().toString());
		});
		timer.start();
	}

	public static void main(String[] args) 
	{
		new TimerSwing().init();
	}
}


