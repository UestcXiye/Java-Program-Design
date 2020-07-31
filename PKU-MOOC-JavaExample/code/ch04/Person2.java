class  Person2
{
	private int age;

	public void setAge( int age ) throws Exception {
		if (age>=0 && age<200) this.age = age;
		else throw new Exception("invalid age");
	}
	public  int getAge(){
		return age;
	}
}
