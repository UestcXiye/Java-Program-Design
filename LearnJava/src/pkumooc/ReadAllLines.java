package pkumooc;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author liuwenchen
 * @create 2020-07-11 12:14
 */

public class ReadAllLines {
    public static void main(String[] args)throws IOException {
        String path="C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\ReadAllLines.java";
        List<String> list= Files.readAllLines(Paths.get(path),Charset.forName("utf8"));
        // or Charset.defaultCharset()
        for(String s:list) System.out.println(s);
    }
}