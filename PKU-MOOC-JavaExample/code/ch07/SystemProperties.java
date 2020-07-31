import java.util.*;
class SystemProperties
{
	public static void main(String[] args) 
	{
		Properties props = System.getProperties();
		Enumeration keys = props.propertyNames();
		while(keys.hasMoreElements() ){
			String key = (String) keys.nextElement();
			System.out.println( key + " = " + props.getProperty(key) );
		}
	}
}
