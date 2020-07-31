package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-02 11:46
 * 问题描述：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制。
 * 输出结果的形式如：2+22+222=246；
 */
public class question11 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Please input a and n: ");
        int a=scanner.nextInt(),n=scanner.nextInt();
        if(a!=0)
        {
            int i=1;
            long sum=0;
            int[] arr=new int[n];
            arr[0]=a;
            while(i<n)
            {
                a*=10;
                arr[i]=a+arr[i-1];
                i++;
            }
            for(int s:arr)
            {
                sum+=s;
                if(s==arr[i-1]) System.out.print(s);
                else System.out.print(s+"+");
            }
            System.out.println("="+sum);
        }
        else
        {
            if(n>1) for(int i=0;i<n-1;i++) System.out.print(0+"+");
            System.out.println(0+"="+0);
        }
    }
}
