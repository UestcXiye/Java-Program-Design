package pkumooc;

import java.io.*;

/**
 * @author liuwenchen
 * @create 2020-07-11 12:39
 */
public class FileCopyByLine {
    public static void main(String[] args) {
        try {
            FileReader input = new FileReader("C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\FileCopyByLine.java");
            BufferedReader br = new BufferedReader(input);
            FileWriter output = new FileWriter("C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\FileCopyByLine.txt");
            BufferedWriter bw = new BufferedWriter(output);

            String s = br.readLine();
            while ( s!=null ) {
                bw.write(s);
                bw.newLine();
                System.out.println(s);
                s = br.readLine();
            }
            br.close();
            bw.close();
        }catch(IOException e){e.printStackTrace();}
    }
}
