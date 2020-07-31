class Person {
	String name;
	int age;

	Person( String n, int a ){
		name = n;
		age = a;
	}

	Person( String n ){
		name = n;
		age = 0;
	}

	Person( int age, String name )
	{
		this.age = age;
		this.name = name;
	}

	Person(  ){
		this( 0, "" );
	}

	boolean isOlderThan( int anAge ){
		return this.age > anAge;
	}

	void sayHello(){
		System.out.println("Hello! My name is " + name );
	}

	void sayHello( Person another ){
		System.out.println("Hello," + another.name 
			+ "! My name is " + name );
	}

	public static void main(String[] args) 
	{
		Person p = new Person("Li Min", 18);
		Person p2 = new Person("Wang Qiang", 20 );
		p.sayHello();
		p.sayHello(p2);
	}
}
