class ConstructInvokeMetamorph 
{
	public static void main(String[] args){ 
		Person p = new Student("李明", 18, "北大");
	}
}

class Person
{
	String name="未命名"; 
	int age=-1;
	Person( String name, int age ){
		this.name=name; this.age=age; 
		sayHello();
	}
	void sayHello(){
		System.out.println( "我是一个人，我名叫：" + name + ",年龄为："+ age );
	}
}

class Student extends Person
{
	String school="未定学校";
	Student( String name, int age, String school ){
		super( name, age );
		this.school = school;
	}
	void sayHello(){
		System.out.println( "我是学生，我名叫：" + name + ",年龄为："+ age + ",学校在：" + school );
	}
}

