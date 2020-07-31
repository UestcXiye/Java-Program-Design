import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AutoScore extends Applet implements ActionListener
{
	public void init()
	{
		//{{INIT_CONTROLS
		setLayout(null);
		setSize(380,266);
		btnNew.setLabel("³öÌâ");
		add(btnNew);
		btnNew.setBackground(java.awt.Color.lightGray);
		btnNew.setBounds(36,96,98,26);
		btnJudge.setLabel("ÅÐ·Ö");
		add(btnJudge);
		btnJudge.setBackground(java.awt.Color.lightGray);
		btnJudge.setBounds(216,96,94,25);
		lblA.setText("text");
		add(lblA);
		lblA.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblA.setBounds(36,24,36,36);
		lblOp.setText("text");
		add(lblOp);
		lblOp.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblOp.setBounds(72,24,36,36);
		lblB.setText("text");
		add(lblB);
		lblB.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblB.setBounds(108,24,33,36);
		label5.setText("=");
		add(label5);
		label5.setFont(new Font("Dialog", Font.PLAIN, 24));
		label5.setBounds(168,24,34,36);
		add(txtAnswer);
		txtAnswer.setFont(new Font("Dialog", Font.PLAIN, 24));
		txtAnswer.setBounds(216,24,85,42);
		listDisp.setFont(new Font("Dialog", Font.PLAIN, 16));
		add(listDisp);
		listDisp.setBounds(36,144,272,106);
		//}}
	
		//{{REGISTER_LISTENERS
		
		//SymAction lSymAction = new SymAction();
		//btnNew.addActionListener(lSymAction);

		btnNew.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				btnNew_ActionPerformed(event);
			}
		});

		//}}
	}
	
	//{{DECLARE_CONTROLS
	java.awt.Button btnNew = new java.awt.Button();
	java.awt.Button btnJudge = new java.awt.Button();
	java.awt.Label lblA = new java.awt.Label();
	java.awt.Label lblOp = new java.awt.Label();
	java.awt.Label lblB = new java.awt.Label();
	java.awt.Label label5 = new java.awt.Label();
	java.awt.TextField txtAnswer = new java.awt.TextField();
	java.awt.List listDisp = new java.awt.List(0);
	//}}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == btnNew)
				btnNew_ActionPerformed(event);
			else if (object == btnJudge)
				btnJudge_ActionPerformed(event);
		}
	}

	void btnNew_ActionPerformed(java.awt.event.ActionEvent event)
	{
		a = (int)(Math.random()*9+1);
		b = (int)(Math.random()*9+1);
		int c = (int)(Math.random()*4);
		switch( c )
		{
		    case 0: op="+"; result=a+b; break;
		    case 1: op="-"; result=a-b; break;
		    case 2: op="*"; result=a*b;break;
		    case 3: op="/"; result=a/b;break;
		}
		lblA.setText(""+a);
		lblB.setText(""+b);
		lblOp.setText(""+op);
		txtAnswer.setText("");
	}
	
	int a=0,b=0;
	String op="";
	double result=0;

	void btnJudge_ActionPerformed(java.awt.event.ActionEvent event)
	{
		String str = txtAnswer.getText();
		double d = Double.valueOf(str).doubleValue();
		String disp = "" + a + op + b+"="+ str +" ";
		if( d == result ) disp += "¡î";
		else disp += "¨w";
		
		listDisp.add( disp );
	}

	public static void main(String [] args)
	{
		Frame f = new Frame();
		f.setSize( 400,300 );
		AutoScore p = new AutoScore();
		f.add ( p );
		p.init();
		p.start();
		f.setVisible( true );
	}

}
