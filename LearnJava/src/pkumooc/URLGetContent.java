package pkumooc;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author liuwenchen
 * @create 2020-07-11 15:22
 */
public class URLGetContent extends JFrame {
    TextArea textArea=new TextArea("downloading:\n");

    public static void main(String[] args) {
        URLGetContent frame=new URLGetContent();
        frame.setVisible(true);
        SwingUtilities.invokeLater(()->{
            frame.init();
            frame.download();
        });
    }

    public void init()
    {
        setTitle("URLGetContent");
        setSize(400,300);
        getContentPane().add(textArea);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void download()
    {
        String strUrl="https://www.baidu.com";
        new Thread(()->{
           String content=getContentFromUrl(strUrl);
           SwingUtilities.invokeLater(()->{
               textArea.append(content);
           });
        }).start();
    }

    public static String getContentFromUrl(String strUrl)
    {
        try {
            URL url=new URL(strUrl);
            InputStream inputStream=url.openStream();

            String content=readAll(inputStream,"UTF-8");
            return content;
        } catch (MalformedURLException e) {
            System.out.println("URL格式有错");
        } catch (IOException ioe) {
            System.out.println("IO异常");
        }
        return "";
    }

    public static String readAll(InputStream inputStream, String charcode) throws IOException
    {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,charcode));
        StringBuilder stringBuilder=new StringBuilder();
        String line;
        while((line=bufferedReader.readLine()) != null)
        {
            stringBuilder.append(line+"\n");
        }
        return stringBuilder.toString();
    }
}