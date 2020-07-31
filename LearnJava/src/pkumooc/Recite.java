package pkumooc;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwenchen
 * @create 2020-07-11 23:52
 */

public class Recite extends JFrame{
    JLabel lblWord = new JLabel("word");
    JLabel lblMeaning = new JLabel("meaning");

    public static void main(String[] args) {
        Recite f = new Recite();
        f.init();
        f.start();
    }

    public void init()
    {
        setSize(400,100);
        // FlowLayout是排版格式，这行放不下放下一行
        setLayout(new FlowLayout());
        getContentPane().add(lblWord);
        getContentPane().add(lblMeaning);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void readAll() throws IOException
    {
        String fileName = "C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\Recitewords.txt";
        String charset = "UTF-8";

        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(fileName),charset));

        String line;
        while((line = reader.readLine()) != null)
        {

            line = line.trim();
            if(line.length() == 0) {
                continue;
            }
            int idx = line.indexOf(" ");
            words.add(line.substring(0,idx));
            meanings.add(line.substring(idx + 1));
        }
    }

    List<String> words = new ArrayList<>();
    List<String> meanings = new ArrayList<>();
    int current = 0;

    public void start()
    {
        new Thread( ()->{
            try {
                readAll();
            }catch(FileNotFoundException ef){
                System.out.println("File Not Founded");

            }catch(IOException e)
            {
                System.out.println("IO Error");
            }

            new javax.swing.Timer(1000,(e)->
            {
                lblWord.setText(words.get(current));
                lblMeaning.setText(meanings.get(current));
                current++;
            }).start();
        }).start();
    }
}
