import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  AppletInOut8 extends JApplet
{
	JTextField in = new JTextField(10);
	JButton btn = new JButton("求平方根");
	JLabel out = new JLabel("用于显示结果的标签");

	public void init()
	{
		setLayout( new FlowLayout() );
		add( in );
		add( btn );
		add( out );
		btn.addActionListener( e->{
			String s = in.getText();
			double d = Double.parseDouble( s );
			double sq = Math.sqrt(d);
			out.setText( d + "的平方根是：" + sq );
		});
	}
}
