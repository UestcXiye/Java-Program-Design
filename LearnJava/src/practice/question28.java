package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-03 13:09
 * 问题描述：求一个3*3矩阵对角线元素之和
 */
public class question28 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[][] a=new int[3][3];
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                a[i][j]=scanner.nextInt();
        System.out.println(a[0][0]+a[1][1]+a[2][2]);
        System.out.println(a[2][0]+a[1][1]+a[0][2]);
    }
}