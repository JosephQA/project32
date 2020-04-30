package CustomerMenus;

import java.util.Scanner;

public class CustomerViewMenu {
	Scanner scan;
	CustomerMenu upmenu;
	CustomerViewMenuHandling handler;

	public CustomerViewMenu(Scanner scanIn, CustomerMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new CustomerViewMenuHandling(scan,this); 
		// TODO Auto-generated constructor stub
	}
	void startViewing() {
		String msg = "this is the Customer Viewing Menu\n"
				+ "beginning guided process for viewing customer details\n"
				+ "you may view an individual customer with thier CustomerID#\n"
				+ "enter number of option to continue\n"
				+ "1 : view a single customer with thier ID#\n"
				+ "2 : view all customers\n"  /*+DB.get number of customers....*/
				+ "0 : return to customer overview menu\n";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInput(choice,this);
		
	}
	public void success(String stri) {
		System.out.println(stri);
		
	}			

}
