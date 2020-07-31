
import java.io.*; 
import java.net.*; 
import java.awt.*;
import java.awt.event.*;
import java.applet.*; 
public class URLGetContent extends Applet{ 
	TextArea textArea = new TextArea("下载的数据：\n"); 
	public void init() { 
		add(textArea);
	} 

	public void start() {
		String strUrl = "http://www.baidu.com";
		String content = getContentFromUrl( strUrl );
		textArea.append( content );
	} 
	public static String getContentFromUrl( String strUrl )
	{
		try { 
			URL url = new URL(strUrl);  
			InputStream stream = url.openStream();

			String content = readAll( stream,"UTF-8" ); //常见的编码包括 GB2312, UTF-8
			return content;

		}catch ( MalformedURLException e) { 
			System.out.println("URL格式有错" ); 
		}catch (IOException ioe) {
			System.out.println("IO异常" ); 
		}
		return "";
	}

	public static String readAll( InputStream stream, String charcode ) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charcode)); 
		StringBuilder sb = new StringBuilder();
		String line; 
		while ((line = reader.readLine()) != null) { 
			sb.append(line+"\n"); 
		} 
		return sb.toString();
	}

	public static void main( String[] args){
		Frame f = new Frame("URL Test");
		Applet ap = new URLGetContent();
		ap.init();
		f.add(ap);
		f.addWindowListener( new WindowAdapter(){
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		f.setSize( 400,300 );
		f.show();
		ap.start();
	}
} 
