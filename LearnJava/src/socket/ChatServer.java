package socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author liuwenchen
 * @create 2020-07-30 17:29
 */

public class ChatServer extends JFrame implements Runnable {
    JTextField txtInput = new JTextField("please input here", 20);
    JButton btnSend = new JButton("Send");
    JList<String> lstMsg = new JList<>();
    DefaultListModel<String> lstMsgModel = new DefaultListModel<>();

    public ChatServer() {
        try {
            init();
            ServerListen();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception  {
        getContentPane().add(
                new JScrollPane(lstMsg), BorderLayout.CENTER);
        JPanel pnlFoot = new JPanel();
        pnlFoot.add(txtInput);
        pnlFoot.add(btnSend);
        getContentPane().add(pnlFoot, BorderLayout.SOUTH);

        lstMsg.setModel(lstMsgModel);
        btnSend.addActionListener((e)-> broadcastMsg( this.txtInput.getText() ));

        this.setSize(400, 300);
        this.setTitle("Chat Server");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ChatServer::new);
    }

    public void processMsg( String str ) {
        SwingUtilities.invokeLater( ()-> lstMsgModel.addElement(str));

        broadcastMsg(str);
    }

    public void broadcastMsg( String str ) {
        try {
            for(Connection client : clients) {
                client.sendMsg(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void btnSend_actionPerformed(ActionEvent e) {
        broadcastMsg( this.txtInput.getText() );
    }

    public final static int DEFAULT_PORT = 6543;
    protected ServerSocket listen_socket;
    Thread thread;
    java.util.Vector<Connection> clients = new java.util.Vector<>();

    public void ServerListen() {
        try {
            listen_socket = new ServerSocket(DEFAULT_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        processMsg("Server: listening on port " + DEFAULT_PORT);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            while(true) {
                Socket client_socket = listen_socket.accept();
                Connection c = new Connection(client_socket, this);
                clients.add( c );
                processMsg( "One Client Comes in");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Connection extends Thread {
    protected Socket client;
    protected BufferedReader in;
    protected PrintWriter out;
    ChatServer server;

    public Connection(Socket client_socket, ChatServer server_frame) {
        client = client_socket;
        server = server_frame;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new java.io.PrintWriter(client.getOutputStream());
        }
        catch (IOException e) {
            try {
                client.close();
            }
            catch (IOException e2) {
                ;
            }
            e.printStackTrace();
            return;
        }
        this.start();
    }

    @Override
    public void run() {
        try {
            for(;;) {
                String line = receiveMsg();
                server.processMsg( line );
                if (line == null) {
                    break;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                client.close();
            }
            catch (IOException e2) {
                ;
            }
        }
    }

    public void sendMsg(String msg) throws IOException {
        out.println( msg );
        out.flush();
    }

    public String receiveMsg()  throws IOException {
        try {
            String msg = in.readLine();
            return msg;
        } catch(IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}