import java.util.*;
class TCovarContravar{
	public static void main( String[]args){
		List<Fruit> f = new ArrayList<Fruit>();
		List<Apple> a = new ArrayList<Apple>();
		f.add( new Fruit()); 
		a.add( new Apple());
		f.add( new Apple());
		//a.add( new Fruit());//这句不行

		//f = a; //这句不行
		//a = f; //这句不行

		List<? extends Fruit> f2 = a; //协变
		//f2.add( new Fruit() ); //这句不行
		//f2.add( new Apple() ); //这句不行
		Fruit fo = f2.get(0);

		List<? super Apple> a2 = f; //逆变

		//List<? super Fruit> f3 = a; //这句不行
		List<? super Apple> a3 = f;
		a3.add( new Apple() );
		//a3.add( new Fruit() ); //这句不行
		//Apple ao = a3.get(0); //这句不行
		//Fruit fo2 = a3.get(0); //这句不行

	}

}
class Fruit {}
class Apple extends Fruit{}
class Banana extends Fruit{}
