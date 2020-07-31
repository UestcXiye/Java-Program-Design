package pkumooc;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author liuwenchen
 * @create 2020-07-12 10:39
 */
public class RegexEmailValidate {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please input an email address: ");
        String email=scanner.nextLine();

        System.out.println(isEmail(email));
    }

    public static boolean isEmail(String email)
    {
        String pattern="^[^@]+@[\\w]+(\\.[\\w]+)*$";
        return Pattern.matches(pattern,email);
    }
}
