package logicClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import InitClass.Factory;

public class OrderLine_HandlerTst2 {
	OrderLine_handling olh;
	Database_handling dbh;
	OrderLine_ line = new OrderLine_(101, 1, 101, 12);
	Item_ item = new Item_("testItem", 101, 500, 32.54);
	Order_ ord = new Order_(101, 101);
	Customer_ cust = new Customer_(101, "name1", "name2", "emaill");
	@Before
	public void befro() {
		System.out.println("_______SETUP ORDDERLINE_______");
		olh = Factory.getOrderlinehandler("test");
		dbh = Factory.getDatabaseHandling("test");
		System.out.println("check "+ !(null == dbh));
		System.out.println("create cust");
		dbh.createCust(cust.getId(), cust.getFirstname(), cust.getLastname(), cust.getEmail());
		System.out.println("create order");
		dbh.createOrder(ord);
		System.out.println("create item");
		dbh.createFullItem(item.getItemId(), item.getItemName(), item.getItemAmo(), item.getItemPrice());
		System.out.println("create line");
		dbh.createLine(101, item.getItemId(), line.getItemAmo());
	}
	@After
	public void aftre() {
		System.out.println("_______TEARDOWN ORDERLINE_________");
		dbh.deleteLine(101, 1);
		dbh.deleteItem(101);
		dbh.deleteOrder(101);
		dbh.deleteCust(101);
	}
	
	@Test
	public void linePrice() {
		System.out.println("_______LINEPRICE ORDERLINE_________");
		double expeceted = (item.getItemPrice()*line.getItemAmo());
		assertEquals(expeceted,olh.getLinePrice(line),0);
		System.out.println("__________________________________");
	}
	@Test 
	public void pricedLine() {
		System.out.println("_______PRICED ORDERLINE_________");
		OrderLine_ lne = new OrderLine_(101, 1, 101, 12);
		lne.setLinePrice();
		assertEquals(lne.getLinePrice(), olh.getPricedLine(line).getLinePrice(),0);
		System.out.println("__________________________________");
	}
	@Test
	public void createLine() {
		System.out.println("_________CREATE LINE______________");
		assertEquals(OrderLine_.class,olh.createLine(line).getClass());
		System.out.println("__________________________________");
	}
	
}
