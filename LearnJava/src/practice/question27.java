package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-03 12:38
 * 问题描述：给一个正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
 */
public class question27 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Please input n: ");
        int n=scanner.nextInt();
        String s=String.valueOf(n);
        char[] chars=s.toCharArray();
        System.out.println(s.length()+" "+chars.length);
        for(int i=chars.length-1;i>=0;i--) System.out.print(chars[i]+" ");
    }
}