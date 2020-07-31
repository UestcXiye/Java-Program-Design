public class RelationAndConditionOp{
	public static void main( String args[] ){
		int a=25,b=3;
		boolean d=a<b; //d=false
		System.out.println("a<b = "+d);
		int e=3;
		if(e!=0 && a/e>5)
			System.out.println("a/e = "+a/e);
		int f=0;
		if(f!=0 && a/f>5)
			System.out.println("a/f = "+a/f);
		else
			System.out.println("f = "+f);
	}
}
