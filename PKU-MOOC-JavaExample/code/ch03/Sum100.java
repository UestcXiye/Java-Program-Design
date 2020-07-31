public class Sum100{
	public static void main( String args[ ] ){
		int sum,n;

		System.out.println("\n**** for statement ****");
		sum=0;
		for( int i=1; i<=100; i++){ //初始化,循环条件,循环改变
			sum+=i;		//循环体
		}
		System.out.println("sum is "+sum);

		System.out.println("\n**** while statement ****");
		sum=0;
		n=100;			//初始化
		while( n>0 ){	//循环条件
			sum+=n;		//循环体
			n--;		//循环改变
		}
		System.out.println("sum is "+sum);

		System.out.println("\n**** do_while statement ****");
		sum=0;
		n=1;			//初始化
		do{
			sum+=n;		//循环体
			n++;		//循环改变
		}while( n<=100 );//循环条件
		System.out.println("sum is "+sum);
	}
}
