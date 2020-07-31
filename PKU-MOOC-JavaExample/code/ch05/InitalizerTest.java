class InitalizerTest 
{
	int x=0;
	int y=0;
	{
		y=x+5;
		System.out.println(y);
	}

	static long start = 0;
	static {
		start = new java.util.Date().getTime();
		System.out.println(start);
	}

	public static void main(String[] args) 
	{
		new InitalizerTest();
	}
}
