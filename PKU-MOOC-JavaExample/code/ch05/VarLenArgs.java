class VarLenArgs
{
	public static void main(String[] args){
		int a = sum(1,2,3,4);
		System.out.println( a );

		int a2 = sum2(new int[]{1,2,3,4});
		System.out.println( a );

	}

	static int sum( int... nums){
		int s=0;
		for(int n : nums) s+=n;
		return s;
	}

	static int sum2( int[] nums ){
		int s=0;
		for(int n : nums) s+=n;
		return s;
	}

	static int sum3( int[] nums ){
		int s=0;
		for(int i=0; i<nums.length; i++) s+=nums[i];
		return s;
	}

}