import java.util.regex.*;
public class RegexSplitter {
	public static void main(String[] args) throws Exception {
		Pattern p = Pattern.compile( "[, \\s]+");
		String[] result = 
			p.split( "one,two, three   four ,  five ");
		for (int i=0; i<result.length; i++)
			System.out.println(result[i]);
	}
}
