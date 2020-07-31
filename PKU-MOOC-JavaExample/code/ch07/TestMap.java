import java.util.*;
class TestMap
{
	public static void main( String[] args){
		//Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map = new TreeMap<String, String>();
		map.put("b", "Brazil");
		map.put("r", "Russia");
		map.put("i", "India");
		map.put("c", "China");
		map.put("k", "South Africa");
		//map.put(new String("c"), "China2");
		//map.put(new String("b"), "Brazil3");

		System.out.println( map.get("c") );

		for( String key : map.keySet() )
			System.out.println( key +":" + map.get(key) );

		for( String value  : map.values() )
			System.out.println( value );

		for( Map.Entry<String,String> entry : map.entrySet() )
			System.out.println( entry.getKey() +":" + entry.getValue() );

		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String,String> entry = (Map.Entry<String,String>)it.next();
			System.out.println( entry.getKey() +":" + entry.getValue() );
		}
	}
}