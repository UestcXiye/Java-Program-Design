class TestInnerAnonymous 
{
	public static void main(String[] args) 
	{
		Object obj = new Outer().makeTheInner(47);
		System.out.println("Hello World!" + obj.toString() );
	}
}

class Outer
{
	private int size = 5;
	public Object makeTheInner( int localVar )
	{
		final int finalLocalVar = 99;
		return new Object()  {
			public String toString() {
				return ( " InnerSize: " + size + 
					" finalLocalVar: " + finalLocalVar
				);
			}
		};
	}
}
