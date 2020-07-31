class Test_Virtual_Super
{
	public static void main(String[]s){
		A a = new B();
		a.f(6);
	}
}

class A 
{
	void f(int a){ 
		System.out.println("A-f "+ a);
		if(a>1) f(a-1);
	}
}
class B extends A 
{
	void f(int a){ System.out.println("B-f " + a);
		if(a>1) super.f(a-1);
	}
}
