class LocalVarAndMemberVar 
{
	int a;
	void m(){
		int b;
		System.out.println(a);	// a的值为0
		System.out.println(b);  //编译不能通过
	}
}
