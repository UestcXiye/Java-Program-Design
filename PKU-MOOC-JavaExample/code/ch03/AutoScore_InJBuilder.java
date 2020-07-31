/*
	A basic extension of the java.applet.Applet class
 */

import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;

public class AutoScore_InJBuilder extends Applet
{
  private Button btnNew = new Button();
  private Button button2 = new Button();
  private Label lblA = new Label();
  private Label lblOp = new Label();
  private Label lblB = new Label();
  private Label label4 = new Label();
  private TextField txtAnswer = new TextField();
  private List listDisp = new List();


  int a=0,b=0;
  String op="";
  double result=0;


  public void init() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  private void jbInit() throws Exception {
    button2.setLabel("ÅÐ·Ö");
    button2.setBounds(new Rectangle(220, 93, 66, 30));
    button2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        button2_actionPerformed(e);
      }
    });
    btnNew.setLabel("³öÌâ");
    btnNew.setBounds(new Rectangle(85, 89, 77, 32));
    btnNew.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnNew_actionPerformed(e);
      }
    });
    this.setLayout(null);
    lblA.setText("label1");
    lblA.setBounds(new Rectangle(66, 39, 42, 21));
    lblOp.setText("label2");
    lblOp.setBounds(new Rectangle(124, 38, 37, 19));
    lblB.setText("label3");
    lblB.setBounds(new Rectangle(177, 38, 36, 23));
    label4.setText("=");
    label4.setBounds(new Rectangle(226, 40, 27, 17));
    txtAnswer.setText("textField1");
    txtAnswer.setBounds(new Rectangle(267, 36, 57, 26));
    listDisp.setBounds(new Rectangle(54, 134, 284, 133));
    this.add(btnNew, null);
    this.add(button2, null);
    this.add(lblA, null);
    this.add(lblB, null);
    this.add(lblOp, null);
    this.add(label4, null);
    this.add(txtAnswer, null);
    this.add(listDisp, null);
  }

  void btnNew_actionPerformed(ActionEvent e) {
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

  void button2_actionPerformed(ActionEvent e) {
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
        AutoScore_InJBuilder p = new AutoScore_InJBuilder();
        f.add ( p );
        p.init();
        p.start();
        f.setVisible( true );
}

}
