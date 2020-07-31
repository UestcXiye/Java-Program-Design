package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-01 15:33
 */
public class Prime100Continue{
    public static void main(String[] args) {
        System.out.println(" **** 100--200的质数 ****");
        int n=0;
        outer: for(int i=101;i<200;i+=2)
        {
            for(int j=2;j<i;j++)
            {
                if(i%j==0)
                    continue outer;
            }
            System.out.print(" "+i);
            n++;
            if(n<10)
                continue;
            System.out.println();
            n=0;
        }
        System.out.println();
    }
}