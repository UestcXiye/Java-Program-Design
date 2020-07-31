package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-09 19:15
 */
public class StringAndStringBuffer {
    public static void main(String[] args) {
        String s="",a="l";
        StringBuffer sb=new StringBuffer();
        final int N=10000;

        long t0=System.currentTimeMillis();
        for(int i=0;i<N;i++) s+=a;
        long t1=System.currentTimeMillis();
        for(int i=0;i<N;i++) sb.append(a);
        long t2=System.currentTimeMillis();

        System.out.println(t1-t0);
        System.out.println(t2-t0);
        System.out.println(s);
    }
}