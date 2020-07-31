import java.util.*;
class TestMyQueue 
{
	public static void main(String[] args) 
	{
		MyQueue q = new MyQueue();
		for( int i=0; i<5; i++ )
			q.enqueue( ""+i );
		while( ! q.isEmpty() )
			System.out.println( q.dequeue() );
	}
}

class MyQueue extends LinkedList
{
	void enqueue( Object obj ){
		addLast( obj );
	}
	Object dequeue(){
		return removeFirst();
	}
	public boolean isEmpty(){
		return super.isEmpty();
	}
}
