package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-01 21:55
 * 问题描述：猜数游戏，随机生成一个整数（0-100），用户输入他所猜的数，程序回答大了或小了，用户再输入他所猜的数，直至猜对了为止
 */
public class question6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int guess=(int) (Math.random()*100);
        int n=-1;
        System.out.printf("请输入一个数： ");
        while (n!=guess)
        {
            n=scanner.nextInt();
            if(n<guess) System.out.println("猜小了");
            else if(n>guess) System.out.println("猜大了");
        }
        System.out.println("恭喜你，猜对了！");
    }
}
