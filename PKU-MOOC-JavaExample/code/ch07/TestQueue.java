import java.util.*;
class TestQueue 
{
	public static void main(String[] args) 
	{
		Queue<Integer> q = new LinkedList<>();
		for( int i=0; i<5; i++ )
			q.offer( i );
		while( ! q.isEmpty() )
			System.out.println( q.poll() );
	}
}

