import java.util.Properties;
import java.util.Enumeration;
public class TestProperties {
	public static void main(String[] args) {
		Properties ps = System.getProperties();
		Enumeration pn = ps.propertyNames();
		while ( pn.hasMoreElements() ) {
			String pName = (String) pn.nextElement();
			String pValue = ps.getProperty(pName);
			System.out.println(pName + "----" + pValue);
			//System.out.println("\"" + pName + "\"," );
		}
	}
}
//	java -DmyProperty=MyValue TestProperties
