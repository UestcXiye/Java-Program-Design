import java.io.*;
import java.util.*;

public class SqrtServlet implements Servlet
{
	public void init(){
		System.out.println("SqrtServlet is initialized");
	}
	public void service( String params, byte [] requestBuffer, OutputStream output ){
		try{
			String num = params.substring( params.indexOf("=")+1);
			double result = Math.sqrt( Double.valueOf(num) );
			
			String responseFirstLine = "HTTP/1.1 200 OK\r\n";
			String responseHeader = "Content-Type: text/plain\r\n\r\n";
			output.write(responseFirstLine.getBytes()); 
			output.write(responseHeader.getBytes());

			output.write( ("sqrt("+num+")=" + result).getBytes() );

		}catch(IOException ex ){
			ex.printStackTrace();
		}
	}

};