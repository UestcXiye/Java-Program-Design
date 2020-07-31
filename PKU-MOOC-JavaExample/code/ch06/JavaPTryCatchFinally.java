class JavaPTryCatchFinally 
{
	public static void main(String[] args) 
	{
		int a=100;
		try{
			a=200;
		}
		catch (IndexOutOfBoundsException ex){
			a=300;
		}
		catch (Exception ex){
			a=400;
		}
		finally{
			a=500;
		}
		a=600;
	}
}
