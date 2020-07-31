public class BubbleSort{
	public static void main( String args[ ] ){
		int i,j;
		int a[ ]={30,1,-9,70,25};
		int n=a.length;
		for( i=1; i<n; i++)
			for( j=0; j<n-i; j++ )
				if( a[j]>a[j+1]){
					int t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
		for( i=0; i<n; i++ )
			System.out.println(a[i]+" ");
	}
}
