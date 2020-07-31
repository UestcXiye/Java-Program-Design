import java.io.*; 
import java.net.*; 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class URLGetContent extends JFrame{ 
	TextArea textArea = new TextArea("downloading:\n"); 
	public void init() { 
		setSize( 400,300 );
		getContentPane().add(textArea);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	} 

	public void download() {
		String strUrl = "http://www.baidu.com";
		new Thread( ()->{
			String content = getContentFromUrl( strUrl );
			SwingUtilities.invokeLater(()->{
				textArea.append( content );
			});
		}).start();
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
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(stream, charcode)); 
		StringBuilder sb = new StringBuilder();
		String line; 
		while ((line = reader.readLine()) != null) { 
			sb.append(line+"\n"); 
		} 
		return sb.toString();
	}

	public static void main( String[] args){
		URLGetContent f = new URLGetContent();
		f.init();
		f.download();
	}
} 
