package CustomerMenus;

import java.util.Scanner;

public class CustomerRecoveryMenu {
	Scanner scan;
	CustomerMenu upmenu;
	CustomerRecoverymenuHandling handler;

	public CustomerRecoveryMenu(Scanner scanIn, CustomerMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new CustomerRecoverymenuHandling(scan, upmenu); 
		
	}
	void startRecovery() {
		String msg = "this is the Customer Recovery menu\n"
				+ "for recovering deleted customers\n"
				+ "enter number of option to continue\n"
				+ "1 : recover a customer with customerID#"
				+ "0 : return to customer menu";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInput(choice);
		upmenu.displaymenu();
	}

}
