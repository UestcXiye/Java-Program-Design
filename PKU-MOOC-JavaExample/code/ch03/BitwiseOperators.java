public class BitwiseOperators{
	public static void main( String args[] ){
		int a = 0b1100;
		int b = 0b1010;
		print("a  ",a);
		print("b  ",b);
		print("a&b",a&b);
		print("a|b",a|b);
		print("a^b",a^b);
		print("~a",~a);
		print("a<<2",a<<2);
		print("a>>2",a>>2);
		print("a>>>2",a>>>2);
	}
	static void print(String prefix, int n ){
		String s = Integer.toBinaryString(n);
		while(s.length() < 4) s= "0"+s;
		System.out.println(prefix + " " + s);
	}
}
