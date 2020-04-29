package logicClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import InitClass.Factory;
import enums.OrderLineFields;


public class DbHandlerOrderlineTst {
	Database_handling dbh;
	@Before
	public void seup() {
	System.out.println("_________setup____________");
	dbh = Factory.getDatabaseHandling("test");
	System.out.println("check "+ !(null == dbh));
	Database_ db = dbh.getDatabase();
	System.out.println(db.suffix);
	dbh.createCust(101,"qqq", "www", "eee");
	dbh.createFullItem(101, "qqq", 87, 10.50);
	dbh.createFullItem(102, "www", 22, 22.00);
	Order_ ord =new Order_(101, 101); 
	dbh.createOrder(ord);
	System.out.println(dbh.createLine(101, 101, 12));
	System.out.println(dbh.createLine(101, 102, 10));
	System.out.println("________________________________");
	}
	@After
	public void Tdown() {
		System.out.println("___TDOWN____");
		
		dbh.deleteOrder(101);
		dbh.deleteCust(101);
		dbh.deleteItem(101);
		dbh.deleteItem(102);
		 System.out.println("________________________________");
	}
	@Test
	public void getOrderlines() {
		System.out.println("_________RETRIEVE ORDERLINES____");
		assertEquals(2, dbh.getLinesOrder(101).size());
		System.out.println("________________________________");
	}
	@Test
	public void createOrderLine() {
		System.out.println("_________CREATE ORDERLINES____");
		//coresponding to lines created in setup + 1 
		assertEquals(3, dbh.createLine(101, 101, 1));
		System.out.println("________________________________");
	}
	@Test
	public void updateOrderLine() {
		System.out.println("_________UPDATE ORDERLINES____");
		assertEquals(true , dbh.updateOrderLine(101, 2, OrderLineFields.ITEM, 101));
		System.out.println("________________________________");
		
	}
	@Test
	public void deleteOrderLine() {
		System.out.println("_________DELETE ORDERLINES____");
		assertEquals(true , dbh.deleteLine(101,	2));
		System.out.println("________________________________");
		
	}
}
