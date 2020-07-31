package pkumooc;

import java.io.*;
import java.text.DecimalFormat;

/**
 * @author liuwenchen
 * @create 2020-07-11 11:53
 */

public class CopyFileAddLineNumber2 {
    public static void main (String[] args) {
        String infname = "C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\CopyFileAddLineNumber.java";
        String outfname = "C:\\Users\\81228\\Documents\\Program\\Java Program\\LearnJava\\src\\pkumooc\\CopyFileAddLineNumber.txt";
        if( args.length >= 1 ) infname = args[0];
        if( args.length >= 2 ) outfname = args[1];

        try {
            File fin = new File(infname);
            File fout = new File(outfname);

            LineNumberReader in = new LineNumberReader(new FileReader(fin));
            PrintWriter out  = new PrintWriter(new FileWriter(fout));

            DecimalFormat fmt = new DecimalFormat("00");

            int cnt = 0;
            String s = in.readLine();
            while ( s != null ) {
                //cnt ++;
                cnt = in.getLineNumber();
                //s = deleteComments(s);
                out.println( fmt.format(cnt) + ": " + s );
                s = in.readLine();
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e1) {
            System.err.println("File not found!" );
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    static String deleteComments( String s )
    {
        if( s==null ) return s;
        int pos = s.indexOf( "//" );
        if( pos<0 ) return s;
        return s.substring( 0, pos );
    }
}
