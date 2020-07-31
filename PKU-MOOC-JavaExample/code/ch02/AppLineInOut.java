import java.io.*;
public class AppLineInOut 
{
	public static void main(String[] args) 
	{
		String s = "";
		System.out.print("Please input a line: ");
		try{
			BufferedReader in = new BufferedReader(
				new InputStreamReader( System.in ) );
			s = in.readLine();
		}catch(IOException e){}
		System.out.println("You have entered: " + s );
	}
}
