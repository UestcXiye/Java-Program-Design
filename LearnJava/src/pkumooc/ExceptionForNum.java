package pkumooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author liuwenchen
 * @create 2020-07-09 11:36
 */
public class ExceptionForNum {
    public static void main(String[] args) {
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please input a number: ");
            String s=in.readLine();
            int n=Integer.parseInt(s);
        }catch (IOException e){
            e.printStackTrace();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
}