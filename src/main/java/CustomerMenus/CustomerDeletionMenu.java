 

import java.util.Scanner;
import logicClasses.Customer_;

public class CustomerDeletionMenu {
	Scanner scan;
	CustomerMenu upmenu;
	CustomerDeletionMenuHandling handler;
	public CustomerDeletionMenu(Scanner scanIn, CustomerMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new CustomerDeletionMenuHandling(scan, this);
	}
	void startDeleting() {
		String msg = "This is the Customer Deletion Menu"
				+ "beggining guided process for deleting a customer\n"
				+ "you are expected to have ready: CustomerID#";
		System.out.println(msg);
		System.out.println("please enter CustomerID# or \"-0\" to exit");
		int custNum = scan.nextInt();
		if(custNum != -0) {
			//CustomerDeletionMenuHandling handler = new CustomerDeletionMenuHandling(scan, this);
			Customer_ deleter = handler.handleMenuInput(custNum);
			System.out.println(continueDeleting(deleter));
			System.out.println("returning to Customer handling menu...");
			upmenu.displaymenu();
			
		}else {
			System.out.println("returning to Customer handling menu...");
			upmenu.displaymenu();
		}
	}
	String continueDeleting(Customer_ custDel) {
		return handler.handleMenuInputDelete(custDel);
	}
}
