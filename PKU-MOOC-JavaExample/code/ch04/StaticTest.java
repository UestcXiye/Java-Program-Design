import static java.lang.System.*;
class  StaticTest
{
	public static void main(String[] args) 
	{
		Person p = new Person();
		Person.totalNum=1;
		out.println(p.totalNum);
	}
}

class Person {
	static long totalNum;
	int age; 
	String Name; 
}

