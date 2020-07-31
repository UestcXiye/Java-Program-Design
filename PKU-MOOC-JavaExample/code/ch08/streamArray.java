import java.util.*;
class streamArray
{
	public static void main(String[] args) 
	{
		int [] a = new int[100];
		for(int i=0; i<a.length; i++) 
			a[i] = (int)(Math.random()*100);
		
		OptionalInt result=
			Arrays.stream(a).parallel()
			.filter( i -> i>20 )
			.map( i -> i*i )
			.sorted()
			.distinct()
			.limit(10)
			.max();

		System.out.println(
			result.isPresent()? "最大值为"+result.getAsInt(): "无值");
	}
}
