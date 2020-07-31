package pkumooc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author liuwenchen
 * @create 2020-07-09 16:09
 */
public class TryWithResourcesTest {
    public static void main(String[] args) {

    }
    static String readFirstLineFromFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /**
     * 这种在try后面加个括号，再初始化对象的语法就叫try-with-resources。
     * 实际上，相当于下面的代码:
     */
    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            if(br != null) br.close();
        }
    }
}
