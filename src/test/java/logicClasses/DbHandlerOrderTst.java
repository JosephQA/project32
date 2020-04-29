package logicClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import InitClass.Factory;

public class DbHandlerOrderTst {
	Database_handling dbh;
	Factory fact = new Factory();
	@Before
	public void seup() {
	System.out.println("_________setup____________");
	dbh = fact.getDatabaseHandling("test");
	System.out.println("check "+ !(null == dbh));
	Database_ db = dbh.getDatabase();
	System.out.println(db.suffix);
	dbh.createCust(101,"qqq", "www", "eee");
	dbh.createFullItem(101, "qqq", 87, 10.50);
	dbh.createFullItem(102, "www", 22, 22.00);
	Order_ ord =new Order_(101, 101); 
	dbh.createOrder(ord);
	System.out.println("________________________________");
	}
	@After
	public void Tdown() {
		System.out.println("___TDOWN____");
		dbh.deleteCust(101);
		dbh.deleteOrder(101);
		dbh.deleteItem(101);
		dbh.deleteItem(102);
		 System.out.println("________________________________");
	}
	@Test
	public void createOrder() {
		System.out.println("________CREATE ORDER__________");
		Order_ in = new Order_(102,101);
		dbh.createOrder(in);
		assertEquals(2, dbh.getAllOrders().size());
		dbh.deleteOrder(102);
		System.out.println("________________________________");
	}
	@Test
	public void deleteOrder() {
		System.out.println("________DELETE ORDER__________");
		dbh.deleteOrder(101);
			assertEquals(0, dbh.getAllOrders().size());
		System.out.println("________________________________");
	}
	@Test
	public void updateOrder() {
		System.out.println("________UPDATE ORDER__________");
		dbh.updateOrder(101, 999);
		assertEquals(999, dbh.getOrderById(101).getCustId());
		System.out.println("________________________________");
	}
	@Test
	public void getOrder() {
		System.out.println("________RETREIVE ORDER__________");
		assertEquals(Order_.class, dbh.getOrderById(101).getClass());
		System.out.println("________________________________");
	}
}
