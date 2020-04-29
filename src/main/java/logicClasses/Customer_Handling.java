package logicClasses;

import java.util.ArrayList;

import InitClass.Factory;
import enums.CustFields;

public class Customer_Handling {
	private static Database_handling dbh;
	public Customer_Handling(){
		dbh = Factory.getDatabaseHandling();
	}
	protected Customer_Handling(String tst){
		dbh = Factory.getDatabaseHandling(tst);
	}
	
	public Customer_ createCust(Customer_ cust) {
		 dbh.createCust(cust.getId(),cust.getFirstname(), cust.getLastname(), cust.getEmail());
		int custId = dbh.getCustId(cust.getFirstname(),cust.getLastname(), cust.getEmail());
		Customer_ custer = new Customer_(custId, cust.getFirstname(), cust.getLastname(), cust.getEmail()/* cust vars */);
		return custer;
	}
	public Customer_ createCust(int id,String name1, String name2, String email) {
		// current just treat as new add to db, then fetch id generated to create cust
		// object
		dbh.createCust(id, name1, name2, email);
		int custId = dbh.getCustId(name1, name2, email);
		Customer_ custer = new Customer_(custId, name1, name2, email/* cust vars */);
		return custer;
	}
	public Customer_ updateCust(Customer_ cust, CustFields column, String value) {
		return updateCust(cust.getId(), column, value);
	}
	public Customer_ updateCust(int custId, CustFields column, String value/* some id var */) {
		// get by id
		Customer_ cust = null;
		if (dbh.updateCustFeild(custId, column, value)) {
			cust = dbh.getCustbyID(custId);
		}
		return cust;
	}
	public Customer_ getCustomer(int id) {
		return dbh.getCustbyID(id);
	}
	public boolean deleteCust(int id/* some id var */) {
		return dbh.deleteCust(id);
	}
	public boolean deleteCust(Customer_ cust) {
		return dbh.deleteCust(cust);
	}
	public ArrayList<Customer_> getAllCusts() {
		return dbh.getAllCusts();
	}

}
