 package CustomerMenus;

import java.util.Scanner;

import InitClass.HelloMenu;

public class CustomerMenu {
	Scanner scan;
	HelloMenu upmenu;
	
	public CustomerMenu(Scanner scanIn, HelloMenu obj) {
		scan = scanIn; upmenu = obj; 
	}
	public void displaymenu() {
		String menuString =( "this is the customer handling menu \n"
				+ "enter number of option to continue \n \n"
				+ "1 : create a customer\n"
				+ "2 : delete a customer\n"
				+ "3 : change a customers details\n"
				+ "4 : view all customers\n"
				+ "9 : recover a customer ( requires Customer ID# )\n"
				+ "0 : return to main menu" );
		System.out.println(menuString);
		CustomerMenuHandling handler = new CustomerMenuHandling(scan,this);
		//Scanner scan = new Scanner(System.in);
		
		int intput = scan.nextInt();
		//scan.close();
		handler.handleMenuInput(intput); 
	}

}
