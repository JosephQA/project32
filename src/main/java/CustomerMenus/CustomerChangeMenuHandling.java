package CustomerMenus;

import java.util.Scanner;

import InitClass.Factory;
import enums.CustFields;
import logicClasses.Customer_;
import logicClasses.Customer_Handling;

public class CustomerChangeMenuHandling {
	Scanner scan;
	CustomerMenu upmenu;
	Customer_Handling csth;
	Customer_ chan;
	Factory f = Factory.getFactory();

	CustomerChangeMenuHandling(Scanner scanIn, CustomerMenu obj) {
		upmenu = obj;
		scan = scanIn;
		csth = f.getCustomerHandler();
	}

	Customer_ handleMenuInputFetch(int intput) {

		Customer_ cust = csth.getCustomer(intput); // check DB if exists ID then fill from deets returned
		return cust;
	}

	void handleMenuInputChange(int intput, Customer_ cust) {
		switch (intput) {
		case 1:
			System.out.println("enter new First Name:");
			scan.nextLine(); System.out.println("");
			String name = scan.nextLine();
			chan = csth.updateCust(cust, CustFields.NAME1, name);
			if (chan != null) {
				System.out.println("customer updated: " + (cust.getFirstname()!= chan.getFirstname()));
//	 			System.out.println("success??");		 		
			} else {
				System.out.println("Customer not found in DB");
			}
			break;
		case 2:
			System.out.println("enter new Last Name:\n");
			scan.nextLine();
			String nameL = scan.nextLine();
			chan =csth.updateCust(cust, CustFields.NAME2, nameL);
			if (chan != null) {
				System.out.println("customer updated: " + (cust.getLastname()!= chan.getLastname()));
// 			System.out.println("success??");
			} else {
				System.out.println("Customer not found in DB");
			}
			break;

		case 3:
			System.out.println("enter new email:\n");scan.nextLine();
			String email = scan.nextLine();
			chan =csth.updateCust(cust, CustFields.EMAIL, email);
			if (chan != null) {
				System.out.println("customer updated: " + ( cust.getEmail()!= chan.getEmail()));
// 			System.out.println("success??");
			} else {
				System.out.println("Customer not found in DB");
			}
			break;

		case 0:
			break;
		default:
			break;

		}
	}
}
