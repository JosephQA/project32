package CustomerMenus;

import java.util.Scanner;

import InitClass.Factory;
import logicClasses.Customer_;
import logicClasses.Customer_Handling;

public class CustomerDeletionMenuHandling {
	CustomerDeletionMenu upmenu;
	Scanner scan;
	Customer_Handling csth;

	public CustomerDeletionMenuHandling(Scanner scanIn, CustomerDeletionMenu obj) {
		upmenu = obj;
		scan = scanIn;
		csth = Factory.getCustomerHandler();
	}

	Customer_ handleMenuInput(int intput) {

		Customer_ cust = null;
		try {
			cust = csth.getCustomer(intput);
			return cust;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		// check DB if exists ID then fill from deets returned
	}

	String handleMenuInputDelete(Customer_ cust) {
		String msg = "";
		boolean bool =  csth.deleteCust(cust);
		if (bool) {
			 msg = msg + "customer :"+cust.getId()+" deleted.";
		} else {
			msg = msg + "customer does not exist, check ID# and try again";
		
		}
		// check DB for cust existing
		// if yes..set DB.isDeleted =true return msg = "customer: "cust ID/name+"
		// DELETED"
		// if false msg = "customer does not exist, check ID# and try again"
		return msg;
	}

}
