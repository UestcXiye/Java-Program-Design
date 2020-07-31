import java.util.regex.*;
public class RegexReplacement {
	public static void main(String[] args) 
		 throws Exception {
		Pattern pattern = Pattern.compile("cat");
		Matcher matcher = pattern.matcher(
			"one cat, two cats in the yard");
		StringBuffer sb = new StringBuffer();
		while(matcher.find()) {
			matcher.appendReplacement(sb, "big $0");
		}
		matcher.appendTail(sb);
		System.out.println(sb.toString());
	}
}
