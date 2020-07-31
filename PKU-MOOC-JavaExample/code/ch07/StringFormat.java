import java.util.*;
class StringFormat 
{
	public static void main(String[] args) 
	{
		//参见 http://www.cnblogs.com/xytop/articles/1277125.html
		// http://developer.51cto.com/art/201203/322815.htm
		String s = String.format(
			"整数字 %1$,09d 浮点 %2$9.3f 字符串 %3$-10s 日期 %4$tF %4$tT",
			1234, Math.PI, "hello", new Date() );
		System.out.println(s);
	}
}
