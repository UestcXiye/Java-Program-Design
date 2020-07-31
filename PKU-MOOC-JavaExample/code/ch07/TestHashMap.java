import java.util.*;
class TestHashMap
{
	public static void main( String[] args){
		//Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map = new TreeMap<String, String>();
		map.put("one", "一");
		map.put("two", "二");
		map.put("three", "三");
		map.put("four", "四");
		map.put(new String("five"), "五");
		map.put(new String("five"), "五二");
		map.put("six", "四");

		System.out.println( map.get("three") );

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