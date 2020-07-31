import java.awt.*;   
import java.awt.event.*;

public class TestMenuItem{  
    public static void main(String[] args) {
		Frame f = new Frame("Menu");
		MenuBar mb = new MenuBar();
		f.setMenuBar(mb);

		Menu m1 = new Menu("File");
		Menu m2 = new Menu("Edit");
		Menu m3 = new Menu("Help");

		mb.add(m1);           
		mb.add(m2);
		mb.setHelpMenu(m3);		
		
		MenuItem m11 = new MenuItem("New");
		MenuItem m12 = new MenuItem("Save");
		MenuItem m13 = new MenuItem("Load");
		MenuItem m14 = new MenuItem("Quit");
		
		m1.add(m11);    
		m1.add(m12);
		m1.add(m13);    
		m1.addSeparator();
		m1.add(m14);					
		
		m14.addActionListener( new ActionListener(){ 
			public void actionPerformed( ActionEvent e ){
				System.exit(0);
			} 
		});
		
		f.setSize(250,200);
		f.setVisible(true);
	}
}
