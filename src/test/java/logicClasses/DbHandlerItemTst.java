package logicClasses;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import InitClass.Factory;
import enums.ProductFields;

public class DbHandlerItemTst {
	Factory f  = new Factory();
	Database_handling dbh;
	@Before
	public void seup() {
		System.out.println("_________setup____________");
		dbh = f.getDatabaseHandling("test");
		System.out.println("check "+ !(null == dbh));
	Database_ db = dbh.getDatabase();
	System.out.println(db.suffix);
	dbh.createFullItem(101, "qqq", 87, 10.50);
	System.out.println("________________________________");
	}
	@After
	public void Tdown() {
		dbh.deleteItem(101);
	}
	@Test
	public void createItem() {
		System.out.println("_______CREATE ITEM_____________");
		dbh.createFullItem(102,"temp",12,99.99);
		assertEquals(2, dbh.getAllItems().size());
		System.out.println("________________________________");
		dbh.deleteItem(102);
	}
	@Test
	public void retreiveitem() {
		System.out.println("__________GET ITEM______________");
		assertEquals(Item_.class,dbh.getItemById(101).getClass());
		System.out.println("________________________________");
	}
	@Test
	public void updateItem() {
		System.out.println("_________UPDATE ITEM______________");
		assertEquals("newname", dbh.updateItem(101, ProductFields.NAME, "newname").getItemName());
		System.out.println("________________________________");
	}
	@Test
	public void deleteItem() {
		System.out.println("________DELETE ITEM____________");
		assertEquals(true, dbh.deleteItem(101));
		System.out.println("________________________________");
	}
	@Test public void getallitem() {
		System.out.println("__________GET ALL ITEM___________");
		assertEquals(1,dbh.getAllItems().size());
		System.out.println("________________________________");
	}
}
