import java.net. * ;
import java.io. * ;
import java.util. * ;

public class HTTPClient {
	public static void main(String args[]) {
		//确定HTTP请求的uri
		String uri = "index.htm";
		if (args.length != 0) uri = args[0];

		//doGet("localhost", 8065, uri); //按照GET请求方式访问HTTPServer 
		doGet("www.pku.edu.cn", 80, "/"); //按照GET请求方式访问HTTPServer 
	}

	/** 按照GET请求方式访问HTTPServer */
	public static void doGet(String host, int port, String uri) {
		Socket socket = null;

		try {
			socket = new Socket(host, port); //与HTTPServer建立FTP连接
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			/*创建HTTP请求 */
			StringBuffer sb = new StringBuffer("GET " + uri + " HTTP/1.1\r\n");
			sb.append("Host: " + host + ":" + port + "\r\n");
			sb.append("Accept: */*\r\n");
			sb.append("Accept-Language: zh-cn\r\n");
			sb.append("Accept-Encoding: gzip, deflate\r\n");
			sb.append("User-Agent: HTTPClient\r\n");
			//sb.append("Connection: Keep-Alive\r\\n");
			sb.append("Connection: close\r\n");
			sb.append("\r\n");

			/*发送HTTP请求*/
			OutputStream socketOut = socket.getOutputStream(); //获得输出流  
			socketOut.write(sb.toString().getBytes());
			socketOut.flush();

			//Thread.sleep(2000); //睡眠2秒，等待响应结果

			/*接收响应结果*/
			InputStream streamIn = socket.getInputStream(); //获得输入流
			String content = readAll(streamIn, "utf8");
			System.out.println(content);

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	} //#doGet()

	public static String readAll(InputStream src, String encoding) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(src, encoding));
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = input.readLine()) != null) {
			sb.append(line);
			sb.append("\r\n");
		}
		input.close();
		return sb.toString();
    }

}