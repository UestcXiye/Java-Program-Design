import java.io.*;
public class CopyFileAddLineNumber {
	public static void main (String[] args) {
		String infname = "CopyFileAddLineNumber.java";
		String outfname = "CopyFileAddLineNumber.txt";
		if( args.length >= 1 ) infname = args[0];
		if( args.length >= 2 ) outfname = args[1];

		try {
			File fin = new File(infname);
			File fout = new File(outfname);

			BufferedReader in = new BufferedReader(new FileReader(fin));
			PrintWriter out  = new PrintWriter(new FileWriter(fout));

			int cnt = 0;	// 行号
			String s = in.readLine();
			while ( s != null ) {
				cnt ++; 
				s = deleteComments(s);						//去掉以//开始的注释
				out.println(cnt + ": \t" + s );				//写出
				s = in.readLine();							//读入
			}			
			in.close();				// 关闭缓冲读入流及文件读入流的连接.
			out.close();
		} catch (FileNotFoundException e1) {
			System.err.println("File not found!" );
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	static String deleteComments( String s ) //去掉以//开始的注释
	{
		if( s==null ) return s;
		int pos = s.indexOf( "//" );
		if( pos<0 ) return s;
		return s.substring( 0, pos );
	}
}
