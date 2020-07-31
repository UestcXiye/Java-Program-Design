public final class TestFinal{
		public static int totalNumber= 5 ;
		public final int id;
		
		public TestFinal(){
			// 在构造方法中对声明为final的变量id赋值
			id = ++totalNumber;
		}

   		public static void main(String[] args) {
			TestFinal t = new TestFinal();
			System.out.println(t.id);		
			final int i = 10;
			final int j;
			j = 20;
			//j = 30; //非法
    	}
}
