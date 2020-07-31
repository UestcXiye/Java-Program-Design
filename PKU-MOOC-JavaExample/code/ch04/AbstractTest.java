abstract class C{
	abstract void callme( );
	void metoo( ){
		System.out.println("Inside C's metoo( ) method");
	}
}
¡¡
class D extends C{
	void callme( ){
		System.out.println("Inside D's callme( ) method");
	}
}
	¡¡
public class AbstractTest{
	public static void main( String args[ ] ){
		C c = new D( );
		c.callme( );
		c.metoo( );
	}
}
