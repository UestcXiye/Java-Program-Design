package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-29 17:38
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

class TextEditorFrame extends JFrame
{

    File file = null;
    Color color = Color.black;

    TextEditorFrame(){
        initTextPane();
        initMenu();
        initAboutDialog();
        initToolBar();
    }

    void initTextPane(){
        getContentPane().add( new JScrollPane(text) );
    }

    JTextPane text = new JTextPane();
    JFileChooser filechooser = new JFileChooser();
    JColorChooser colorchooser = new JColorChooser();
    JDialog about = new JDialog(this);
    JMenuBar menubar = new JMenuBar();

    JMenu [] menus = new JMenu[] {
            new JMenu("File"),
            new JMenu("Edit"),
            new JMenu("Help")
    };
    JMenuItem[][] menuitems = new JMenuItem[][]{{
            new JMenuItem("New"),
            new JMenuItem("Open..."),
            new JMenuItem("Save..."),
            new JMenuItem("Exit")},{
            new JMenuItem("Copy"),
            new JMenuItem("Cut"),
            new JMenuItem("Paste"),
            new JMenuItem("Color...")},{
            new JMenuItem("About")}
    };

    void initMenu(){
        for( int i=0; i<menus.length; i++ ){
            menubar.add( menus[i] );
            for( int j=0; j<menuitems[i].length; j++ ){
                menus[i].add( menuitems[i][j] );
                menuitems[i][j].addActionListener( action );
            }
        }
        this.setJMenuBar( menubar );
    }

    ActionListener action = e -> {
        JMenuItem mi = (JMenuItem)e.getSource();
        String id = mi.getText();
        if( "New".equals(id)){
            text.setText("");
            file = null;
        }else if( "Open...".equals(id)){
            if( file != null ) {
                filechooser.setSelectedFile( file );
            }
            int returnVal = filechooser.showOpenDialog(
                    TextEditorFrame.this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                file = filechooser.getSelectedFile();
                openFile();
            }
        }else if( "Save...".equals(id)){
            if( file != null ) {
                filechooser.setSelectedFile( file );
            }
            int returnVal = filechooser.showSaveDialog(
                    TextEditorFrame.this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                file = filechooser.getSelectedFile();
                saveFile();
            }
        }else if( "Exit".equals(id)){
            System.exit(0);
        }else if( "Cut".equals(id)){
            text.cut();
        }else if( "Copy".equals(id)){
            text.copy();
        }else if( "Paste".equals(id)){
            text.paste();
        }else if( "Color...".equals(id)){
            color = JColorChooser.showDialog(
                    TextEditorFrame.this, "", color );
            text.setForeground(color);
        }else if( "About".equals(id)){
            about.setSize(100,50);
            about.setVisible(true);
        }
    };

    void saveFile(){
        try{
            FileWriter fw = new FileWriter( file );
            fw.write( text.getText() );
            fw.close();
        }catch(Exception e ){ e.printStackTrace(); }
    }
    void openFile(){
        try{
            FileReader fr = new FileReader( file );
            int len = (int) file.length();
            char [] buffer = new char[len];
            fr.read( buffer, 0, len );
            fr.close();
            text.setText( new String( buffer ) );
        }catch(Exception e ){ e.printStackTrace(); }
    }

    void initAboutDialog(){
        about.getContentPane().add( new JLabel("简单编辑器 V1.0") );
        about.setModal( true );
        about.setSize(100,50 );
    }

    JToolBar toolbar = new JToolBar();
    JButton [] buttons = new JButton[] {
            new JButton( "", new ImageIcon("C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\copy.jpg") ),
            new JButton( "", new ImageIcon("C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\cut.jpg") ),
            new JButton( "", new ImageIcon("C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\paste.jpg") )
    };

    void initToolBar(){
        for (JButton button : buttons) {
            toolbar.add(button);
        }
        buttons[0].setToolTipText( "copy" );
        buttons[0].addActionListener(e -> text.copy());
        buttons[1].setToolTipText( "cut" );
        buttons[1].addActionListener(e -> text.cut());
        buttons[2].setToolTipText( "paste" );
        buttons[2].addActionListener(e -> text.paste());
        this.getContentPane().add( toolbar, BorderLayout.NORTH );
        toolbar.setRollover(true);
    }
}

public class TextEditorApp
{
    public static void main( String [] args){
        TextEditorFrame f = new TextEditorFrame();
        f.setTitle( "简单的编辑器");
        f.setSize( 800, 600 );
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}