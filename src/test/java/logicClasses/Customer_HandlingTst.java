package logicClasses;

import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import InitClass.Factory;
import enums.CustFields;

public class Customer_HandlingTst {
	Database_handling dbh;
	Customer_ tc1, tc2;
	Customer_Handling csth;

	@Before
	public void befro() {

		dbh = Factory.getDatabaseHandling("test");
		tc1 = new Customer_(101, "name11", "name21", "emaill1");
		tc2 = new Customer_(102, "name12", "name22", "emaill2");
		csth = new Customer_Handling("test");
	}

	@After
	public void aftre() {
		dbh.deleteCust(101);
		dbh.deleteCust(102);
		dbh.deleteCust(103);
	}

	@Test
	public void createCust() {
		System.out.println("______CREATE CUST________");
		assertEquals("name11", csth.createCust(101,"name11", "name21", "emaill1").getFirstname());
		assertEquals("name22", csth.createCust(tc2).getLastname());
		System.out.println("_________________________");
	}

	@Test
	public void updateCust() {
		System.out.println("______UPDATE CUST________");
		dbh.createCust(101,"name11", "name21", "emaill1");
		assertEquals("newname11", csth.updateCust(tc1, CustFields.NAME1, "newname11").getFirstname());
		assertEquals("newname22", csth.updateCust(101, CustFields.NAME2, "newname22").getLastname());
		System.out.println("_________________________");
	}

	@Test
	public void deleteCust() {
		System.out.println("______DELETE CUST________");
		dbh.createCust(103,"name11", "name21", "emaill1");
		assertEquals(true, csth.deleteCust(tc1));
		System.out.println("_________________________");
	}

	@Test
	public void getAllCusts() {
		System.out.println("______GET ALL CUST________");
		dbh.createCust(102,"name11", "name21", "emaill1");
		dbh.createCust(103,"name11", "name21", "emaill1");
		assertEquals(2, csth.getAllCusts().size());
		System.out.println("_________________________");

	}

	@Test
	public void getCust() {
		System.out.println("______GET ONE CUST________");
		dbh.createCust(103,"name11", "name21", "emaill1");
		assertEquals(103, csth.getCustomer(103).getId());
		System.out.println("_________________________");
	}
}
