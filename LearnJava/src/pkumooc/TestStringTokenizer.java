package pkumooc;

import java.util.StringTokenizer;

/**
 * @author liuwenchen
 * @create 2020-07-09 19:46
 */
public class TestStringTokenizer {
    public static void main(String[] args) {
        StringTokenizer st=new StringTokenizer("this is a test"," ");
        while(st.hasMoreTokens())
        {
            System.out.println(st.nextToken());
        }
        st=new StringTokenizer("123,456,789",",");
        double sum=0.0;
        while(st.hasMoreTokens())
        {
            sum+=Double.parseDouble(st.nextToken());
        }
        System.out.println(sum);
    }
}
