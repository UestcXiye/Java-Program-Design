class Jiaogu2 
{
	public static void main(String[] args) 
	{

		int max = 0; int whichI = 0;
		for( int i=1; i<=100; i++ )
		{
			int a = i;
			int cnt =0;
			while( a != 1 )
			{
				System.out.print( " " +a ); cnt++;
				if( a%2==1 ) a = a*3+1; else a /= 2;
			}
			System.out.println(" " +a + "," + cnt);
			if( max < cnt ){ max = cnt; whichI = i; }
		}
		System.out.println(max + "," + whichI);

	}
}
 
