import java.io.* ;
import java.net.* ;
import java.util.*;

interface Servlet{
	void init();
	void service( String params, byte [] requestBuffer, OutputStream output);
}


public class HTTPServer {
	private static Map<String, Servlet> servletCache=new HashMap<>();

	public static void main(String args[]) {
		int port;
		ServerSocket serverSocket;

		try {
			port = Integer.parseInt(args[0]);
		} catch(Exception e) {
			port = 8080; //default port 8080
		}

		try {
			serverSocket = new ServerSocket(port);
			System.out.println("http server is listenning £º" + port);

			//service loop
			while (true) { 
				try {
					//wait for client
					final Socket socket = serverSocket.accept();
					System.out.println("client from£º" 
						+ socket.getInetAddress() + ":" + socket.getPort());

					service(socket); //reponse service
				} catch(Exception e) {
					e.printStackTrace();
				}
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void service(Socket socket) throws Exception {

		InputStream socketIn = socket.getInputStream(); 
		Thread.sleep(500);
		//read from client
		int size = socketIn.available();
		byte[] requestBuffer = new byte[size];
		socketIn.read(requestBuffer);
		String request = new String(requestBuffer);
		System.out.println(request); 

		//parse the first line
		String firstLineOfRequest = request.substring(0, request.indexOf("\r\n"));
		String[] parts = firstLineOfRequest.split(" ");
		String uri = parts[1]; //get uri
		if ("/".equals(uri)) uri = "index.htm"; //default page

		// if the request is a servlet, we call it's service()  
		if(uri.indexOf("servlet")!=-1){
			doServletService(socket, uri, requestBuffer);
		}else{
			//if the request is a file
			doFileResponse(socket, uri);
		}


	}

	static void doServletService(Socket socket, String uri, byte [] requestBuffer)
		throws IOException, InterruptedException, IllegalAccessException,
		ClassNotFoundException, InstantiationException{
		//get the name of servlet
		String servletName=null;
		String params = null;
		if(uri.indexOf("?")!=-1){
			servletName=uri.substring(
				uri.indexOf("servlet/")+8,uri.indexOf("?"));
			params = uri.substring(uri.indexOf("?")+1);
		}else{
			servletName=uri.substring(
				uri.indexOf("servlet/")+8);
		}
		
		//try get it from cache
		Servlet servlet=(Servlet)servletCache.get(servletName);
		
		//create a servlet by reflcation
		if(servlet==null){
			servlet=(Servlet)Class.forName(servletName).newInstance(); 
			servlet.init();  //call it
			servletCache.put(servletName,servlet);
		}   

		//call its service()      
		servlet.service(params, requestBuffer,socket.getOutputStream());

		Thread.sleep(1000);        
		socket.close();  
	}

	static void doFileResponse(Socket socket, String uri)
		throws IOException, InterruptedException{
		uri = "root/" + uri; //file is in the root directory

		String contentType;
		if (uri.indexOf("htm") != -1 ) contentType = "text/html";
		else if (uri.indexOf("jpg") != -1 || uri.indexOf("jpeg") != -1) contentType = "image/jpeg";
		else if (uri.indexOf("gif") != -1) contentType = "image/gif";
		else contentType = "application/octet-stream";

		//HTTP response: first line and header
		String responseFirstLine = "HTTP/1.1 200 OK\r\n";
		String responseHeader = "Content-Type:" + contentType + "\r\n\r\n";
		InputStream in =new FileInputStream(uri);

		OutputStream socketOut = socket.getOutputStream(); 
		socketOut.write(responseFirstLine.getBytes());
		socketOut.write(responseHeader.getBytes());

		//HTTP response: body
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = in.read(buffer)) != -1) 
			socketOut.write(buffer, 0, len);

		Thread.sleep(1000);         
		socket.close();   
	}
}