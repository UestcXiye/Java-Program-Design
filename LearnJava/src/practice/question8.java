package practice;

/**
 * @author liuwenchen
 * @create 2020-07-02 10:47
 * 问题描述：题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数，其各位数字立方和等于该数本身。
 * 例如：153是一个"水仙花数"，因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class question8 {
    public static void main(String[] args) {
        int a,b,c;
        for(int i=100;i<1000;i++)
        {
            int n=i;
            a=n%10;
            n/=10;
            b=n%10;
            c=n/10;
            if(i == a*a*a+b*b*b+c*c*c) System.out.println(i);
        }
    }
}
/*
153
370
371
407
 */