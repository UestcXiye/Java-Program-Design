import java.io.*;

class ProcessAndStream
{
	//启动进程，并获取其输出
	//更多的关于线程、关于与Swing程序的关联，可以参考:
	// http://www.cnblogs.com/freeliver54/archive/2011/11/04/2235911.html
	public static void main(String[] args) throws IOException
	{
		String [] cmd =  {"ping", "www.pku.edu.cn"};
		Process process = null;
		try {
			// 启动命令行指定程序的新进程
			process = Runtime.getRuntime().exec(cmd);
		}
		catch(IOException e) {
			System.err.println("创建进程时出错...\n" + e);
			System.exit(1);
		}
		// 获得新进程所写入的流
		// 要使用 process.getInputStream() 或 process.getErrorStream();
		BufferedReader br = new BufferedReader( 
			new InputStreamReader( 
				process.getInputStream(), "GB2312"));
		String line = "";
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}

	}
}
