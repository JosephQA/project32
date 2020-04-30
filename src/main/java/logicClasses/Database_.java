package logicClasses;

//import java.sql.Connection;
//import java.sql.DatabaseMetaData;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import InitClass.ScannerHandling;
import enums.CustFields;
import enums.OrderFields;
import enums.OrderLineFields;
import enums.ProductFields;
import enums.TableNames;

public class Database_ {
	// jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
	private String dbUrl = "jdbc.mysql//localhost:3306";// ; //note replase with "+usrname+"..."+inputpass+"...
	private Connection conn;
	private Statement stmnt;
	private String comma = " , ";
	private String textComma = "\",\"";
	private String textSorS = "\"";
	String suffix;
//private DriverManager;
	DatabaseMetaData dm;
	Scanner scanIn;

	public Database_(String test) {
		// TODO Auto-generated constructor stub7
		if (test != "test") {
			suffix = "thisisit";
			notatest();
		} else {
			suffix = "thisistest";
			isatest();
		}
	}

	private void notatest() {
		try {
			// DriverManager.registerDriver(new
			// com.microsoft.sqlserver.jdbc.SQLServerDriver());
			scanIn = ScannerHandling.getScanner();
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + suffix, scanIn.nextLine(),
					scanIn.nextLine());
			stmnt = conn.createStatement();
			if (conn != null) {
				dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				ResultSet rs = dm.getTables("thisisit", null, "%", null);
				while (rs.next()) {
					System.out.println(rs.getString("TABLE_NAME"));
				}
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// this.close();
		}
	}

	private void isatest() {
		try {
			// DriverManager.registerDriver(new
			// com.microsoft.sqlserver.jdbc.SQLServerDriver());
			scanIn = ScannerHandling.getScanner();
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + suffix, "root", "root");
			stmnt = conn.createStatement();
			if (conn != null) {
				dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				ResultSet rs = dm.getTables(suffix, null, "%", null);
				while (rs.next()) {
					System.out.println(rs.getString("TABLE_NAME"));
				}
			}
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// this.close();
		}
	}

	// select all from customers
	protected ResultSet getAllCusts() {
		String qry = "select * from " + TableNames.CUSTOMERS.getFeild() + " ;";
		ResultSet rs = executeQuery(qry);
		return rs;
	}

//select all from items
	protected ResultSet getAllItems() {
		String qry = "select * from " + TableNames.PRODUCTS.getFeild() + " ;";
		ResultSet rs = executeQuery(qry);
		return rs;
	}

//select all from orderline
	protected ResultSet getAllOrderLines() {
		String qry = "select * from " + TableNames.ORDERLINES.getFeild() + " ;";
		ResultSet rs = executeQuery(qry);
		return rs;
	}

//select all from orders
	protected ResultSet getAllOrders() {
		String qry = "select * from " + TableNames.ORDERS.getFeild() + " ;";
		ResultSet rs = executeQuery(qry);
		return rs;
	}

//selectallwherecust
	protected ResultSet getAllCustWhere(CustFields fld, String value) {
		value = sneakyCheck(value);
		String qry = "select * from " + TableNames.CUSTOMERS.getFeild() + " where " + fld.getFeild() + " = " + value
				+ ";";
		return executeQuery(qry);
	}

	// selectallwhereitems
	protected ResultSet getAllItemssWhere(ProductFields fld, String value) {
		value = sneakyCheck(value);
		String qry = "select * from " + TableNames.PRODUCTS.getFeild() + " where " + fld.getFeild() + " = " + value
				+ ";";
		return executeQuery(qry);
	}

//	selectallwhereorders
	protected ResultSet getAllOrdersWhere(OrderFields fld, String value) {
		value = sneakyCheck(value);
		String qry = "select * from " + TableNames.ORDERS.getFeild() + " where " + fld.getFeild() + " = " + value + ";";
		return executeQuery(qry);
	}

	// selectallwhereorderline
	protected ResultSet getAllOrderLineWhere(OrderLineFields fld, String value) {
		value = sneakyCheck(value);
		ResultSet rsme;
		String qry = "select * from " + TableNames.ORDERLINES.getFeild() + " where " + fld.getFeild() + " = " + value
				+ ";";

		rsme = executeQuery(qry);
		return rsme;
	}

	protected ResultSet getOrderlineByKey(int ordId, int lineNo) {
		String qry = "select * from " + TableNames.ORDERLINES.getFeild() + " where " + OrderLineFields.ID.getFeild()
				+ " = " + ordId + " and " + OrderLineFields.LINE.getFeild() + " = " + lineNo + ";";
		return executeQuery(qry);
	}

//select single from customers
	protected ResultSet getFieldCustomersById(CustFields wantfeild, CustFields checkfield, String whereID) {
		whereID = sneakyCheck(whereID);
		String qry = "select " + wantfeild.getFeild() + " from " + TableNames.CUSTOMERS.getFeild() + " where "
				+ checkfield.getFeild() + " = " + whereID + ";";
		return executeQuery(qry);

	}

//select single from items
	protected ResultSet getFieldItemsById(ProductFields wantfeild, ProductFields checkfield, String whereID) {
		whereID = sneakyCheck(whereID);
		String qry = "select " + wantfeild.getFeild() + " from " + TableNames.PRODUCTS.getFeild() + " where "
				+ checkfield.getFeild() + " = " + whereID + ";";
		return executeQuery(qry);

	}

//select single from orders
	protected ResultSet getFieldOrdersById(OrderFields wantfeild, OrderFields checkfield, String whereID) {
		whereID = sneakyCheck(whereID);
		String qry = "select " + wantfeild.getFeild() + " from " + TableNames.ORDERS.getFeild() + " where "
				+ checkfield.getFeild() + " = " + whereID + ";";
		return executeQuery(qry);

	}

//select single(Set) from orderline;
	protected ResultSet getFieldOrderlineById(OrderLineFields wantfeild, OrderLineFields checkfield, String whereID) {
		whereID = sneakyCheck(whereID);
		String qry = "select " + wantfeild.getFeild() + " from " + TableNames.ORDERLINES.getFeild() + " where "
				+ checkfield.getFeild() + " = " + whereID + ";";
		return executeQuery(qry);

	}

//create new customer
	protected boolean createCust(String name1, String name2, String email) {
		try {// adding cust
			String qry = "insert into " + TableNames.CUSTOMERS.getFeild() + " values(0," + textSorS + name1 + textComma
					+ name2 + textComma + email + textSorS + comma + "0);";
			//System.out.println(qry);
			return execute(qry);
		} catch (Exception e) {
			return false;
		}
	}

//create new item
	protected boolean createItem(String name1, int amo, double price) {
		try {// adding cust
			String qry = "insert into " + TableNames.PRODUCTS.getFeild() + " values(0," + textSorS + name1 + textSorS
					+ comma + amo + comma + price + comma + "0);";
			return execute(qry);
		} catch (Exception e) {
			return false;
		}
	}

	public boolean createFullItem(int itemID, String name, int amount, double price) {
		try {// adding cust
			String qry = "insert into " + TableNames.PRODUCTS.getFeild() + " values(" + itemID + "," + textSorS + name
					+ textSorS + comma + amount + comma + price + comma + "0);";
			return execute(qry);
		} catch (Exception e) {
			return false;
		}
	}

//create new order (create new orderline)*
	protected boolean createOrder(Order_ completeOrder) {
		ArrayList<OrderLine_> lines = new ArrayList<>();
		// fetch lines from order to get items
		lines = completeOrder.getLines();
		// check item amounts exist (if not return false) throw...OrderNotValidException
		// with msg( item x has not enough stock to fufill this order)
		String qry;
		for (OrderLine_ ele : lines) {
			qry = "select" + ProductFields.AMOUNT.getFeild() + " from " + TableNames.PRODUCTS.getFeild() + " where "
					+ ProductFields.ID + " = " + ele.getItemId() + ";";
			if (ele.getItemAmo() <= selectInt(qry, ProductFields.AMOUNT.getFeild())) {
			} else {
				return false;
			}
		}
		// insert order into order tab
		String insord = "insert into " + TableNames.ORDERS.getFeild() + " values(" + completeOrder.getOrderId() + ","
				+ completeOrder.getCustId() + ");";
		boolean ordebool = execute(insord);
		// get Strings of orderline values like "(a,b,c),"
		//
		String values = "";
		for (OrderLine_ ele2 : lines) {
			// orderid , <0>, itemid,itemamo
			values = values + "(" + ele2.getOrderId() + comma + "0" + comma + ele2.getItemId() + comma
					+ ele2.getItemAmo() + "),";
		}
		// remove trailing comma
		boolean linesbool;
		if (values != "") {
			values = values.substring(0, values.length() - 1);
			// insert lines into orderline tab
			String inslines = "insert into " + TableNames.ORDERLINES.getFeild() + " values " + values + ";";
			linesbool = execute(inslines);
		} else {
			linesbool = true;
		} // return value of both executions being succesful.
		return ordebool && linesbool;
	}

	protected Order_ createOrder(int custId) {
		String qry = "insert into " + TableNames.ORDERS.getFeild() + " values(0," + custId + ");";
		boolean bool = execute(qry);
		if (bool) { // get most recent order with that cust number
			String qry2 = "select max(" + OrderFields.ORDERID.getFeild() + ") from " + TableNames.ORDERS.getFeild()
					+ " where " + OrderFields.CUSTID.getFeild() + " = " + custId + ";";
			ResultSet rs = executeQuery(qry2);
			int ordId = 0;
			try {
				while (rs.next()) {
					ordId = rs.getInt(1);
				}
				return new Order_(ordId, custId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

		} else {
			return null;
		}
	}

//delete customer
	protected boolean deleteCust(int id) {
		try {// adding cust
			String qry = "delete from " + TableNames.CUSTOMERS.getFeild() + " where " + CustFields.ID.getFeild() + " = "
					+ id + ";";
			//System.out.println(qry);
			return execute(qry);
		} catch (Exception e) {
			return false;
		}
	}

//delete item
	protected boolean deleteItem(int id) {
		try {// adding cust
			String qry = "delete from " + TableNames.PRODUCTS.getFeild() + " where " + ProductFields.ID.getFeild()
					+ " = " + id + ";";
			return execute(qry);
		} catch (Exception e) {
			return false;
		}
	}

//delete order (and orderline assoc)*
	protected boolean deleteOrder(Order_ deleteMe) {
		// delete from orderlines
		boolean linebool;
		if (deleteMe.getLines() != null || deleteMe.getLines().size() == 0) {
			String linedel = "delete from " + TableNames.ORDERLINES.getFeild() + " where "
					+ OrderLineFields.ID.getFeild() + " = " + deleteMe.getOrderId() + ";";
			linebool = execute(linedel);
		} else {
			linebool = true;
		}
		// delete from orders

		String ordedel = "delete from " + TableNames.ORDERS.getFeild() + " where " + OrderFields.ORDERID.getFeild()
				+ " = " + deleteMe.getOrderId() + ";";
		boolean ordebool = execute(ordedel);
		return linebool && ordebool;
	}

	// alternate solution
	protected boolean deleteOrder(int orderID) {
		// delete from orderlines
		String linedel = "delete from " + TableNames.ORDERLINES.getFeild() + " where " + OrderLineFields.ID.getFeild()
				+ " = " + orderID + ";";
		boolean linebool = execute(linedel);
		// delete from orders
		String ordedel = "delete from " + TableNames.ORDERS.getFeild() + " where " + OrderFields.ORDERID.getFeild()
				+ " = " + orderID + ";";
		boolean ordebool = execute(ordedel);
		return linebool && ordebool;
	}

	protected boolean deleteOrderLine(int orderId, int lineId) {
		String linedel = "delete from " + TableNames.ORDERLINES.getFeild() + " where " + OrderLineFields.ID.getFeild()
				+ " = " + orderId + " and " + OrderLineFields.LINE.getFeild() + " = " + lineId + ";";
		ResultSet rs = getOrderlineByKey(orderId, lineId);
		int itemamo = 0, itemId = 0;
		try {
			while (rs.next()) {
				itemId = rs.getInt(3);
				itemamo = rs.getInt(4);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean bool = execute(linedel);
		if (bool && itemId != 0) {
			//// TODO add itemsAMO back to items tab???
			boolean baal = updateItem(itemId, ProductFields.AMOUNT, "" + itemamo);
			return bool && baal;
		}
		return bool;
	}

	// updateorder (orderline)
	protected boolean updateOrderLine(int ordId, int lineId, OrderLineFields fld, String value) {
		value = sneakyCheck(value);
		// TODO include check that fld ,value pair is valid

		String qry = "update " + TableNames.ORDERLINES.getFeild() + " set " + fld.getFeild() + " = " + value + " where "
				+ OrderLineFields.ID.getFeild() + " = " + ordId + " and " + OrderLineFields.LINE.getFeild() + " = "
				+ lineId + ";";
		return execute(qry);

	}

	// updateOrder
	protected boolean updateOrder(int ordId, int newCustId) {
		String qry = "update " + TableNames.ORDERS.getFeild() + " set " + OrderFields.CUSTID.getFeild() + " = "
				+ newCustId + " where " + OrderFields.ORDERID.getFeild() + " = " + ordId + ";";
		return execute(qry);
	}

	// add a line to an existing Order
	protected int updateOrderAddLine(int orderID, int itemID, int itemAMO) throws SQLException {
		// TODO
		// if order exists
		ResultSet rs = getAllOrdersWhere(OrderFields.ORDERID, "" + orderID);
		if (!rs.next()) {
			return -1;
		}
//		check item and amount valid. 
		// item is a foregn key so we can just check amount here
		ResultSet rsI = getFieldItemsById(ProductFields.AMOUNT, ProductFields.ID, "" + itemID);
		rsI.next();
		int amo = rsI.getInt(1);
		if (amo < itemAMO) {
			return -1;
		}
		// try remove amount of items from itemTAB
		if (!updateItem(itemID, ProductFields.AMOUNT, "" + (amo -itemAMO))) {
			return -1;
		}
		// try add line to orderline tab
		boolean bool = createOrderLine(orderID, itemID, itemAMO);
		// fetch max(new) lineNumber to return
		if (bool) {
			String qry = "select " + OrderLineFields.LINE.getFeild() + " from " + TableNames.ORDERLINES.getFeild()
					+ " where " + OrderLineFields.ID.getFeild() + " = " + orderID + ";";
			ResultSet rs2 = executeQuery(qry);
			// get max lineNo
			int max = 0;
			while (rs2.next()) {
				int n = rs2.getInt(OrderLineFields.LINE.getFeild());
				if (n >= max) {
					max = n;
				}
			}
			return max;
		}
		// something has gone wrong.....
		return -2;
	}

	private boolean createOrderLine(int orderID, int itemID, int itemAMO) {
		// TODO Auto-generated method stub
		String qry = "insert into " + TableNames.ORDERLINES.getFeild() + " values(" + orderID + comma + "0" + comma
				+ itemID + comma + itemAMO + comma + "0);";
		return execute(qry);
	}

	// updatecustomer
	protected boolean updateCustomer(int custId, CustFields fld, String value) {
		value = sneakyCheck(value);
		String qry = "update " + TableNames.CUSTOMERS.getFeild() + " set " + fld.getFeild() + " = " + value + " where "
				+ CustFields.ID.getFeild() + " = " + custId + ";";
		return execute(qry);
	}
	// updateitem

	protected boolean updateItem(int itemId, ProductFields fld, String value) {
		value = sneakyCheck(value);
		String qry = "update " + TableNames.PRODUCTS.getFeild() + " set " + fld.getFeild() + " = " + value + " where "
				+ ProductFields.ID.getFeild() + " = " + itemId + ";";
		return execute(qry);
	}

	// helpers
	// see if a string input should get the "'" single sql quotemarks around it.
	private String sneakyCheck(String value) {
		try {
			Integer.parseInt(value);
			
			return value;
		} catch (Exception e) {
			// do nothing

		}
		try {
			Double.parseDouble(value);
			return value;
		} catch (Exception e) {
			// do nothing

		}

		return "\"" + value + "\"";
	}

	// select int from table
	protected int selectInt(String qry, String col) {
		ResultSet rs;// = executeQuery(qry);
		//System.out.println("++TEST++"+qry);
		int result;
		try {
			rs = executeQuery(qry);
			//System.out.println(qry);
			rs.next();
			// System.out.println(rs);
			result = rs.getInt(col);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	// select string from table
	protected String selectString(String qry, String col) {
		ResultSet rs;// = executeQuery(qry);

		String result;
		try {
			rs = executeQuery(qry);
			//System.out.println(qry);
			rs.next();
			// System.out.println(rs);
			result = rs.getString(col);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	// select boolean from table
	protected boolean selectBoolean(String qry, String col) {
		ResultSet rs;// = executeQuery(qry);

		boolean result;
		try {
			rs = executeQuery(qry);
			//System.out.println(qry);
			rs.next();
			// System.out.println(rs);
			result = rs.getBoolean(col);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// select double from table
	protected double selectDouble(String qry, String col) {
		ResultSet rs;// = executeQuery(qry);

		double result;
		try {
			rs = executeQuery(qry);
			//System.out.println(qry);
			rs.next();
			// System.out.println(rs);
			result = rs.getDouble(col);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0.0;
		}
	}

	// select newest
	protected ResultSet getMAX(TableNames table, String fld) {
		String qry = "select MAX(" + fld + ") from " + table.getFeild() + ";";
		ResultSet rs = executeQuery(qry);
		return rs;
	}

	private boolean execute(String qry) {
		try {
			//System.out.println(qry);
			stmnt.execute(qry);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private ResultSet executeQuery(String qry) {
		// System.out.println("++TEST++"+qry);
		ResultSet rs;
		try {
			rs = stmnt.executeQuery(qry);
			//System.out.println(qry);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}
		return rs;
	}

	public boolean checkConnection() {
		// check connection here
		try {
			dm = (DatabaseMetaData) conn.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected String getDbUrl() {
		return dbUrl;
	}

	public void close() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	protected boolean createCust(int i, String name1, String name2, String email) {
		// TODO Auto-generated method stub
		try {
			String qry = "insert into " + TableNames.CUSTOMERS.getFeild() + " values(" + i + "," + textSorS + name1
					+ textComma + name2 + textComma + email + textSorS + comma + "0);";
			//System.out.println(qry);
			return execute(qry);
		} catch (Exception e) {
			return false;
		}
	}

}