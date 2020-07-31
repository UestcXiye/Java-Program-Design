class Queen8 
{
	public static void main(String[] args) 
	{
		new Queen8().solve();
	}
	
	private static final int N = 8;
	private int[]y; //记录每列上的皇后放的位置
	int count = 0; //解的个数

	public void solve()
	{
		count = 0;
		y = new int[N+1]; //初始化数组
		int x = 1;

		while(x>0)
		{
			y[x]++;	  //为当前x位置找一个皇后的位置
			while((y[x]<=N) && (!check(x))) y[x]++; //找到合适的皇后
			//
			if(y[x]<=N)//找到一个可以放置第x个皇后的位置，到该步为止，所求部分解都满足要求
			{
				if(x==N)//找到一个完整的放置方案
				{
					count++;
					print();
				}
				else
					x++; //继续寻找下一个皇后的位置，还没找到完整解决方案
			}
			else//未找到可以放置第x个皇后的位置，到该步为止，已经知道不满足要求
			{
				y[x] = 0;//因为要回溯，下一次是寻找第x-1个皇后的位置，
				//在下一次确定x-1的位置之后，第x个皇后的开始搜索的位置要重置
				x--; //回溯
			}
		}
	}
	private boolean check( int k) //测试合法性
	{ 
		for(int j = 1;j < k;j++)
			if((Math.abs(k-j) == Math.abs(y[j] - y[k]))
				||(y[j] == y[k])) return false;
		return true;
	}

	private void print()//显示
	{
		System.out.println(count);
		for( int i=1; i<=N; i ++ )
		{
			for( int j=1; j<=N; j++ )
				if( j==y[i] ) System.out.print("x");//如果该位置放了皇后则显示x
				else System.out.print("o");
			System.out.println();
		}

	}
	
}
