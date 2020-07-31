import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MyContacts extends JFrame {
	
	DBConnection dbconn;

	private JButton btnInsert = null;
	private JButton btnUpdate = null;
	private JButton btnDelete = null;
	private JTextField txtFilter = null;
	private JButton btnQuery = null;

	private JTable jTable = null;

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			new MyContacts();
		});
	}

	public MyContacts() {
		super("Contacts");
		initialize();

		dbconn = DBConnection.getInstance();
		doQuery();
	}

	private void initialize() {

		JPanel pnlTop = new JPanel();
		txtFilter = new JTextField(20);
		btnQuery = new JButton("Search");
		pnlTop.add(txtFilter);
		pnlTop.add(btnQuery);

		jTable = new JTable();

		btnInsert = new JButton("Insert");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		JPanel pnlBottom = new JPanel();
		pnlBottom.add(btnInsert);
		pnlBottom.add(btnUpdate);
		pnlBottom.add(btnDelete);

		getContentPane().add(pnlTop, BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(jTable), BorderLayout.CENTER);
		getContentPane().add(pnlBottom, BorderLayout.SOUTH);

		btnQuery.addActionListener(e -> doQuery());
		btnInsert.addActionListener(e -> doInsert());
		btnUpdate.addActionListener(e -> doUpdate());
		btnDelete.addActionListener(e -> doDelete());

		this.setSize(500, 500);
		this.setLocation(300, 150);
		this.setVisible(true);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				if (dbconn != null)
					dbconn.close();
				dbconn = null;
				System.exit(0);
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void doQuery() {
		List<Contacts> list = new ArrayList<Contacts>();

		String sWhere = "";
		String word = txtFilter.getText().trim();
		if (word.length() > 0)
			sWhere = " where name like '%" + word + "%' " + " or email like '%"
					+ word + "%' ";
		list = new ContactsDAO().query(sWhere);
		if (list.size() > 0) {
			Vector<Vector<Object>> data = new Vector<>();
			for (Contacts tempc : list) {
				Vector<Object> record = new Vector<>();
				record.add(tempc.getId());
				record.add(tempc.getName());
				record.add(tempc.getBirthday());
				record.add(tempc.getTelephone());
				record.add(tempc.getEmail());
				record.add(tempc.getRemark());
				data.add(record);
			}
			Vector<String> columns = new Vector<>();
			columns.addAll(Arrays.<String> asList("id", "name", "birthday",
					"telephone", "email", "remark"));
			jTable.setModel(new DefaultTableModel(data, columns));
		} else {
			JOptionPane.showMessageDialog(this, "No Data");
		}
	}

	private void doInsert() {
		ContactsDetailDialog inputDialog = new ContactsDetailDialog();
		inputDialog.uiClear();
		inputDialog.setVisible(true);
		System.out.println(inputDialog.isOkPressed());
		if (!inputDialog.isOkPressed())
			return;

		Contacts inputContact = inputDialog.ui2entity();
		System.out.println(inputContact);

		int newId = new ContactsDAO().insert(inputContact);
		System.out.println(newId);

		doQuery(); // refresh the table
	}

	private void doUpdate() {
		Contacts c = getSelectedContacts();
		if (c == null) {
			JOptionPane.showMessageDialog(this,
					"Please select one row to update");
			return;
		}
		ContactsDetailDialog inputDialog = new ContactsDetailDialog();
		inputDialog.uiClear();

		inputDialog.entity2ui(c);
		inputDialog.setVisible(true);

		if (!inputDialog.isOkPressed())
			return;
		Contacts inputContact = inputDialog.ui2entity();
		inputContact.setId(c.getId());
		boolean success = new ContactsDAO().update(inputContact);

		if (success)
			doQuery(); // refresh the table
	}

	private void doDelete() {
		Contacts c = getSelectedContacts();
		if (c == null) {
			JOptionPane.showMessageDialog(this,
					"Please select one row to delete");
			return;
		}
		if (JOptionPane.showConfirmDialog(this,
				"Do you want to delete the record of " + c.getName()) != JOptionPane.OK_OPTION) {
			return;
		}
		boolean success = new ContactsDAO().delete(c);

		if (success)
			doQuery(); // refresh the table
	}

	private Contacts getSelectedContacts() {
		System.out.println(jTable.getSelectedRow());
		if (jTable.getSelectedRowCount() <= 0) {
			return null;
		}
		int row = jTable.getSelectedRow();
		if (row < 0)
			return null;
		TableModel tm = jTable.getModel();
		if (tm == null)
			return null;

		// System.out.println(tm.getValueAt(0, 0));

		Contacts c = new Contacts();
		c.setId(Integer.parseInt("" + tm.getValueAt(row, 0)));
		c.setName(String.valueOf(tm.getValueAt(row, 1)));
		c.setBirthday(String.valueOf(tm.getValueAt(row, 2)));
		c.setTelephone(String.valueOf(tm.getValueAt(row, 3)));
		c.setEmail(String.valueOf(tm.getValueAt(row, 4)));
		c.setRemark(String.valueOf(tm.getValueAt(row, 5)));
		return c;
	}

}

class ContactsDetailDialog extends JDialog {
	boolean okPressed = false;

	private JLabel lblName = null;
	private JTextField txtName = null;
	private JLabel lblBirthday = null;
	private JTextField txtBirthday = null;
	private JLabel lblTelephone = null;
	private JTextField txtTelephone = null;
	private JLabel lblEmail = null;
	private JTextField txtEmail = null;
	private JLabel lblRemark = null;
	private JTextField txtRemark = null;

	private JPanel pnlInput = null;
	private JPanel pnlButtons = null;

	private JButton btnOk = null;
	private JButton btnCancel = null;

	public ContactsDetailDialog() {
		lblName = new JLabel("Name");
		txtName = new JTextField();
		lblBirthday = new JLabel("Birthday");
		txtBirthday = new JTextField();
		lblTelephone = new JLabel("Telephone");
		txtTelephone = new JTextField();
		lblEmail = new JLabel("Email");
		txtEmail = new JTextField();
		lblRemark = new JLabel("Remark");
		txtRemark = new JTextField();

		pnlInput = new JPanel();
		pnlInput.setLayout(new GridLayout(5, 2));

		pnlInput.add(lblName);
		pnlInput.add(txtName);
		pnlInput.add(lblBirthday);
		pnlInput.add(txtBirthday);
		pnlInput.add(lblEmail);
		pnlInput.add(txtEmail);
		pnlInput.add(lblTelephone);
		pnlInput.add(txtTelephone);
		pnlInput.add(lblRemark);
		pnlInput.add(txtRemark);

		pnlButtons = new JPanel();
		btnOk = new JButton("Ok");
		btnCancel = new JButton("Cancel");
		pnlButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlButtons.add(btnOk);
		pnlButtons.add(btnCancel);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pnlInput, BorderLayout.CENTER);
		getContentPane().add(pnlButtons, BorderLayout.SOUTH);

		setSize(300, 200);
		this.setModal(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		btnOk.addActionListener(e -> {
			okPressed = true;
			dispose();
		});
		btnCancel.addActionListener(e -> {
			okPressed = false;
			dispose();
		});
	}

	public boolean isOkPressed() {
		return okPressed;
	}

	public Contacts ui2entity() {
		Contacts c = new Contacts();
		c.setName(txtName.getText());
		c.setBirthday(txtBirthday.getText());
		c.setTelephone(txtTelephone.getText());
		c.setEmail(txtEmail.getText());
		c.setRemark(txtRemark.getText());
		return c;
	}

	public void entity2ui(Contacts c) {
		if (c == null) {
			uiClear();
			return;
		}
		txtName.setText(c.getName());
		txtBirthday.setText(c.getBirthday());
		txtTelephone.setText(c.getTelephone());
		txtEmail.setText(c.getEmail());
		txtRemark.setText(c.getRemark());
	}

	public void uiClear() {
		txtName.setText("");
		txtBirthday.setText("");
		txtTelephone.setText("");
		txtEmail.setText("");
		txtRemark.setText("");
	}
}

class DBConnection {
	static private DBConnection instance = null;
	private Connection conn = null;

	public Connection getConnection() {
		return conn;
	}

	private DBConnection() {
		//use sqlite
		String driver = "org.sqlite.JDBC";
		String url = "jdbc:sqlite:d:/contacts.db";
		
		// if we use mysql:
		// String driver =
		// "com.mysql.jdbc.Driver";//"org.gjt.mm.mysql.Driver";
		// String url
		// ="jdbc:mysql://localhost:3306/test?characterEncoding=utf8";

		String user = "root";
		String pwd = "";
		try {
			Class.forName(driver).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(url, user, pwd);
			conn.setAutoCommit(true);

			// create table first
			String sqlCreate = "create table if not exists Contacts( id integer PRIMARY KEY AUTOINCREMENT, name varchar(10), birthday datetime, telephone varchar(30), email varchar(30), remark varchar(100) )";
			conn.createStatement().execute(sqlCreate);
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}
}

class ContactsDAO {

	private Connection conn;

	public ContactsDAO() {
		conn = DBConnection.getInstance().getConnection();
	}

	public List<Contacts> queryAll() {
		return query("");
	}

	public List<Contacts> query(String sWhere) {
		List<Contacts> list = new ArrayList<Contacts>();
		String sql = "select * from contacts ";
		sql += sWhere;
		System.out.println(sql);
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Contacts tempc = Record2Entity(rs);
				list.add(tempc);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * insert one record
	 * 
	 * @param c
	 * @return the autoincreament id
	 */
	public int insert(Contacts c) {
		String sql = "insert into contacts(name,birthday,telephone,email,remark) values"
				+ "(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getBirthday());
			pstmt.setString(3, c.getTelephone());
			pstmt.setString(4, c.getEmail());
			pstmt.setString(5, c.getRemark());
			int n = pstmt.executeUpdate();
			System.out.println(n);

			if (n > 0) {
				// get the autoincreament id
				ResultSet rsKey = pstmt.getGeneratedKeys();
				if (rsKey.next()) {
					int autoId = rsKey.getInt(1);
					c.setId(autoId);
					return autoId;
				}
			}
			pstmt.close();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return 0;
	}

	public boolean update(Contacts c) {
		return updateById(c, c.getId());
	}

	public boolean updateById(Contacts newContacts, int id) {
		return update(newContacts, " where id=" + id);
	}

	/**
	 * update a record
	 * 
	 * @param c
	 * @param sWhere
	 * @return true if success
	 */
	public boolean update(Contacts c, String sWhere) {
		String sql = "update contacts set name = ?, birthday = ?, "
				+ "telephone = ?, email = ?,remark = ? ";
		sql += sWhere;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getBirthday());
			pstmt.setString(3, c.getTelephone());
			pstmt.setString(4, c.getEmail());
			pstmt.setString(5, c.getRemark());
			int n = pstmt.executeUpdate();
			pstmt.close();
			return n > 0;
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return false;
	}

	public boolean delete(Contacts c) {
		return deleteById(c.getId());
	}

	public boolean deleteById(int id) {
		return delete(" where id=" + id);
	}

	public boolean delete(String sWhere) {
		String sql = "delete from contacts ";
		sql += sWhere;
		System.out.println(sql);
		try {
			Statement stmt = conn.createStatement();
			int n = stmt.executeUpdate(sql);
			stmt.close();
			return n > 0;
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		return false;
	}

	private Contacts Record2Entity(ResultSet rs) throws SQLException {
		Contacts tempc = new Contacts();
		tempc.setId(rs.getInt("id"));
		tempc.setName(rs.getString("name"));
		tempc.setBirthday(rs.getString("birthday"));
		tempc.setTelephone(rs.getString("telephone"));
		tempc.setEmail(rs.getString("email"));
		tempc.setRemark(rs.getString("remark"));
		return tempc;
	}

	
	// a Contacts object to carry sql where
	public List<Contacts> queryByFilter(Contacts filter) {
		return query(filterToSqlWhereClause(filter));
	}

	public boolean deleteByFilter(Contacts filter) {
		return delete(filterToSqlWhereClause(filter));
	}

	private String filterToSqlWhereClause(Contacts c) {
		String sql = "";
		String temp;
		temp = c.getName();
		if (temp != null && temp.length() > 0) {
			sql += "and name = '" + temp + "' ";
		}
		temp = c.getBirthday();
		if (temp != null && temp.length() > 0) {
			sql += "and birthday = '" + temp + "' ";
		}
		temp = c.getEmail();
		if (temp != null && temp.length() > 0) {
			sql += "and email = '" + temp + "' ";
		}
		temp = c.getTelephone();
		if (temp != null && temp.length() > 0) {
			sql += "and telephone = '" + temp + "' ";
		}
		temp = c.getRemark();
		if (temp != null && temp.length() > 0) {
			sql += "and remark = '" + temp + "' ";
		}
		if (sql.startsWith("and "))
			sql = " where " + sql.substring("and ".length());

		return sql;
	}

}

class Contacts {
	private int id;
	private String name = null;
	private String birthday = null;
	private String telephone = null;
	private String email = null;
	private String remark = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return String.join("" + id, name, email);
	}

}