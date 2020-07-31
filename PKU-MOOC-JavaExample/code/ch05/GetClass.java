class GetClass 
{
	public static void main(String[] args) 
	{
		//通过类型获得类
       Class c1 = String.class;
       System.out.println(c1);

       //通过变量获得类
       String stringExample = "abc";
       Class c2 = stringExample.getClass();
       System.out.println(c2);

	   //通过Class.forName
	   try{
		   Class c3 = Class.forName("java.lang.String");
		   System.out.println(c3);
	   }catch(ClassNotFoundException ex){
			System.out.println(ex);
	   }
	}
}
