import java.util.*;
class TestHashMap
{
	public static void main( String[] args){
		Map<String, String> map = new HashMap<String, String>();
		map.put("b", "Brazil");
		map.put("r", "Russia");
		map.put("i", "India");
		map.put("c", "China");
		map.put("k", "South Africa");

		System.out.println( map.get("c") );

		for( String key : map.keySet() )
			System.out.println( key +":" + map.get(key) );

		for( String value  : map.values() )
			System.out.println( value );

	}
}