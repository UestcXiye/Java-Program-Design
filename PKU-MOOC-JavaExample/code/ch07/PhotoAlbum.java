import java.util.*;

class Photo {
	private int PhotoNumber;
		Photo(int i) {
		PhotoNumber = i;
	}
	public String toString() {
		return "This is Photo #" + PhotoNumber;
	}
}

class Printer {
	static void printAll(Enumeration e) {
		while(e.hasMoreElements())
			System.out.println(e.nextElement());
	}
}

public class PhotoAlbum {
	public static void main(String[] args) {
		Vector v = new Vector();
		for(int i = 0; i < 3; i++)
			v.addElement(new Photo(i));
		Printer.printAll(v.elements());
	}
}
