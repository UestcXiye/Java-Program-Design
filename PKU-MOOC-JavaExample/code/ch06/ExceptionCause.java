public class ExceptionCause {
	public static void main(String [] args)	{
		try 
		{
			BankATM.GetBalanceInfo( 12345L);
		}catch(Exception e)	{
			System.out.println("something wrong£º " + e);
			System.out.println("cause£º" + e.getCause());
		}
	}
}

class DataHouse {
	public static void FindData( long ID)
		throws DataHouseException
	{
		if( ID>0 && ID<1000)
			System.out.println( "id: " + ID );
		else
			throw new DataHouseException("cannot find the id");
	}
}
class BankATM{
	public static void GetBalanceInfo( long  ID)
		throws MyAppException
	{
		try 
		{
			DataHouse.FindData(ID);
		}catch (DataHouseException e) {
			throw new MyAppException("invalid id",e);
		}
	}
}
class DataHouseException extends Exception {
	public DataHouseException( String message ) {
		super(message);
	}
}
class MyAppException extends Exception {
	public MyAppException (String message){ 
		super (message); 
	}
	public MyAppException (String message, Exception cause) {
		super(message,cause);
	}   
}
