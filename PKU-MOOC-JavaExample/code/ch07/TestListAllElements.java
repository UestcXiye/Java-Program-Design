import java.util.*;
public class TestListAllElements{
	public static void main(String[] args) {
		Vector h = new Vector();
		h.add("1st");
		h.add("2nd");
		h.add("3rd");
		h.add("4th");
		h.add("5th");
		printAll((Object)h);
		printAll((Collection)h);
		printAll((List)h);
		printAll((Vector)h);
		printAllGetByIndex( h );

	}
	public static void printAll(Object s){
		System.out.println(s);
	}
	public static void printAll( Collection s ){
		Iterator it = s.iterator();
		while( it.hasNext() ){
			System.out.println( it.next() );
		}
	}
	public static void printAll( List s ){
		ListIterator it = s.listIterator();
		while( it.hasNext() ){
			System.out.println( it.next() );
		}
		while( it.hasPrevious() ){
			System.out.println( it.previous() );
		}
		
	}
	public static void printAll( Vector s ){
		Enumeration em = s.elements();
		while(em.hasMoreElements()) {
			 System.out.println(em.nextElement());
		}
	}
	public static void printAllGetByIndex( List s ){
		int size = s.size();
		for( int i=0; i<size; i++ ){
			System.out.println(s.get(i));
		}
	}

}
