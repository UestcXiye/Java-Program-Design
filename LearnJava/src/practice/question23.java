package practice;

/**
 * @author liuwenchen
 * @create 2020-07-03 11:43
 * 问题描述：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和。
 */
public class question23 {
    public static void main(String[] args) {
        double sum=0.0;
        int denominator=1;
        int molecular=2;
        for(int i=1;i<20;i++)
        {
            sum+=(double) molecular/denominator;
            int temp=denominator;
            denominator=molecular;
            molecular=temp+denominator;
        }
        System.out.println(sum);
    }
}
