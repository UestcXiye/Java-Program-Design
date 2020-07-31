package practice;

import java.util.Scanner;

/**
 * @author liuwenchen
 * @create 2020-07-02 11:34
 * 问题描述：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数
 */
public class question10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Please input a string: ");
        String s=scanner.nextLine();
        int LetterCount=0;
        int NumberCount=0;
        int OtherCount=0;
        int SpaceCount=0;
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++)
        {
            if(Character.isLetter(chars[i])) LetterCount++;
            else if(Character.isDigit(chars[i])) NumberCount++;
            else if(Character.isSpaceChar(chars[i])) SpaceCount++;
            else OtherCount++;
        }
        System.out.println("字母个数："+LetterCount);
        System.out.println("数字个数："+NumberCount);
        System.out.println("空格个数："+SpaceCount);
        System.out.println("其他字符个数："+OtherCount);
    }
}
