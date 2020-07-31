package practice;

/**
 * @author liuwenchen
 * @create 2020-07-02 10:43
 * 问题描述：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
 */
public class question7 {
    public static void main(String[] args) {
        int i;
        long[] a=new long[36];
        a[0]=a[1]=1;
        System.out.println("第1个月有兔子1对"+", "+"总数是"+2);
        System.out.println("第2个月有兔子1对"+", "+"总数是"+2);
        for(i=2;i<36;i++)
        {
            a[i]=a[i-1]+a[i-2];
            System.out.println("第"+i+"个月有兔子"+a[i]+"对,总数是"+2*a[i]);
        }
    }
}
