import java.util.regex.*;
class RegexHref {
	public static void main(String[] args) {
		String patternString = 
			"\\s*(href|src)\\s*=\\s*(\"([^\"]*\")|(\'[^\']*\')|([^\'\">\\s]+))"; 
		String text = 
			"<a href=\"http://aaa.htm\">bbb</a> <img src=\"http://bb.com/pic.jpg\">";
		Pattern pattern = Pattern.compile(patternString, 
			Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher( text );
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			//整个捕获，相当于goup(0)
			buffer.append("获捕到" + matcher.group()); 
			//捕获中的一部分(第2对圆括号对应的，即是网址)
			buffer.append(" 其中网址为" + matcher.group(2)); 
			buffer.append("\r\n");
		}
		System.out.println(buffer.toString());
	}
}