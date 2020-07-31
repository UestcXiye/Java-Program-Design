import java.util.*;
class UseParallelStream 
{
	public static void main(String[] args) 
	{
		List<Integer> a = Arrays.asList(1,2,5,7,3);
		System.out.println(
		a.parallelStream()
			.mapToInt(i->(int)i)
			.filter( i -> i>2 )
			.map( i -> i*i )
			.sorted()
			.distinct()
			.limit(10)
			.max()
		);
	}
}

