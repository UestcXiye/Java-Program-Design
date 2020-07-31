public class ArrayTest {
	public static void main( String args[ ] ){
		
		int a[ ]=new int[5];
		for(int i=0; i<a.length; i++ )
			a[i]=i;

		for(int  i=0; i<a.length; i++ )
			System.out.println("a["+i+"] = "+a[i]);
		for(int  i=a.length-1; i>=0; i-- )
			System.out.println("a["+i+"] = "+a[i]);

		for( int n : a )
			System.out.println(n);
	}
}
