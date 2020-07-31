import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.io.*;

public class MailGet extends Applet
{
	public void init()
	{
		//{{INIT_CONTROLS
		setLayout(null);
		setSize(540,393);
		label1 = new java.awt.Label("Server");
		label1.setBounds(60,48,48,12);
		add(label1);
		label2 = new java.awt.Label("User");
		label2.setBounds(60,72,48,12);
		add(label2);
		label3 = new java.awt.Label("Passwd");
		label3.setBounds(48,96,48,12);
		add(label3);
		txtServer = new java.awt.TextField();
		txtServer.setBounds(108,48,324,23);
		add(txtServer);
		txtUser = new java.awt.TextField();
		txtUser.setBounds(108,72,324,22);
		add(txtUser);
		txtPass = new java.awt.TextField();
		txtPass.setEchoChar('*');
		txtPass.setBounds(108,96,324,24);
		add(txtPass);
		cmdGet = new java.awt.Button();
		cmdGet.setActionCommand("button");
		cmdGet.setLabel("Get");
		cmdGet.setBounds(444,48,68,60);
		cmdGet.setBackground(new Color(12632256));
		add(cmdGet);
		txtReply = new java.awt.TextArea();
		txtReply.setBounds(60,144,415,213);
		add(txtReply);
		//}}
		
		Action lAction = new Action();
	    cmdGet.addActionListener(lAction);
	}

	//{{DECLARE_CONTROLS
	java.awt.Label label1;
	java.awt.Label label2;
	java.awt.Label label3;
	java.awt.TextField txtServer;
	java.awt.TextField txtUser;
	java.awt.TextField txtPass;
	java.awt.Button cmdGet;
	java.awt.TextArea txtReply;
	//}}
	
	class Action implements java.awt.event.ActionListener
	{
	    public void actionPerformed(java.awt.event.ActionEvent event){
	        
	        Object object = event.getSource();
	        if (object == cmdGet) {
	              GetMail(event);
	        }
	    }
	}
	
	public void GetMail(java.awt.event.ActionEvent evt){
	    String sHostName;
	    int nPort = 110;
	    String sReply;
	    sHostName = txtServer.getText();
	    try {
	        Socket sktConn = new  Socket(sHostName,nPort);
	        PrintStream ps = new PrintStream(sktConn.getOutputStream());
	        sReply = getReply(sktConn);
	        if (sReply.indexOf("+ERR") == -1){     
	            txtReply.append(sReply+"\n");
	            ps.println("USER liulili");  //用户名
	            txtReply.append(getReply(sktConn)+"\n");
	            ps.println("PASS " + txtPass.getText()); //口令
	            txtReply.append(getReply(sktConn)+"\n"); //得到邮件内容
            }
	        ps.println("QUIT "); //退出
	        txtReply.append(getReply(sktConn)+"\n");
	        
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	String getReply(Socket sktConn){ 
	    try {
	        BufferedReader outgoing = new BufferedReader(
				new InputStreamReader(sktConn.getInputStream()));
	        return outgoing.readLine();
	    } catch (IOException e) {
	        return e.getMessage();
	    }
	}	
	
	public static void main(String[]args){
		Frame f = new Frame("Draw");
		Applet p = new MailGet();
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
