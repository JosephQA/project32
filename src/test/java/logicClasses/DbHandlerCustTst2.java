package logicClasses;

import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import InitClass.Factory;
import enums.CustFields;

public class DbHandlerCustTst2 {
	
	// Database_ mdb;
	
	// Factory mFactory;

	 Database_handling dbh;
	
	ResultSet mRSet;
	
	 Customer_ tc1;
	 Customer_ tc2;
	
	@Before
	public void seup() {
		// TODO Auto-generated constructor stub
	System.out.println("_________setup____________");
		//mdb = mock(Database_.class);
//		Factory = mock(Factory.class);
		//when(Factory.getDatabase_("test")).thenReturn(mdb);
		//when(Database_handling.getDatabase()).thenReturn(mdb);
		dbh = Factory.getDatabaseHandling("test");
		System.out.println("check "+ !(null == dbh));
		Database_ db = dbh.getDatabase();
		System.out.println(db.suffix);
		dbh.createCust(101,"qqq", "www", "eee");
		
		System.out.println("________________________________");
		
		 tc1 = new Customer_(100, "qqq", "www", "eee");
		 tc2 = new Customer_(200, "aaa", "sss", "ddd");
	}
	@After
	public void tdown() {
		System.out.println("___TDOWN____");
		dbh.deleteCust(101);
		 System.out.println("________________________________");
	}
	@Test
	public void testcreatecust() {
		System.out.println("__CREATECUST____");
		ArrayList<Customer_> listo = dbh.getAllCusts();
		
		assertEquals(1,listo.size());
		 System.out.println("________________________________");
	}
	@Test
	public void testupdatecustField() {
		System.out.println("_____UPDATE CUST_______");
		assertEquals(true, dbh.updateCustFeild(101, CustFields.EMAIL, "newVal"));
		 System.out.println("________________________________");
	}
	@Test
	public void testgetCustbyId() throws SQLException {
		System.out.println("_____GET CUST_______");
		assertEquals(Customer_.class,dbh.getCustbyID(101).getClass()); 
		System.out.println("________________________________");
	}
	@Test
	public void testDeleteCust() {
		System.out.println("_____DELETE CUST_______");
		assertEquals(true, dbh.deleteCust(101));
		System.out.println("________________________________");
		
	}

}
