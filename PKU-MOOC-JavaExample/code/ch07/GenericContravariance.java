import java.util.*;

class GenericContravariance 
{
	public static void main(String[] args) 
	{
		Comparator<Fruit>comparator = new Comparator<Fruit>(){
			public int compare(Fruit obj1, Fruit obj2 ){
				return obj1.weight - obj2.weight;
			}
		};

		Basket<Apple> basket1 = new Basket<>(new Apple(), new Apple(), new Apple());
		Basket<Banana> basket2 = new Basket<>(new Banana(), new Banana(), new Banana());
		basket1.sort(comparator);
		basket2.sort(comparator);
		traverse(basket1);
		traverse(basket2);
	}
	public static void traverse(Basket<? extends Fruit> basket ){
		for( Fruit obj : basket.things ){
			System.out.print(obj);
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

class Basket<T>{
	public T []things;
	public Basket(T...things){
		this.things = things;
	}
	public void sort( Comparator<? super T> comparator){
		Arrays.sort(things, comparator);
	}
}
