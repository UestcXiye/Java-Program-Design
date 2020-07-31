package pkumooc;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author liuwenchen
 * @create 2020-07-09 21:51
 */
public class TestMap {
    public static void main(String[] args) {
        //Map<String,String> map=new HashMap<String,String>();
        Map<String,String> map=new TreeMap<String,String>();
        map.put("b","Brazil");
        map.put("r","Russia");
        map.put("i","India");
        map.put("c","China");
        map.put("k","South Africa");

        System.out.println(map.get("k"));
        System.out.println();
        for(String key:map.keySet()) System.out.println(key+":"+map.get(key));
        System.out.println();
        for(String value:map.values()) System.out.println(value);
        System.out.println();
        for(Map.Entry<String,String> entry:map.entrySet()) System.out.println(entry.getKey()+":"+entry.getValue());
    }
}