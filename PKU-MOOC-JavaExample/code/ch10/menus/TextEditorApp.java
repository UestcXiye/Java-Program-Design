import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

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

	void initTextPane(){ //将文本框放入有滚动对象，并加入到Frame中
		getContentPane().add( new JScrollPane(text) );
	}

	JTextPane text = new JTextPane();  //文本框
	JFileChooser filechooser = new JFileChooser(); //文件选择对话框
	JColorChooser colorchooser = new JColorChooser(); //颜色选择对话框
	JDialog about = new JDialog(this); //关于对话框
	JMenuBar menubar = new JMenuBar(); //菜单

	JMenu [] menus = new JMenu[] {
		new JMenu("File"),
		new JMenu("Edit"),
		new JMenu("Help")
	};
	JMenuItem menuitems [][] = new JMenuItem[][]{{
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

	void initMenu(){  //初始化菜单
		for( int i=0; i<menus.length; i++ ){
			menubar.add( menus[i] );
			for( int j=0; j<menuitems[i].length; j++ ){
				menus[i].add( menuitems[i][j] );
				menuitems[i][j].addActionListener( action );
			}
		}
		this.setJMenuBar( menubar );
	}

	ActionListener action = new ActionListener(){ //菜单事件处理
		public void actionPerformed( ActionEvent e ){
			JMenuItem mi = (JMenuItem)e.getSource();
			String id = mi.getText();
			if( id.equals("New" )){
				text.setText("");
				file = null;
			}else if( id.equals("Open...")){
				if( file != null ) filechooser.setSelectedFile( file );
				int returnVal = filechooser.showOpenDialog(
					TextEditorFrame.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = filechooser.getSelectedFile();
					openFile();
				}
			}else if( id.equals("Save...")){
				if( file != null ) filechooser.setSelectedFile( file );
				int returnVal = filechooser.showSaveDialog(
					TextEditorFrame.this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					file = filechooser.getSelectedFile();
					saveFile();
				}
			}else if( id.equals("Exit")){
				System.exit(0);
			}else if( id.equals("Cut")){
				text.cut();
			}else if( id.equals("Copy")){
				text.copy();
			}else if( id.equals("Paste")){
				text.paste();
			}else if( id.equals("Color...")){
				color = JColorChooser.showDialog( 
					TextEditorFrame.this, "", color );
				text.setForeground(color);
			}else if( id.equals("About")){
				about.setSize(100,50);
				about.show();
			}
		}
    };

	void saveFile(){ //保存文件，将字符写入文件
		try{
			FileWriter fw = new FileWriter( file );
			fw.write( text.getText() );
			fw.close();
		}catch(Exception e ){ e.printStackTrace(); }
	}
	void openFile(){ //读入文件，并将字符置入文本框中
		try{
			FileReader fr = new FileReader( file );
			int len = (int) file.length();
			char [] buffer = new char[len];
			fr.read( buffer, 0, len );
			fr.close();
			text.setText( new String( buffer ) );
		}catch(Exception e ){ e.printStackTrace(); }
	}

	void initAboutDialog(){  // 初始化对话框
		about.getContentPane().add( new JLabel("简单编辑器 V1.0") );
		about.setModal( true );  
		about.setSize(100,50 );
	}
	
	JToolBar toolbar = new JToolBar();  //工具条
	JButton [] buttons = new JButton[] {
		new JButton( "", new ImageIcon("copy.jpg") ),
		new JButton( "", new ImageIcon("cut.jpg") ),
		new JButton( "", new ImageIcon("paste.jpg") )
	};
		
	void initToolBar(){  //加入工具条
		for( int i=0; i<buttons.length; i++)
			toolbar.add( buttons[i] );
		buttons[0].setToolTipText( "copy" );
		buttons[0].addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				text.copy();
			}
		});
		buttons[1].setToolTipText( "cut" );
		buttons[1].addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				text.cut();
			}
		});
		buttons[2].setToolTipText( "paste" );
		buttons[2].addActionListener( new ActionListener(){
			public void actionPerformed( ActionEvent e ){
				text.paste();
			}
		});
		this.getContentPane().add( toolbar, BorderLayout.NORTH );
		toolbar.setRollover(true);
	}
}

class TextEditorApp  //应用程序
{
	public static void main( String [] args){
		TextEditorFrame f = new TextEditorFrame();
		f.setTitle( "简单的编辑器");
		f.setSize( 400, 300 );
		f.show();
	}
}

