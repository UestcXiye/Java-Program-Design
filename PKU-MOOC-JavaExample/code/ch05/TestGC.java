class TestGC 
{
	static String method(){
		String a,b;
		a = new String("hello world");
		b = new String("game over");
		System.out.println(a+b+"ok");
		a = null;
		a = b;
		return a;
	}

	public static void main(String[] args){ 
		String s = method();
		System.gc();
	}
}
