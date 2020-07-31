package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-01 17:45
 * 问题描述：输入整数a和b，求其最大公约数和最小公倍数
 */
public class question1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please input a and b: ");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        System.out.printf("%d与%d的最大公约数为:%d\n",a,b,gcd(a,b));
        System.out.printf("%d与%d的最小公倍数为:%d\n",a,b,lcm(a,b));
    }
    private static int gcd(int a,int b) {
        if(b!=0)return gcd(b,a%b);
        else return a;
    }
    private static int lcm(int a,int b) {
        return a*b/gcd(a,b);
    }
}