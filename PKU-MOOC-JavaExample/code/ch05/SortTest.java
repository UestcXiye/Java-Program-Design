import java.util.Arrays;
import java.util.Comparator;

class SortTest {
	public static void main(String[] args){ 
	
		Book[] books = new Book[10];
		for (int i=0; i<books.length; i++ ){
			books[i] = new Book((int)(Math.random()*100));
		}
		dump(books);
		Arrays.<Book>sort( books, new Comparator<Book>(){
			public int compare(Book b1, Book b2){ 
				return b1.getPrice()-b2.getPrice();
			}
		});
		dump(books);
	}
	static void dump( Book [] books ){
		for (int i=0; i<books.length; i++ ){
			System.out.print(books[i]+" ");
		}
		System.out.println();
	}
}
class Book
{
	private int price;
	Book(int price){ this.price=price; }
	int getPrice(){ return price;}
	public String toString(){ return ""+price; }
}
