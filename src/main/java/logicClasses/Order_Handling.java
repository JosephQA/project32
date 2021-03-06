package logicClasses;

import java.util.ArrayList;

import InitClass.Factory;

public class Order_Handling {
	private static Database_handling dbh;
Factory f;
	public Order_Handling() {
		init();
		f = Factory.getFactory();
//		System.out.println("+++TEST+++");
		dbh = f.getDatabaseHandling(""); 
//		System.out.println("-TEST-");
	}
	public boolean init() {
		return true;
	}
	public boolean createOrderInDB(Order_ ord) {
		return dbh.createOrder(ord);
	}
	public Order_ createOrderInDB(int custId) {
		
		return dbh.createOrder(custId);
	}

	public Order_ getOrderbyId(int id) {
		return dbh.getOrderById(id);
	}

	public ArrayList<Order_> getAllOrder() {
		return dbh.fetchAllOrders();
	}

	public boolean deleteOrder(int orderId) {
		return dbh.deleteOrder(orderId);
	}

	public boolean deleteOrder(Order_ ord) {
		return deleteOrder(ord.getOrderId());
	}

	public boolean updateOrder(int orderId, int newCustId) {
		return dbh.updateOrder(orderId, newCustId);
	}

	public ArrayList<OrderLine_> getOrderLines(int ordId) {
		return dbh.getOrderLines(ordId);
	}
}
