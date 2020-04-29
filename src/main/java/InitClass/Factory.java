package InitClass;

import OrderMenus.OrderViewMenuHandling;
import logicClasses.Customer_Handling;
import logicClasses.Database_;
import logicClasses.Database_handling;
import logicClasses.Item_Handling;
import logicClasses.OrderLine_handling;
import logicClasses.Order_Handling;

public class Factory {
	private static OrderLine_handling olh;
	private static Customer_Handling ch;
	private static Order_Handling oh;
	private static Item_Handling ih;
	private static Database_handling dbh;
	private static Database_ db;
	private static Factory thiss;
	
	public static Factory getFactory() {
		if(thiss!=null) {
			return thiss;
		}else {thiss=new Factory(); return thiss;}
	}
	public  OrderLine_handling getOrderlinehandler() {
		// TODO Auto-generated method stub
		if (olh != null) {
			return olh;
		} else {
			olh = new OrderLine_handling();
			return olh;
		}
	}
	public  OrderLine_handling getOrderlinehandler(String str) {
		// TODO Auto-generated method stub
		if (olh != null) {
			return olh;
		} else {
			olh = new OrderLine_handling(str);
			return olh;
		}
	}

	public Customer_Handling getCustomerHandler() {
		if (ch != null) {
			return ch;
		} else {
			ch = new Customer_Handling();
			return ch;
		}
	}

	public Order_Handling getOrderHandler() {
		if (oh != null) {
//			System.out.println("notnull");
			return oh;
		} else {
//			System.out.println("null");
			oh = createOrderHan();
			return oh;
		}
	}
	private Order_Handling createOrderHan() {
//		System.out.println("still null");
		Order_Handling ordhan =new Order_Handling();
//		System.out.println("evennuller?");
		return ordhan;
	}

	public  Item_Handling getItemHandler() {
		if (ih != null) {
			return ih;
		} else {
			ih = new Item_Handling();
			return ih;
		}
	}

	public  Database_handling getDatabaseHandling(String tst) {
		//if(tst == "test") { dbh = new TestBase_Handling();return dbh; }
		if (dbh != null) { System.out.println("--TEST--");
			return dbh;
		} else {
			dbh = new Database_handling(tst);
			System.out.println("---TEST---");
			return dbh;
		}
	}
	public Database_handling getDatabaseHandling() {
		//if(tst == "test") { dbh = new TestBase_Handling();return dbh; }
		if (dbh != null) {
			return dbh;
		} else {
			dbh = new Database_handling("");
			return dbh;
		}
	}

	public  Database_ getDatabase_(String tst) {
		//if(tst == "test") {System.out.println("check 1"+ (null == db));;db =  new TestBase_();;return db;}
		if (db != null) {
			return db;
		} else {
			db = new Database_(tst);
			return db;
		}
	}
	public  Database_ getDatabase_() {
		//if(tst == "test") {System.out.println("check 1"+ (null == db));;db =  new TestBase_();;return db;}
		if (db != null) {
			return db;
		} else {
			db = new Database_("");
			return db;
		}
	}
	
}
