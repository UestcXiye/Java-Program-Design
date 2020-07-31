import java.sql.*;

public class JDBC4Sqlite {
	public static void main(String[] args) throws Exception {

		Class.forName("org.sqlite.JDBC");
		
		String connString = "jdbc:sqlite:d:/test3.db";
		Connection conn = DriverManager.getConnection(connString);
		conn.setAutoCommit(false);

		Statement stat = conn.createStatement();

		stat.executeUpdate("drop table if exists people;");
		conn.commit();
		stat.executeUpdate("create table if not exists people (id char(10), name char(20), age int, gender bit ) ;");
		stat.executeUpdate("insert into people values ('001', 'Tom', 18, 1);");
		stat.executeUpdate("insert into people values ('002', 'Marry', 20, 0);");
		stat.executeUpdate("insert into people values ('003', 'Peter', 25, 1);");
		stat.executeUpdate("update people set age=age+1 whre id='003';");
		conn.commit();

		String sql = "select * from people;";
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			String name = rs.getString("name");
			int age = rs.getInt("age");
			boolean gender = rs.getBoolean(4);

			System.out.printf("name = %s; age = %d; gender = %s\n", name, age, (gender?"male":"female"));
		}

		rs.close();
		conn.close();
	}
}
