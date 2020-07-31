package pkumooc;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-01 12:48
 */
public class GradeLevel {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Please input a grade: ");
        String grade=scanner.next();
        switch (grade)
        {
            case "A":
                System.out.println(grade+" is 85~100.");
                break;
            case "B":
                System.out.println(grade+" is 70~84.");
                break;
            case "C":
                System.out.println(grade+" is 60~69.");
                break;
            case "D":
                System.out.println(grade+" is <60.");
                break;
            default:
                System.out.println("input error.");
        }
    }
}
