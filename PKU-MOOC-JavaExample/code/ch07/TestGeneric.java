import java.util.*;
class TestGeneric {
	public static void main(String[] args){ 
		Vector<Photo> album = new Vector<Photo>(); //使用泛型
		album.addElement( new Photo("one",new Date(), "在海边"));
		album.addElement( new Photo("two",new Date(), "在山顶"));
		album.addElement( new Photo("three",new Date(), "在旷野"));
		for( int i=0; i < album.size(); i++ ){
			Photo photo = album.elementAt(i);
			System.out.println( photo.toString() );
		}
		for( Photo photo : album ){  //使用增强的for语句
			System.out.println( photo.toString() );
		}
	}
}
class Photo {
	String title;
	Date date;
	String memo;
	Photo(String title, Date date, String memo){
		this.title = title;
		this.date = date;
		this.memo = memo;
	}
	public String toString(){
		return title + "(" + date + ")" + memo;
	}
}
