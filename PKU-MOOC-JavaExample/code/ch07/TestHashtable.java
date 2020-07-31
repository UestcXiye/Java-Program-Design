import java.util.*;
class TestHashtable
{
	public static void main( String[] args){
		Hashtable ht = new Hashtable();
		ht.put("one", new Integer(1));
		ht.put("two", new Integer(2));
		ht.put("three", new Integer(3));
		ht.put("four", new Integer(4));
		ht.put("five", new Integer(5));

		Enumeration em = ht.keys();
		while( em.hasMoreElements() ){
			Object key = em.nextElement();
			Object value = ht.get( key );
			System.out.println( ""+key+"="+value);
		}
	}
}
