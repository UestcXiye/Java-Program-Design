package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-03 12:11
 * 问题描述：有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。
 * 问第4个人岁数，他说比第3个人大2岁。
 * 问第三个人，又说比第2人大两岁。
 * 问第2个人，说比第一个人大两岁。
 * 最后问第一个人，他说是10岁。请问第五个人多大？
 */
public class question26 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Please input n and t: ");
        int n=scanner.nextInt(),t=scanner.nextInt();
        System.out.println(Getage(n,t));
    }

    private static int Getage(int n,int t)
    {
        if(n==1) return 10;
        return t+Getage(n-1,t);
    }
}