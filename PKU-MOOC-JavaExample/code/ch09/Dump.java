import java.io.*;

public class Dump {
    public static void main(String[]args) {
        try
        {
            dump( new FileInputStream("aaa.bmp"),
                  new FileOutputStream("bbb.bmp"));
        }
        catch(FileNotFoundException fex)
        {
            fex.printStackTrace();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public static void dump(InputStream src, OutputStream dest)
    throws IOException
    {
        InputStream input = new BufferedInputStream(src);
        OutputStream output = new BufferedOutputStream(dest);
        byte[] data = new byte[1024];
        int length = -1;
        while ((length = input.read(data)) != -1) {
            output.write(data, 0, length);
        }
        input.close();
        output.close();
    }
}
