package pkumooc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author liuwenchen
 * @create 2020-07-11 11:56
 */
public class CopyFile {
    public static void main(String[] args) {
        String sourceFile="C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\CopyFile-in.txt";
        String targetFile="C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\CopyFile-out.txt";
        copy01(sourceFile,targetFile);
    }
    public static void copy01(String sourceFile,String targetFile)
    {
//	创建对象
        FileReader fr=null;
        FileWriter fw=null;
        try {
            fr=new FileReader(sourceFile);
            fw=new FileWriter(targetFile);
//		循环读和循环写
            int len=0;
            while((len=fr.read())!=-1)
            {
                fw.write((char)len);
            }



        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally
        {
            if(fr!=null)
            {
                try {
                    fr.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(fw!=null)
            {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    }
}
