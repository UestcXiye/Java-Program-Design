package pkumooc;

import java.io.*;

/**
 * @author liuwenchen
 * @create 2020-07-11 10:22
 */

public class Dump {
    public static void main(String[] args) {
        try {
            dump(new FileInputStream("aaa.bmp"),new FileOutputStream("bbb.bmp"));
        }catch(FileNotFoundException fex){fex.printStackTrace();}
         catch(IOException ioe){ioe.printStackTrace();}
    }

    public static void dump(InputStream fileInputStream, OutputStream fileOutputStream)throws IOException
    {
        InputStream inputStream=new BufferedInputStream(fileInputStream);
        OutputStream outputStream=new BufferedOutputStream(fileOutputStream);
        byte[] data=new byte[1024];
        int length=-1;
        while((length=inputStream.read(data))!=-1)
        {
            outputStream.write(data,0,length);
        }
        inputStream.close();
        outputStream.close();
    }
}
