package pkumooc;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-01 12:31
 */
public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please input a year: ");
        int year=scanner.nextInt();
        if ((year%4==0 && year%100!=0)||(year%400==0)) {
            System.out.println(year+" is a leap year.");
        } else {
            System.out.println(year+" is not a leap year.");
        }
    }
}