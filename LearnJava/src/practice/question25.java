package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-03 12:02
 * 问题描述：利用递归方法求n!
 */
public class question25 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Please input n: ");
        int n=scanner.nextInt();
        System.out.println(factorial(n));
    }

    private static long factorial(int i)
    {
        if(i==1) return 1;
        return i*factorial(i-1);
    }
}