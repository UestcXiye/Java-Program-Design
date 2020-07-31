package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-02 13:37
 * 问题描述：输入某年某月某日，判断这一天是这一年的第几天？
 */
public class question17 {
    static int[] arr= new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("输入日期(eg: 2000 1 10):");
        int year=scanner.nextInt();
        int month=scanner.nextInt();
        int day=scanner.nextInt();
        int sum=day;
        for(int i=1;i<month;i++) sum+=arr[i];
        if((year%4==0 && year%100!=0)||(year%400==0))
            if(month>2) sum++;
        System.out.println(sum);
    }
}
