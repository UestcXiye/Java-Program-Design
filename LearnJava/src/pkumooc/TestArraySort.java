package pkumooc;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liuwenchen
 * @create 2020-07-09 22:05
 */
public class TestArraySort {
    static Random r=new Random();
    static String source="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    static char[] src=source.toCharArray();
    public static void main(String[] args) {
        String[] s=randStrings(4,10);
        print(s);
        Arrays.<String>sort(s);
        print(s);
        int loc=Arrays.<String>binarySearch(s,s[2]);
        System.out.println("Location of "+s[2]+" is "+loc);
    }

    private static void print(String[] s) {
        for(int i=0;i<s.length;i++) {
            System.out.print(s[i]+" ");
        }
        System.out.println();
    }

    private static String[] randStrings(int length, int size) {
        String[] s=new String[size];
        for(int i=0;i<size;i++) {
            s[i]=randString(length);
        }
        return s;
    }

    private static String randString(int length) {
        char[] buf=new char[length];

        for(int i=0;i<length;i++) {
            buf[i]=src[Math.abs(r.nextInt())%src.length];
        }
        return new String(buf);
    }
}