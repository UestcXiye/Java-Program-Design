package practice;
import java.util.Scanner;
/**
 * @author liuwenchen
 * @create 2020-07-01 21:39
 * 问题描述：已知2000.1.1是星期六，根据任意给定的日期（2000年以后的），请编程计算出该天是星期几
 */
public class question5 {
    static int arr[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    static int ans[] = {6,7,1,2,3,4,5};
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入日期(eg: 2000 1 10):");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int tot = 0;
        if(year>2000)
        {
            tot += 1;//2000 闰年
            tot += 365*(year-2000);
            tot += (year-1-2000)/4;
            tot -= (year-1-2000)/100;
            tot += (year-1-2000)/400;
        }
        for(int i=1;i<month;i++)
        {
            if(i==2&&year%4==0&&(year%100!=0||year%400==0))tot++;
            tot+=arr[i-1];
        }
        tot+=day-1;
        System.out.println(ans[tot%7]);
    }
}