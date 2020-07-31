import java.io.*;
public class ExceptionTrowsToOther{
	public static void main(String[] args){
	
		try{
			System.out.println("====Before====");
		 	readFile();
			System.out.println("====After====");
		 }catch(IOException e){ System.out.println(e); }
	}

	public static void readFile()throws IOException {
		FileInputStream in=new FileInputStream("myfile.txt");
		int b;	
		b = in.read();
		while(b!= -1)   {
			System.out.print((char)b);
			b = in.read();
		}
		in.close();	
	}
}
