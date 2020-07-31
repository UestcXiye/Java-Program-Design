package practice;

/**
 * @author liuwenchen
 * @create 2020-07-02 12:46
 * 问题描述：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 */
public class question14 {
    public static void main(String[] args) {
        int count=0;
        for(int a=1;a<5;a++)
        {
            for(int b=1;b<5;b++)
            {
                for(int c=1;c<5;c++)
                {
                    if(a!=b && a!=c && b!=c)
                    {
                        System.out.printf(100*a+10*b+c+" ");
                        count++;
                    }
                }
            }
        }
        System.out.println();
        System.out.println(count);
    }
}