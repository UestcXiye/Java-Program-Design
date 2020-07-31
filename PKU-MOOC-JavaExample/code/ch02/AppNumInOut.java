import java.io.*;
public class AppNumInOut 
{
	public static void main(String[] args) 
	{
		String s = "";
		int n = 0;
		double d = 0;
		try{
			BufferedReader in = new BufferedReader(
				new InputStreamReader( System.in ) );
			System.out.print("Please input an int: ");
			s = in.readLine();
			n = Integer.parseInt( s );
			System.out.print("Please input a double: ");
			s = in.readLine();
			d = Double.parseDouble( s );
		}catch(IOException e){}
		System.out.println("You have entered: " + n + " and " + d );
	}
}
