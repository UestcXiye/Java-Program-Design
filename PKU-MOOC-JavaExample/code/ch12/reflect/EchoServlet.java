import java.io.*;
import java.util.*;

public class EchoServlet implements Servlet
{
	public void init(){
		System.out.println("EchoServlet is initialized");
	}
	public void service( String params, byte [] requestBuffer, OutputStream output ){
		try{
			String request = new String(requestBuffer);
			
			String responseFirstLine = "HTTP/1.1 200 OK\r\n";
			String responseHeader = "Content-Type: text/plain\r\n\r\n";
			output.write(responseFirstLine.getBytes()); 
			output.write(responseHeader.getBytes());

			output.write( (new Date()).toString().getBytes() );
			output.write(("you have submitted:" + request).getBytes() );
		}catch(IOException ex ){
			ex.printStackTrace();
		}
	}

};