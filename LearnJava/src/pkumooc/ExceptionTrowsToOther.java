package pkumooc;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author liuwenchen
 * @create 2020-07-09 16:00
 */
public class ExceptionTrowsToOther {
    public static void main(String[] args){
        try{
            System.out.println("====Before====");
            readFile();
            System.out.println("====After====");
        }catch(IOException e){ System.out.println(e);}
    }

    public static void readFile()throws IOException {
        FileInputStream in=new FileInputStream("myfile.txt");
        int b;
        b = in.read();
        while(b!= -1)
        {
            System.out.print((char)b);
            b = in.read();
        }
        in.close();
    }
}