import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.*;
import java.util.Vector;

class JDBCJTable extends JFrame
{
	AbstractTableModel tm;		//声明一个类AbstractTableModel对象
	JTable table;				//声明一个类JTable对象
	JScrollPane scrollpane;		//声明一个滚动面板对象
	String titles[];			//二维表列名
	Class colClasses[];			//二维表列的类型
	Vector<Vector<Object>> records;				//声明一个向量对象

	public void initTablModel(){
		records = new Vector<>();	//实例化向量
		tm = new AbstractTableModel(){
			public int getColumnCount(){
				return titles.length;	//取得表格列数
			}
			public int getRowCount(){
				return records.size();		//取得表格行数
			}
			public Object getValueAt(int row,int column){
				if(!records.isEmpty())		//取得单元格中的属性值
					return ((Vector)records.elementAt(row)).elementAt(column);
				else
					return null;
			}

			public String getColumnName(int column){
				return titles[column];	//设置表格列名
			}

			public Class getColumnClass(int column){
				//return getValueAt(0,column).getClass();	//取得列所属对象类
				return colClasses[column];
			}

			public void setValueAt(Object value,int row,int column){
					//数据模型不可编辑，该方法设置为空
			}
			public boolean isCellEditable(int row,int column){
				return false;//设置单元格不可编辑，为缺省实现
			}
		};
	}

	public void showData() throws SQLException, ClassNotFoundException{

		// 加载驱动程序
		Class.forName("org.sqlite.JDBC");

		//得到与数据库的连接
		String connString = "jdbc:sqlite:d:/test3.db";
		Connection connection = DriverManager.getConnection(connString);

		//执行查询。 
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select * from people");
		ResultSetMetaData meta = rs.getMetaData();	//得到元数据

		//显示结果 
		int colCnt = meta.getColumnCount();
		System.out.println( colCnt );
		titles = new String[ colCnt ];
		colClasses = new Class[ colCnt ];
		for( int i=0; i<colCnt; i++){
			titles[i] = meta.getColumnName(i+1);	//得到列名,注意下标是从1开始的
			String className =  meta.getColumnClassName(i+1);
			Class clz = String.class;//得到数据类型
			if(className!=null) try
			{
				clz = Class.forName(className);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			colClasses[i] =	clz; 
		}

		records.removeAllElements();//初始化向量对象
		while(rs.next()){
			Vector<Object> rec_vector=new Vector<>();
			//从结果集中取数据放入向量rec_vector中
			for ( int i=0; i<titles.length; i++ ){
				Object obj = rs.getObject(i+1);
				System.out.print(obj+";");
				rec_vector.addElement(obj==null?null:obj.toString());
			}
			records.addElement(rec_vector);
			System.out.println();
		}

		//定制表格： 
		table=new JTable();	//生成自己的数据模型
		table.setToolTipText("显示全部查询结果");	//设置帮助提示
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);	//设置表格调整尺寸模式
		table.setCellSelectionEnabled(false);	//设置单元格选择方式
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		
		
		scrollpane=new JScrollPane(table);		//给表格加上滚动条
		getContentPane().add( scrollpane );

		table.setModel(tm);
		tm.fireTableStructureChanged();//更新表格
		
		//注：设定数据，也可以用以下的构造方法
		//JTable(TableModel dm)
		//JTable(Object[][] rowData, Object[] columnNames) )
		//JTable(Vector rowData, Vector columnNames) 		
	}

	public static void main( String [] args ){
		SwingUtilities.invokeLater(()->{
			JDBCJTable f = new JDBCJTable();
			f.initTablModel();
			try{
				f.showData();
			}catch( Exception e){ e.printStackTrace(); }
			f.setSize( 400,300);
			f.setTitle( "Show Database table in JTable" );
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setVisible(true);
		});
	}

}



