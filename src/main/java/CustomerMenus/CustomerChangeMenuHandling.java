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
	CustomerChangeMenuHandling(Scanner scanIn, CustomerMenu obj){
		upmenu = obj;
		scan = scanIn;
		csth = Factory.getCustomerHandler();
	}
	Customer_ handleMenuInputFetch(int intput){
		
		Customer_ cust = csth.getCustomer(intput); //check DB if exists ID then fill from deets returned
		return cust;
	}
	void handleMenuInputChange(int intput, Customer_ cust) {
		switch(intput) {
		case 1: System.out.println("enter new First Name:");
		 		String name = scan.nextLine();
		 		chan = csth.updateCust(cust, CustFields.NAME1, name);
		 		System.out.println("customer updated: "+(chan.getFirstname()==cust.getFirstname()));
//	 			System.out.println("success??");		 		
		 		
		 		break;		
		case 2:System.out.println("enter new Last Name:");
 			String nameL = scan.nextLine();
 			csth.updateCust(cust, CustFields.NAME2, nameL);
 			System.out.println("customer updated: "+(chan.getLastname()==cust.getLastname()));
// 			System.out.println("success??");
 			
 			break;
			
		case 3:System.out.println("enter new email:");
 			String email = scan.nextLine();
 			csth.updateCust(cust, CustFields.EMAIL, email);
 			System.out.println("customer updated: "+(chan.getEmail()==cust.getEmail()));
// 			System.out.println("success??");
 			
 			break;
			
		case 0:break;
		default: break;
			
		}
	}
}
