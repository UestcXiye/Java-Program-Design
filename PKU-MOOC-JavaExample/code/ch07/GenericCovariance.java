class GenericCovariance 
{
	public static void main(String[] args) 
	{
		Node<Apple> apple = new Node<>( new Apple(),null); 
		//Node<Fruit> fruit = apple; //编译不通过
		Node<? extends Fruit> fruit = apple; //这样可以

		Node<Apple> apple1 = new Node<>(new Apple(), null);
		Node<Apple> apple2 = new Node<>(new Apple(), apple1);
		Node<Apple> apple3 = new Node<>(new Apple(), apple2);
		traverse(apple3);

		Node<Banana> banana1 = new Node<>(new Banana(), null);
		Node<Banana> banana2 = new Node<>(new Banana(), banana1);
		Node<Banana> banana3 = new Node<>(new Banana(), banana2);
		traverse(banana3);
	}
	public static void traverse(Node<? extends Fruit> node ){
		while( node!=null ){
			System.out.print(node.value.weight+" ");
			node = node.next;
		}
	}
}

class Fruit
{	int weight = (int)(Math.random()*100);
	public String toString(){return this.getClass().getName()+weight; }
}
class Apple extends Fruit
{
}
class Banana extends Fruit
{
}

class Node<T>{
	public T value;
	public Node<T> next;
	public Node( T value, Node<T> next){
		this.value = value;
		this.next = next;
	}
}
