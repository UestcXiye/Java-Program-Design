package practice;

/**
 * @author liuwenchen
 * @create 2020-07-01 21:37
 * 问题描述：顺序输出1到100之间所有能被7整除的整数
 */
public class question4 {
    public static void main(String[] args) {
        System.out.printf("1到100之间所有能被7整除的整数: ");
        for(int i=1;i<=100;i++)
        {
            if(i%7==0) System.out.printf(i+" ");
        }
    }
}
