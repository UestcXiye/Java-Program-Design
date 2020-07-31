class AbstractClassConstructor 
{
	public static void main(String[] args) 
	{
		new B();
	}
}
abstract class T
{
	T(){ System.out.print("T");}
}
class B extends T
{
	B(){ System.out.print("B");}
}
