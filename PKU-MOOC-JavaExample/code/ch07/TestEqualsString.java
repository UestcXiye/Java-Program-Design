public class TestEqualsString {
 	public static void main(String[] args) {
	   String name1 = new String("LiMing");
	   String name2 = new String("LiMing");
	   System.out.println( name1==name2 );  //两个对象的引用，不相等
	   System.out.println( name1.equals(name2) ); // 内容，相等
	   
	   String name3 = "LiMing";
	   String name4 = "LiMing";
	   System.out.println( name3==name4 );  //相同常量的引用，相等
	   System.out.println( name3.equals(name4) ); // 内容，相等
	}
}
