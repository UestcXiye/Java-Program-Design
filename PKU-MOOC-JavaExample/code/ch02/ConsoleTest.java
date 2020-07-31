import java.io.Console;

public class ConsoleTest
{
	public static void main(String[] args){
		Console con = System.console();
		if( con == null )return;

		String s = con.readLine();
		
		con.printf( "ÄãÊäÈëµÄÊÇ£º%s.", s );
		
	}
};