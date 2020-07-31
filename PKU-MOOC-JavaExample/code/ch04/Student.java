class  Student extends Person
{
	String school;
	int score;

	void sayHello( Student another ){
		System.out.println("Hi!");
		if( school == another.school ) 
			System.out.println(" Shoolmates ");
	}

	boolean isGoodStudent(){
		return score>=90;
	}

	void sayHello(){
		super.sayHello();
		System.out.println( "My school is " + school );
	}

	Student(String name, int age, String school ){
		super( name, age );
		this.school = school;
	}

	Student(){}

	void testThisAndSuper(){
		int a;
		a = age;
		a = this.age;
		a = super.age;
	}

	public static void main( String [] arggs )
	{
		Person p = new Person( "Liming", 50 );
		Student s = new Student( "Wangqiang", 20, "PKU" );
		Person p2 = new Student( "Zhangyi", 18, "THU" );
		Student s2 = (Student) p2;

		//Student s3 = (Student) p;  //runtime exception 

		p.sayHello( s );

		Person [] manypeople = new Person[ 100 ];
		manypeople[0] = new Person("Li", 18 );
		manypeople[1] = new Student("Wang", 18, "PKU");
	}
}
