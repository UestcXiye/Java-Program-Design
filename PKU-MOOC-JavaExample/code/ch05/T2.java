class T2 
{
	static int y = 2;
	static int x = y+1;
	static{
		y+=4;
	}
	public static void main(String[] args) 
	{
		System.out.println(x);
		System.out.println(y);
	}
}
