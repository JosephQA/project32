package logicClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import InitClass.Factory;

public class Order_Tst {
	Order_ ordT;
	Item_ itemT;
	OrderLine_ lineT;
	@Before
	public void befro() {
		ordT = new Order_(0, 101);
		itemT = new Item_("name", 101, 100, 10.00);
		lineT = new OrderLine_(0, 1, 101, 15,"test");
	}
	@After
	public void aftre() {
		ordT =null;
		itemT = null;
	}
	@Test
	public void Order_() {
		assertEquals(ordT.getCustId()+ordT.getOrderId(), new Order_(101).getCustId()+ new Order_(101).getOrderId());
	}
	@Test
	public void addItem() {
	ordT.addItem(itemT ,12);
	assertEquals(1, ordT.getLines().size());
	}
	@Test
	public void addorderline() {
		ordT.addOrderLine(lineT);
		assertEquals(1,ordT.getLines().size());
	}
	@Test
	public void calcprice() {
		Database_handling dbh = Factory.getDatabaseHandling("test");
		dbh.createFullItem(itemT.getItemId(), itemT.getItemName(), itemT.getItemAmo(), itemT.getItemPrice());
		
		ordT.addOrderLine(lineT);
		assertEquals(itemT.getItemPrice()*15, ordT.calcPrice(),0);
		dbh.deleteItem(itemT.getItemId());
	}
}
