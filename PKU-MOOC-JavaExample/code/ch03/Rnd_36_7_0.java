class Rnd_36_7_0
{
	public static void main(String[] args)
	{
		int a[] = new int[7];
		for( int i=0;i<a.length;i++)
		{
			while( true )
			{
				a[i] = (int)( Math.random()*36 ) +1;

				boolean same = false;
				for( int j=0;j<i;j++ ){ 
					if( a[i]==a[j] ) { same=true;break;}
				}

				if( ! same ) break;
			}
		}

		for( int i=0;i<a.length;i++) 
			System.out.print( " " + a[i] ); 
		System.out.println();
	}
}
