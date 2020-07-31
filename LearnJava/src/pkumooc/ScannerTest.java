package pkumooc; /**
 * @author liuwenchen
 * @create 2020-06-30 23:13
 */
import java.util.Scanner;
class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("请输入一个数:");
        int a=scanner.nextInt();
        System.out.printf("%d的平方是%d。",a,a*a);
    }
}
