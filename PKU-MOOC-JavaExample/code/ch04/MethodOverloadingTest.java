class MethodOverloadingTest
{
	public static void main( String[] argv ){
		Person p1 = new Person("Tom", 20);
		Person p2 = new Person("Marry", 18);
		p1.sayHello();
		p1.sayHello(p2);
	}
}
class Person
{
	String name;
	int age;
	Person( String name, int age ){
		this.name = name;
		this.age = age;
	}

	void sayHello(){
		System.out.println("Hello! My name is " + name );
	}

	void sayHello( Person another ){
		System.out.println("Hello, " + another.name + "! My name is " + name );
	}

}
