class MyList<E> implements ICollection<E>
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}

	public static class Node<E>
	{
		E obj;
		E prev, next;
		Node(E e){ obj=e; prev=null; next=null; }
	};

	public void add( E e ){
		if ( e instanceof Comparable)
		{
		}
	}
	public void remove( E e ){
	}
}

interface ICollection<E> {
	void add( E e );
	void remove( E e);
}
