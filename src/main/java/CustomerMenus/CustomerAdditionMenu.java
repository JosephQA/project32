 package CustomerMenus;

import java.util.Scanner;

public class CustomerAdditionMenu {
	Scanner scan;
	CustomerMenu upmenu;
	public CustomerAdditionMenu(Scanner scanIn, CustomerMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}
	void startAdding() {
		System.out.println("this is the Customer Addition/Creation Menu\n"
				+ "begining guided process for creating cutomer\n"
				+ "you will be expected to have ready: Full Name, email adress\n"
				+ "there is an option to restart/confirm/discard at the end of\n"
				+ " the guided process");
		System.out.println("enter customer 1st name");
		
		String firstname = scan.next();
		
		System.out.println("enter customer last name");
		String lastname = scan.next();
		System.out.println("enter customer email adress");
		String emailadress = scan.next();
		System.out.println("details entered \n"
				+ "first name : "+firstname +"\n"
				+ "last name  : "+lastname+"\n"
				+ "email      : "+emailadress+"\n");
		System.out.println("select action for this customer addition\n"
				+ "1 : add customer\n"
				+ "2 : re-enter details\n"
				+ "0 : discard addition and return to customer menu");
		int choice = scan.nextInt();
		CustomerAdditionMenuHandling handling = new CustomerAdditionMenuHandling(scan, this);
		handling.handleMenuInput(choice);

		
		
	}
}
