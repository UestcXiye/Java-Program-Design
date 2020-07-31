package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-03 10:48
 * 问题描述：打印菱形
 */
public class question22 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Please input n: ");
        int n=scanner.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int k=n-1-i;k>0;k--) System.out.print(" ");
            for(int j=0;j<=2*i;j++) System.out.print("*");
            System.out.println();
        }
        n--;
        for(int i=n;i>0;i--)
        {
            for(int k=n-i+1;k>0;k--) System.out.print(" ");
            for(int j=0;j<=2*i-2;j++) System.out.print("*");
            System.out.println();
        }
    }
}