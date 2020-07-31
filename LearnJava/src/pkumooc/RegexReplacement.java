package pkumooc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author liuwenchen
 * @create 2020-07-12 10:54
 */
public class RegexReplacement {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("cat");
        Matcher matcher=pattern.matcher("one cat,two cats in the yard.");
        StringBuffer stringBuffer=new StringBuffer();
        while(matcher.find())
        {
            matcher.appendReplacement(stringBuffer,"big $0");
        }
        matcher.appendTail(stringBuffer);
        System.out.println(stringBuffer.toString());
    }
}
