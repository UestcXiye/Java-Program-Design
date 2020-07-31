package pkumooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author liuwenchen
 * @create 2020-06-30 23:24
 */
public class AppLineInOut {
    public static void main(String[] args) {
        String s="";
        System.out.print("Please input a line: ");
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            s=in.readLine();
        }catch(IOException e){}
        System.out.println("You have entered: "+s);
    }
}
