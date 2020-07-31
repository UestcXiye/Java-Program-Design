import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
class MyFrame extends JFrame {
	JButton btn = new JButton("start");
	JLabel  lbl = new JLabel("");
	public MyFrame(){ 
		this.setTitle("test InvokeLater");
		this.setSize(300, 200);
		lbl.setFont( new Font("Times New Rome",0,48) );
		lbl.setHorizontalAlignment( SwingConstants.CENTER );
		getContentPane().setLayout( new BorderLayout() );
		getContentPane().add(btn, BorderLayout.NORTH );
		getContentPane().add(lbl, BorderLayout.CENTER );
		btn.addActionListener( e->{
			new Thread( ()->{
				for(int i=10; i>=0; i-- ){
					final int j = i;
					SwingUtilities.invokeLater(()->{
						lbl.setText(""+j);
					});
					try{ Thread.sleep(200); }
					catch(Exception ex){}
				}
			}).start();
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
class InvokeLaterDemo{
	public static void main( String... args){
		SwingUtilities.invokeLater(()->{
			new MyFrame().setVisible(true);
		});
	}
}
		
