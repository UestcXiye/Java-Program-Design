package pkumooc;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @author liuwenchen
 * @create 2020-07-09 18:47
 */
public class SystemProperties {
    public static void main(String[] args) {
        Properties properties=System.getProperties();
        Enumeration keys=properties.propertyNames();
        while(keys.hasMoreElements())
        {
            String key=(String) keys.nextElement();
            System.out.println(key+" = "+properties.getProperty(key));
        }
    }
}