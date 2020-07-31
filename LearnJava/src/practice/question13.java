package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-02 12:34
 * 问题描述：一球从h米高度自由落下，每次落地后反跳回原高度的一半；再落下。
 * 求它在第n次落地时，共经过多少米？第n次反弹多高？
 */
public class question13 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Please input h and n: ");
        int h=scanner.nextInt(),n=scanner.nextInt();
        double sum=(double) h;
        double height=(double) h;
        if(n==1)
        {
            System.out.println("n=1,sum="+sum+",height="+height/2);
        }
        else
        {
            for(int i=1;i<n;i++)
            {
                sum+=height;
                height/=2;
            }
            System.out.println("n="+n+",sum="+sum+",height="+height/2);
        }
    }
}
