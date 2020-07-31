public class SelectSort{
	public static void main( String args[ ] ){
		int i,j;
		int a[ ]={30,1,-9,70,25};
		int n=a.length;
		for( i=0; i<n-1; i++)
			for( j=i+1; j<n; j++ )
				if( a[i]>a[j] ){
					int t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
		for( i=0; i<n; i++ )
			System.out.println(a[i]+" ");
	}
}
