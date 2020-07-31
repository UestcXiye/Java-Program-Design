
import java.sql.*;

public class JDBC4JavaDB {    
    public static void main(String[] args) throws Exception {    
            
        Class.forName("org.apache.derby.jdbc.ClientDriver");    
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");  
        
        Statement stat = conn.createStatement();
            
        ResultSet rs = stat.executeQuery("select * from CUSTOMER");    
        while (rs.next()) {    
            System.out.println("name = " + rs.getString("NAME"));    
            System.out.println("email = " + rs.getString("EMAIL"));    
        }    
           
        rs.close();    
        conn.close();    
    }    
}   
