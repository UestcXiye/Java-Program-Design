public class TestException0{
	public static void main(String args[]){
		f();
	}
	public static int f(){
		int a = 1;
		try{a=2; return a=3;}
		//catch(Exception ex){System.out.println(4);}
		finally{ System.out.println(a);}
	} 
}
