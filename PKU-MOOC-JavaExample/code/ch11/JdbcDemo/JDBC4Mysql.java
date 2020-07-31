import java.sql. * ;
//当然，首先要安装有JDK(一般是JDK1.5.X)。然后安装MySQL，这些都比较简单，具体过程就不说了。
//配置好这两个环境后，下载JDBC驱动mysql-connector-java-5.1.30.zip。
//然后将其解压缩到任一目录。我是解压到D盘，然后将其目录下的mysql-connector-java-5.1.30-bin.jar加到classpath里，
//具体如下：“我的电脑”-> “属性” ->           “高级” ->           “环境变量”，在系统变量那里编辑classpath，将D:\mysql-connector-java-5.0.5\mysql-connector-java-5.0.5-bin.jar加到最后，在加这个字符串前要加“;”，以与前一个classpath区分开。然后确定。

//直接将mysql-connector-java-5.1.18-bin.jar加入到工程的Build Path即可。步骤：选中工程名——点击右键——选择“Properties”——“Java Build Path”——“Libraries”——“Add External JARs”，打开的对话框中选择mysql-connector-java-5.1.18-bin.jar。就可以正常执行了。
//Web项目，这时候最好是把JDBC连接器，如“mysql-connector-java-5.1.30-bin.jar”放到WebRoot/Web-INF/lib目录下，

public class JDBC4Mysql {
	public static void main(String[] args) {
		// 驱动程序名          
		String driver = "com.mysql.jdbc.Driver";

		// URL指向要访问的数据库名           
		String url = "jdbc:mysql://127.0.0.1:3306/mysql";

		// MySQL配置时的用户名           
		String user = "root";

		// MySQL配置时的密码           
		String password = "";
		try {
			// 加载驱动程序           
			Class.forName(driver);

			// 连续数据库           
			Connection conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed()) System.out.println("Succeeded connecting to the Database!");

			// statement用来执行SQL语句            
			Statement statement = conn.createStatement();

			// 要执行的SQL语句            
			String sql = "select * from db limit 10 ";

			// 结果集            
			ResultSet rs = statement.executeQuery(sql);
		
			while (rs.next()) {
				String name = rs.getString("Host");
				System.out.println(rs.getString("DB") + "\t" + name);
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