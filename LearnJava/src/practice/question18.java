package practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-02 13:59
 * 问题描述：输入三个整数x,y,z，请把这三个数由小到大输出
 */
public class question18 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please inout x,y,z: ");
        int[] a=new int[3];
        for(int i=0;i<3;i++) a[i]=scanner.nextInt();
        Arrays.sort(a);
        for(int i:a) System.out.print(i+" ");
    }
}