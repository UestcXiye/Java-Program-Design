import java.io.*;
public class AppCharInOut 
{
	public static void main(String[] args) 
	{
		char c = ' ';
		System.out.print("Please input a char: ");
		try{
			c = (char) System.in.read();

		}catch(IOException e){}
		System.out.println("You have entered: " + c );
	}
}
