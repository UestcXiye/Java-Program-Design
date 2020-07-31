class ExceptionSimple 
{
	int a = 10;
	public static void main(String[] args) 
	{
		int a = 0;
		try
		{ 
			a= Integer.parseInt( "2" );
			a /= 0;  
			// 注意: 整数除以0,会产生异常  但  0.0/0=NaN  FPN/0=正无穷,-FPN/0=负无穷, 
		}
		catch(ArithmeticException ea ){ System.out.println("ea:" +ea); }
		catch(NumberFormatException en ) { System.out.println("en:" +en); }
		catch(NullPointerException ep ){ System.out.println("ep:" +ep); }
		catch(IndexOutOfBoundsException eb ){ System.out.println("eb:" +eb); }
		catch(Exception e) { System.out.println("e:" + e); }  //先catch子类Exception,后catch父类
		finally{ System.out.println("finally executed.");}
		System.out.println("Hello World!"+a );
	}
}
