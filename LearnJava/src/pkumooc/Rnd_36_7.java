package pkumooc;

/**
 * @author liuwenchen
 * @create 2020-07-01 15:50
 */

public class Rnd_36_7 {
    public static void main(String[] args) {
        int[] a=new int[7];
        for(int i=0;i<a.length;i++)
        {
            one_num:while(true)
            {
                a[i]=(int)(Math.random()*36)+1;
                for(int j=0;j<i;j++)
                    if(a[i] == a[j]) continue one_num;
                break;
            }
        }
        System.out.println("**** pkumooc.Rnd_36_7 ****");
        for(int num:a) System.out.print(num+" ");
    }
}