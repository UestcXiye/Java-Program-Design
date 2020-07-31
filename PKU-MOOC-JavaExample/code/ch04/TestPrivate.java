class TestPrivate 
{
	private int a;
	void m(){
		int i = a; 
		int j = this.a;
		int k = new TestPrivate().a;
	}
}
