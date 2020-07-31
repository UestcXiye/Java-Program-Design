class TestClassLiteral 
{
	public static void main(String[] args) 
	{
		A a = new B();
		System.out.println(a);
		System.out.println(a.getClass());
		System.out.println(A.class);
	}
}
class A
{
}
class B extends A
{
}
