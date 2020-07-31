import java.net.*;
import java.io.*;

public class TestClient {
	public static void main(String args[]) {
		try {
			Socket s1 = new Socket("127.0.0.1", 8888);
			InputStream is = s1.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println(dis.readUTF());
			dis.close();
			s1.close();
		} catch (ConnectException connExc) {
			System.err.println("服务器连接失败！");
		} catch (IOException e) {
		}
	}
}