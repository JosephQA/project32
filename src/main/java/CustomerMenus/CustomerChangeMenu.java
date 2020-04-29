 package CustomerMenus;
import java.util.Scanner;

import logicClasses.Customer_;

public class CustomerChangeMenu {
	Scanner scan;
	CustomerMenu upmenu;
	CustomerChangeMenuHandling handler;

	public CustomerChangeMenu(Scanner scanIn, CustomerMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new CustomerChangeMenuHandling(scan, upmenu);

	}

	void startChanging() {
		String msg = "this is the Customer Changing Menu"
				+ "beginning guided proces for changing a customer's details\n"
				+ "you are expected to have the customers ID# ready\n";
		System.out.println(msg);
		System.out.println("please enter CustomerID# to change or \"-0\" to exit");
		int custNum = scan.nextInt();
		if (custNum != -0) {
			Customer_ changer = handler.handleMenuInputFetch(custNum);
			if (changer != null) {
				continueChanging(changer);
			} else {
				System.out.println("customer " + custNum + " does not exist in database");
			}
			System.out.println("returning to Customer handling menu...");
			upmenu.displaymenu();

		} else {
			System.out.println("returning to Customer handling menu...");
			upmenu.displaymenu();
		}

	}

	void continueChanging(Customer_ cust) {
		String msg = "select customer value to change" + "1 : first name"  + cust.getFirstname()
				+ "\n2 : last name"  +cust.getLastname()
				+ "\n3 : email address" +cust.getEmail()
				+ "\n0 : abort changing details";

		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInputChange(choice, cust);
	}
}
