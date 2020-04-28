package InitClass;

import java.util.Scanner;

import CustomerMenus.CustomerMenu;
import ItemMenus.ItemMenu;
import OrderMenus.OrderMenu;

public class HelloMenu {
	Scanner scanIn;
	HelloMenu(Scanner scan){scanIn = scan;}
	public void displayMenu() {
		int choice = 0;
		String welcomeMsg = "welcome , this is start menu \n"
				+ " enter number of option to continue"
				+ "\n\n"
				+ " 1 : handle customers \n 2 : handle items \n"
				+ " 3 : handle orders \n 0 : Exit/stop ";
		System.out.println(welcomeMsg);
		//Scanner ScanIn = new Scanner(System.in);
		//try {
		
		 choice = scanIn.nextInt();
		//ScanIn.close();
		//}catch(IOException e) { }
		
		this.handleMenuInput(choice);
		//ScanIn.close();
	}
	protected void handleMenuInput(int intput) {
		switch (intput) {
		case 1: 
			System.out.println("you want to handle customers");
			//begin customer handling
			CustomerMenu menucust = new CustomerMenu(scanIn,this);
			menucust.displaymenu();
			break;
		case 2: 
			System.out.println("you want to handle items");
			ItemMenu menuitem = new ItemMenu(scanIn,this);
			menuitem.displaymenu();
			//begin item handling
			break;
		case 3: 
			System.out.println("you want to handle orders");
			//begin order handling
			OrderMenu menuorder = new OrderMenu(scanIn,this);
			menuorder.displayMenu();
			break;
		case 0: System.out.println("exiting");
			
			break;
		
		default: System.out.println("not recognised: enter 1, 2, 3 or 0");
//			Scanner scan = new Scanner(System.in);
			int take2 =scanIn.nextInt();
			handleMenuInput(take2);
			//scan.close();
		}
	}

}
