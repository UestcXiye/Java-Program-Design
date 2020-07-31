package practice;

/**
 * @author liuwenchen
 * @create 2020-07-02 13:31
 * 问题描述：一个整数，它加上100后是一个完全平方数，再加上268又是一个完全平方数，请问该数是多少？
 */
public class question16 {
    public static void main(String[] args) {
        for(int i=1;i<=100000;i++)
        {
            int n1=(int) Math.sqrt(i+100),n2=(int) Math.sqrt(i+268);
            if((n1*n1==(i+100)) && (n2*n2==(i+268))) System.out.printf(i+" ");
        }
    }
}
