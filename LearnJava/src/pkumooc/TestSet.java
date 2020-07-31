package pkumooc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenchen
 * @create 2020-07-09 21:28
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> set=new HashSet<String>();
        set.add("Brazil");
        set.add("Russia");
        set.add("India");
        set.add("China");
        set.add("South Africa");

        System.out.println(set.contains("China"));
        for(String obj:set) System.out.println(obj);
    }
}