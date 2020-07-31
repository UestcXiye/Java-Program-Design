import java.util.Scanner;
class Jiaogu 
{
	public static void main(String[] args) 
	{
		System.out.print("\n请输入一个数:");
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
			
		int cnt = 0;

		while( a != 1 )
		{
			System.out.print( " " +a ); cnt++;
			if( a%2==1 ) a = a*3+1; else a /= 2;
		}
		System.out.println(" " +a + ", 运算次数" + cnt);
	}
}
