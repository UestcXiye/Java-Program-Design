package practice;

import java.util.Scanner;
/**
 * @author liuwenchen
 * @create 2020-07-01 17:51
 * 问题描述：输入若干个整数，求其最大值、最小值和平均值
 */
public class question2 {
    public static void main(String[] args) {
        final int INF=0x3f3f3f;
        int min=INF;
        int max=-INF;
        double average=0.0;
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Please input the n: ");
        int n=scanner.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=scanner.nextInt();
            if(a[i]<min) min=a[i];
            if(a[i]>max) max=a[i];
            average+=(double)a[i]/n;
        }
        System.out.printf("最大值:%d,最小值:%d,平均值:%f",max,min,average);
    }
}