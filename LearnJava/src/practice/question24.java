package practice;

/**
 * @author liuwenchen
 * @create 2020-07-03 11:54
 * 问题描述：求1+2!+3!+...+20!的和
 */
public class question24 {
    public static void main(String[] args) {
        long sum=0;
        for(int i=1;i<=20;i++) sum+=factorial(i);
        System.out.println(sum);
    }

    private static long factorial(int i)
    {
        long ans=1;
        for(int j=1;j<=i;j++) ans*=j;
        return ans;
    }
}
