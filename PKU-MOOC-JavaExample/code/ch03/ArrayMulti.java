class ArrayMulti{

	public static void main( String[] args ){
		int [][] a = { {1,2,3}, {4,5,6,7,8} };
		int [][] b = new int [2][];
		int [][] c = new int [2][3];
		//int [][] err = new int [][3]; //´íÎó
		for(int[] row : a ){
			for(int i : row ){
				System.out.print( i+" " );
			}
			System.out.println();
		}

	}
}
