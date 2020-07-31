class DoubleAndString 
{
	public static void main(String[] args) 
	{
		double d ; String s;

		//double转成string的几种方法
		d=3.14159;
		s = "" + d;
		s = Double.toString( d );
		s = new Double(d).toString();
		s = String.valueOf( d );

		// String转成double的几种方法
		s = "A3.14159";
		try{
			d = Double.parseDouble( s );
			d = new Double(s).doubleValue();
			d = Double.valueOf( s ).doubleValue();
		}
		catch(NumberFormatException e )
		{
			e.printStackTrace();
		}
	}
}
