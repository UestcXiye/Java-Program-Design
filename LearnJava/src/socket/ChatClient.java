package socket;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author liuwenchen
 * @create 2020-07-30 17:27
 */

public class ChatClient extends JFrame  implements Runnable {
    public ChatClient() {
        try {
            init();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatClient::new);
    }

    JTextField txtInput = new JTextField("please input here", 20);
    JButton btnSend = new JButton("Send");
    JButton btnStart = new JButton("Start conect to server");
    JList<String> lstMsg = new JList<>();
    DefaultListModel<String> lstMsgModel = new DefaultListModel<>();

    Socket sock;
    Thread thread;
    BufferedReader in;
    PrintWriter out;
    public final static int DEFAULT_PORT = 6543;
    boolean bConnected;

    public void startConnect() {
        bConnected = false;
        try {
            sock = new Socket( "127.0.0.1", DEFAULT_PORT);
            bConnected = true;
            processMsg("Connection ok");
            in = new BufferedReader(
                    new InputStreamReader(sock.getInputStream()));
            out = new java.io.PrintWriter(sock.getOutputStream());
        } catch(IOException e) {
            e.printStackTrace();
            processMsg("Connection failed");
        }
        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                String msg = receiveMsg();
                Thread.sleep(100L);  //????
                if( msg != null ) {
                    processMsg( msg );
                }
            } catch( IOException e ) {
                e.printStackTrace();
            } catch( InterruptedException ei) {}
        }
    }

    public  void sendMsg(String msg) throws IOException {
        out.println( msg );
        out.flush();
    }

    public  String receiveMsg()  throws IOException {
        try {
            String msg = in.readLine();
            return msg;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void processMsg( String str ) {
        SwingUtilities.invokeLater( ()-> lstMsgModel.addElement(str));
    }

    private void init() throws Exception  {
        JPanel pnlHead = new JPanel();
        pnlHead.add( btnStart );
        getContentPane().add(pnlHead, BorderLayout.NORTH);

        getContentPane().add(
                new JScrollPane(lstMsg), BorderLayout.CENTER);
        JPanel pnlFoot = new JPanel();
        pnlFoot.add(txtInput);
        pnlFoot.add(btnSend);
        getContentPane().add(pnlFoot, BorderLayout.SOUTH);

        lstMsg.setModel(lstMsgModel);

        btnSend.addActionListener(e-> {
            if( txtInput.getText().length() != 0 ) {
                try {
                    sendMsg( txtInput.getText() );
                } catch(IOException e2) {
                    processMsg(e2.toString());
                }
            }

        });

        btnStart.addActionListener(e-> this.startConnect());

        this.setSize(400, 300);
        this.setTitle("Chat Client");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}