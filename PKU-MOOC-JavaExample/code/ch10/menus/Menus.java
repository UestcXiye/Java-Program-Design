import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menus extends JPanel {
	static final class Faces
	{
		static Icon [] faces = new Icon[]{
			new ImageIcon("face0.gif"),
			new ImageIcon("face1.gif"),
			new ImageIcon("face2.gif"),
			new ImageIcon("face3.gif"),
			new ImageIcon("face4.gif")
		};
	}
	static final Boolean
		bT = new Boolean(true), 
		bF = new Boolean(false);
	// Dummy class to create type identifiers:
	static class MType { MType(int i) {} };
	static final MType
		mi = new MType(1), // Normal menu item
		cb = new MType(2), // Checkbox menu item
		rb = new MType(3); // Radio button menu item
	JTextField t = new JTextField(10);
	JLabel l = new JLabel("Icon Selected", 
		Faces.faces[0], JLabel.CENTER);
	ActionListener a1 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			t.setText(
				((JMenuItem)e.getSource()).getText());
		}
	};
	ActionListener a2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JMenuItem mi = (JMenuItem)e.getSource();
			l.setText(mi.getText());
			l.setIcon(mi.getIcon());
		}
	};
	// Store menu data as "resources":
	public Object[][] fileMenu = {
		// Menu name and accelerator:
		{ "File", new Character('F') },
		// Name type accel listener enabled
		{ "New", mi, new Character('N'), a1, bT },
		{ "Open", mi, new Character('O'), a1, bT },
		{ "Save", mi, new Character('S'), a1, bF },
		{ "Save As", mi, new Character('A'), a1, bF},
		{ null }, // Separator
		{ "Exit", mi, new Character('x'), a1, bT },
	};
	public Object[][] editMenu = {
		// Menu name:
		{ "Edit", new Character('E') },
		// Name type accel listener enabled
		{ "Cut", mi, new Character('t'), a1, bT },
		{ "Copy", mi, new Character('C'), a1, bT },
		{ "Paste", mi, new Character('P'), a1, bT },
		{ null }, // Separator
		{ "Select All", mi,new Character('l'),a1,bT},
	};
	public Object[][] helpMenu = {
		// Menu name:
		{ "Help", new Character('H') },
		// Name type accel listener enabled
		{ "Index", mi, new Character('I'), a1, bT },
		{ "Using help", mi,new Character('U'),a1,bT},
		{ null }, // Separator
		{ "About", mi, new Character('t'), a1, bT },
	};
	public Object[][] optionMenu = {
		// Menu name:
		{ "Options", new Character('O') },
		// Name type accel listener enabled
		{ "Option 1", cb, new Character('1'), a1,bT},
		{ "Option 2", cb, new Character('2'), a1,bT},
	};
	public Object[][] faceMenu = {
		// Menu name:
		{ "Faces", new Character('a') },
		// Optinal last element is icon
		{ "Face 0", rb, new Character('0'), a2, bT, 
			Faces.faces[0] },
		{ "Face 1", rb, new Character('1'), a2, bT, 
			Faces.faces[1] },
		{ "Face 2", rb, new Character('2'), a2, bT, 
			Faces.faces[2] },
		{ "Face 3", rb, new Character('3'), a2, bT, 
			Faces.faces[3] },
		{ "Face 4", rb, new Character('4'), a2, bT, 
			Faces.faces[4] },
	};
	public Object[] menuBar = {
		fileMenu, editMenu, faceMenu, 
		optionMenu, helpMenu,
	};
	static public JMenuBar
	createMenuBar(Object[] menuBarData) {
		JMenuBar menuBar = new JMenuBar();
		for(int i = 0; i < menuBarData.length; i++)
			menuBar.add(
				createMenu((Object[][])menuBarData[i]));
		return menuBar;
	}
	static ButtonGroup bgroup;
	static public JMenu 
	createMenu(Object[][] menuData) {
		JMenu menu = new JMenu();
		menu.setText((String)menuData[0][0]);
		menu.setMnemonic(
			((Character)menuData[0][1]).charValue());
		// Create redundantly, in case there are
		// any radio buttons:
		bgroup = new ButtonGroup();
		for(int i = 1; i < menuData.length; i++) {
			if(menuData[i][0] == null)
				menu.add(new JSeparator());
			else
				menu.add(createMenuItem(menuData[i]));
		}
		return menu;
	}
	static public JMenuItem 
	createMenuItem(Object[] data) {
		JMenuItem m = null;
		MType type = (MType)data[1];
		if(type == mi)
			m = new JMenuItem();
		else if(type == cb)
			m = new JCheckBoxMenuItem();
		else if(type == rb) {
			m = new JRadioButtonMenuItem();
			bgroup.add(m);
		}
		m.setText((String)data[0]);
		m.setMnemonic(
			((Character)data[2]).charValue());
		m.addActionListener(
			(ActionListener)data[3]);
		m.setEnabled(
			((Boolean)data[4]).booleanValue());
		if(data.length == 6)
			m.setIcon((Icon)data[5]);
		return m;
	}
	Menus() {
		setLayout(new BorderLayout());
		add(createMenuBar(menuBar), 
			BorderLayout.NORTH);
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(t, BorderLayout.NORTH);
		p.add(l, BorderLayout.CENTER);
		add(p, BorderLayout.CENTER);
	}
	public static void main(String args[]) {
		JPanel p = new Menus();
		JFrame frame = new JFrame("TestPopup");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		frame.getContentPane().add(
			p, BorderLayout.CENTER);
		frame.setSize(400,300);
		frame.setVisible(true);
	}
}
