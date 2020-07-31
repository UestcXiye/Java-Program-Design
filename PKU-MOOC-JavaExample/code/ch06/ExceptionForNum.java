import java.io.*;
public class ExceptionForNum 
{
	public static void main(String[] args) 
	{
		try{
			BufferedReader in = new BufferedReader(
				new InputStreamReader( System.in ) );
			System.out.print("Please input a number: ");
			String s = in.readLine();
			int n = Integer.parseInt( s );
		}catch(IOException ex){
			ex.printStackTrace();
		}catch(NumberFormatException ex){
			ex.printStackTrace();
		}
	}
}
