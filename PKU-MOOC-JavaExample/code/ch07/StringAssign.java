class StringAssign 
{
	public static void main(String[] args) 
	{
		// 几种常见的字符串赋值的方法
		String s;

		// 直接赋值
		s = "Hello";
		s = new String( "Hello" );
		
		// 使用StringBuilder
		s = new String( new StringBuffer( "Hello" ) );
		s = new StringBuffer( "Hello").toString();

		// 对象转为字符串
		s = new Object().toString();
		s = "" + new Object();
	}
}
