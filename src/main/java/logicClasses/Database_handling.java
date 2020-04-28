package logicClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import InitClass.Factory;
import InitClass.ScannerHandling;
import enums.CustFields;
import enums.OrderFields;
import enums.OrderLineFields;
import enums.ProductFields;
import enums.TableNames;

public class Database_handling {
	private Database_ db;
	private String istest = "";
	public Database_handling(String tst) {
		istest = tst;
		db = getDatabase();
	}
	public  Database_ getDatabase() {
		// TODO Auto-generated method stub
		Scanner scanIn = ScannerHandling.getScanner();
		
		if (db == null || !db.checkConnection()) { // if db not init or connectino has dropped get a new db
			db = Factory.getDatabase_(istest);
		}
		
		return db;
	}

	protected boolean createCust(String name1, String name2, String email) {
		//db = getDatabase();
		
		return db.createCust(name1, name2, email);
	}

	protected boolean updateCustFeild(int custId, CustFields column, String value) {
		//db = getDatabase();
		return db.updateCustomer(custId, column, value);
	}

	protected Customer_ getCustbyID(int id) {
		//db = getDatabase();
		ResultSet rs = db.getAllCustWhere(CustFields.ID, "" + id);
		int cuID = 0;
		String name1 = null, name2 = null, email = null;
		try {
			while (rs.next()) {
				cuID = rs.getInt(1);
				name1 = rs.getString(2);
				name2 = rs.getString(3);
				email = rs.getString(4);
			}
			Customer_ c = new Customer_(cuID, name1, name2, email);
			return c; // cust
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	protected int getCustId(String name1, String name2, String email) {
		//db = getDatabase();
		String qry = "select " + CustFields.ID.getFeild() + " from " + TableNames.CUSTOMERS.getFeild() + " where "
				+ CustFields.NAME1.getFeild() + " = " + name1 + " and " + CustFields.NAME2.getFeild() + " = " + name2
				+ ";";
		int custId = db.selectInt(qry, CustFields.ID.getFeild());
		return custId;
	}

	protected boolean deleteCust(Customer_ cust) {
		//db = getDatabase();
		// dont trust local ID's
		String qry = "delete from " + TableNames.CUSTOMERS.getFeild() + " where " + CustFields.NAME1.getFeild() + " = "
				+ cust.getFirstname() + " and " + CustFields.NAME2.getFeild() + " = " + cust.getLastname() + " and "
				+ CustFields.EMAIL.getFeild() + " = " + cust.getEmail() + ";";
		System.out.println(qry);
		int id = db.selectInt(qry, CustFields.ID.getFeild());
		return deleteCust(id);
	}

	protected boolean deleteCust(int Id) {
		//db = getDatabase();
		return db.deleteCust(Id);
	}

	protected ArrayList<Customer_> getAllCusts() {
		//db = getDatabase();
		ArrayList<Customer_> retList = new ArrayList<Customer_>();
		int custId;
		String name1 = null, name2 = null, email = null;
		ResultSet rs = db.getAllCusts();
		try {
			while (rs.next()) {
				custId = rs.getInt(1);
				name1 = rs.getString(2);
				name2 = rs.getString(3);
				email = rs.getString(4);
				retList.add(new Customer_(custId, name1, name2, email));
			}
			return retList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	protected boolean createOrder(Order_ ord) {
		// TODO Auto-generated method stub
		//db = getDatabase();
		return db.createOrder(ord);
	}
	protected Order_ createOrder(int custId) {
		//db = getDatabase();
		return db.createOrder(custId);
	}

	protected Order_ getOrderById(int id) {
		//db = getDatabase();
		int orderId = 0, custId = 0;
		ResultSet rs = db.getAllOrdersWhere(OrderFields.ORDERID, "" + id);
		try {
			while (rs.next()) {
				orderId = rs.getInt(1);
				custId = rs.getInt(2);
			}
			return new Order_(orderId, custId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected ArrayList<Order_> fetchAllOrders() {
		//db = getDatabase();
		ArrayList<Order_> retArr = new ArrayList<Order_>();
		ResultSet rs = db.getAllOrders();
		try {
			while (rs.next()) {
				retArr.add(new Order_(rs.getInt(1), rs.getInt(2)));
			}
			return retArr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected boolean deleteOrder(int orderId) {
		//db = getDatabase();
		return db.deleteOrder(orderId);
	}

	protected boolean updateOrder(int orderId, int newCustId) {
		//db = getDatabase();
		return db.updateOrder(orderId, newCustId);
	}

	protected ArrayList<OrderLine_> getOrderLines(int ordId) {
		//db = getDatabase();
		db.getAllCusts();
		ArrayList<OrderLine_> retArr = new ArrayList<OrderLine_>();
		ResultSet rs = db.getAllOrderLineWhere(OrderLineFields.ID, "" + ordId);
		int lordid = 0, lline = 0, litem = 0, lamo = 0;
		try {
			while (rs.next()) {
				lordid = rs.getInt(1);
				lline = rs.getInt(2);
				litem = rs.getInt(3);
				lamo = rs.getInt(4);
				retArr.add(new OrderLine_(lordid, lline, litem, lamo));
			}
			return retArr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	protected double getLinePrice(int itemId) {
		//db = getDatabase();
		ResultSet rs = db.getFieldItemsById(ProductFields.PRICE, ProductFields.ID, "" + itemId);
		try {
			rs.next();
			double cost = rs.getDouble(1);
			//System.out.println("++TEST++pricedb:"+cost);
			return cost;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;

		}

	}

	protected int createLine(int orderID, int itemID, int itemAMO)  {
		//db = getDatabase();
		int lineID = -1;
		try {
			lineID = db.updateOrderAddLine(orderID, itemID, itemAMO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lineID;
	}

	protected ArrayList<OrderLine_> getLinesOrder(int ordID) {
		//db = getDatabase();
		ArrayList<OrderLine_> retArr = new ArrayList<OrderLine_>();
		// convert to lineobjects and add to ret arr
		int linordid, linenum, lineitemid, lineitemamo;
		try {
			ResultSet rss = db.getAllOrderLineWhere(OrderLineFields.ID, "" + ordID);
			
			while(rss.next()){
				linordid = rss.getInt(OrderLineFields.ID.getFeild());
				linenum = rss.getInt(OrderLineFields.LINE.getFeild());
				lineitemid = rss.getInt(OrderLineFields.ITEM.getFeild());
				lineitemamo = rss.getInt(OrderLineFields.AMOUNT.getFeild());
				retArr.add(new OrderLine_(linordid, linenum, lineitemid, lineitemamo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("+TEST+"+retArr.size());
		}

		return retArr;
	}

	protected boolean updateOrderLine(int orderID, int lineID, OrderLineFields fld, int itemvar) {
		//db = getDatabase();
		return db.updateOrderLine(orderID, lineID, fld, "" + itemvar);
		
	}

	protected boolean deleteLine(int orderID, int lineID) {
		//db = getDatabase();

		return db.deleteOrderLine(orderID, lineID);
	}

	protected OrderLine_ getOrderLine(int ordID, int lineID) {
		//db = getDatabase();
		ResultSet rs = db.getOrderlineByKey(ordID, lineID);

		try {
			while (rs.next()) {
				OrderLine_ line = new OrderLine_(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				return line;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
		return null;
	}

	protected Item_ createFullItem(int itemID, String name, int amount, double price) {
		//db = getDatabase();
		boolean bool = db.createFullItem(itemID, name, amount, price);
		if (bool) {
			Item_ item = new Item_(name, itemID, amount, price);
			return item;
		}
		return null;
	}
	protected ArrayList<Item_> getAllItems(){
		ResultSet rs = db.getAllItems();
		ArrayList<Item_> list = new ArrayList<Item_>();
		try {
			while(rs.next()) {
				Item_ i  = new Item_(rs.getString(ProductFields.NAME.getFeild()),
						rs.getInt(ProductFields.ID.getFeild()),
						rs.getInt(ProductFields.AMOUNT.getFeild()),
						rs.getDouble(ProductFields.PRICE.getFeild()));
				list.add(i);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return list;
	}

	protected Item_ createItem(String name, int amount, double price) {
		//db = getDatabase();
		boolean bool = db.createItem(name, amount, price);
		if (bool) {
			ResultSet rs = db.getMAX(TableNames.PRODUCTS, ProductFields.ID.getFeild());
			try {
				rs.next();
				int itemID = rs.getInt(1);
				Item_ item = new Item_(name, itemID, amount, price);
				return item;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	protected Item_ getItemById(int iD) {
		//db = getDatabase();
		ResultSet rs = db.getAllItemssWhere(ProductFields.ID, "" + iD); // id is key so the loop is valid here
		try {
			while (rs.next()) {
				return new Item_(rs.getString(2), rs.getInt(1), rs.getInt(3), rs.getDouble(4));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	protected ArrayList<Item_> getItemsbyName(String name) {
		//db = getDatabase();
		ArrayList<Item_> retArr = new ArrayList<Item_>();
		ResultSet rs = db.getAllItemssWhere(ProductFields.NAME, name);
		try {
			while (rs.next()) {
				retArr.add(new Item_(rs.getString(2), rs.getInt(1), rs.getInt(3), rs.getDouble(4)));
			}
			return retArr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected Item_ updateItem(int iD, ProductFields fld, String value) {
		//db = getDatabase();

		if (db.updateItem(iD, fld, value)) {
			ResultSet rs = db.getAllItemssWhere(ProductFields.ID, "" + iD);
			try {
				while (rs.next()) {
					return new Item_(rs.getString(2), rs.getInt(1), rs.getInt(3), rs.getDouble(4));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return null;
	}

	protected boolean deleteItem(int iD) {
		//db = getDatabase();
		return db.deleteItem(iD);
	}
	protected boolean createCust(int i, String string, String string2, String string3) {
		return db.createCust(i, string,string2,string3);
		
	}
	protected ArrayList<Order_> getAllOrders() {
		ArrayList<Order_> list = new ArrayList<Order_>();
			ResultSet rs = db.getAllOrders();
			try {
				while(rs.next()) {
					Order_ o = new Order_(rs.getInt(OrderFields.ORDERID.getFeild()),
											rs.getInt(OrderFields.CUSTID.getFeild()));
					list.add(o);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		return list;
	}

}
