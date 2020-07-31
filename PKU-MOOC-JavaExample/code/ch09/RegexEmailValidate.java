import java.util.regex.*;
public class RegexEmailValidate {
	public static void main(String[] args) 
		 throws Exception {
		String pattern = "^[^@]+@[\\w]+(\\.[\\w]+)*$";
		String email = "dstang2000@263.net";
		boolean ok = Pattern.matches( pattern, email );
		System.out.println( ok );
	}
}
