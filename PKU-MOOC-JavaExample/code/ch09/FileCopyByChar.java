import java.io.*;
public class FileCopyByChar {
	public static void main(String[] args) {
		try {
			FileReader input = new FileReader("FileCopyByChar.java");
			FileWriter output = new FileWriter("temp.txt");
			int c = input.read();		
			while ( c != -1 ) {
				output.write(c);
				System.out.print( (char) c  );
				c = input.read();
			}			
			input.close();
			output.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}