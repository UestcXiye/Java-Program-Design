class InitialTest
{
	public static void main(String[] args) 
	{
		new InitialTest2(6);
	}
	int n=10;  //step2
	{
		n++;
		System.out.println("InitialTest..."+n);
	}
	
	static int x;
	static 
	{
		x++;
		System.out.println("static..." +x);
	}
	
}

class InitialTest2 extends InitialTest{
	InitialTest2(int a){ 
		this.a=a; 
		System.out.println("this.a=" + a );
	}
	int a;
	{
		System.out.println("InitialTest2..."+this.a);
	}
	static
	{
		x++;
		System.out.println("static2..." +x);
	}
}
