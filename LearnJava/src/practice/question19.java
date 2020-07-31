package practice;

/**
 * @author liuwenchen
 * @create 2020-07-02 14:12
 * 问题描述：输出9*9口诀。
 */
public class question19 {
    public static void main(String[] args) {
        for(int i=1;i<10;i++)
        {
            for(int j=1;j<10;j++)
            {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }
}
