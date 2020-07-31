package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-02 10:53
 * 问题描述：将一个正整数分解质因数
 * 例如：输入90,打印出90=2*3*3*5
 */
public class question9 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please input n: ");
        int n=scanner.nextInt();
        System.out.printf(n+"=");
        int j=2;
        if(isPrime(n)==1) System.out.print(n);
        if(isPrime(n)==0)
        {
            while(n>1)
            {
                if(n%j==0)
                {
                    System.out.print(j);
                    if(j<=n/2) System.out.printf("*");
                    n/=j;
                }
                else j++;
            }
        }
    }
    private static int isPrime(int i)
    {
        int ret=1;
        int k;
        for (k=2;k<i-1;k++)
        {
            if(i%k==0)
            {
                ret=0;
                break;
            }
        }
        return ret;
    }
}