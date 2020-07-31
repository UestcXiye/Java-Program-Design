package pkumooc;

import java.util.regex.Pattern;

/**
 * @author liuwenchen
 * @create 2020-07-12 10:34
 */
public class RegexSplitter {
    public static void main(String[] args) {
        String string=new String("one,two,three four , five");
        Pattern pattern=Pattern.compile("[,\\s]+");
        String[] result=pattern.split(string);
        for(String s:result) System.out.println(s);
    }
}
