class Test_Virtual_Static
{
	public static void main(String[]s){
		A a = new B();
		a.f(6);
		B b = new B();
		b.f(6);
	}
}

class A 
{
	static void f(int a){ 
		System.out.println("A-f "+ a);
		if(a>1) f(a-1);
	}
}
class B extends A 
{
	static void f(int a){ System.out.println("B-f " + a);
		if(a>1) f(a-1);
	}
}
