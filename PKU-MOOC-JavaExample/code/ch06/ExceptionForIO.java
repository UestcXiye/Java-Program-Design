import java.io.*;

public class ExceptionForIO{
	  public static void main(String[] args){
	     try{
		 	 FileInputStream in=new FileInputStream("myfile.txt");
			 int b;	
			 b = in.read();
			 while(b!= -1) {
				System.out.print((char)b);
				b = in.read();
			 }
			 in.close();
		  }catch (IOException e) {
		     System.out.println(e);
		  }finally {
		     System.out.println("finally here");
		  }
	  }
}
