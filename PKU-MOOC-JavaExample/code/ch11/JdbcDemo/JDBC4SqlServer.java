import java.sql.*;

public class JDBC4SqlServer
{
    public static void main(String[] args)
    {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=TestDB;user=sa;password=xxxxxxxx";
        
        try
        {
            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(dbURL);
            System.out.println("Connection Successful!");

			Statement statement = conn.createStatement();
			String sql = "select * from Book";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				String name = rs.getString("ISBN");
				System.out.println(rs.getString(2) + "\t" + name);
			}
			rs.close();
			conn.close();
		} catch(ClassNotFoundException e) {
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}

